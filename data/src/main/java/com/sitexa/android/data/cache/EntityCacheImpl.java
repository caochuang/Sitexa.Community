/*
 *   Copyright (C) 2015 Sitexa Open Source Project
 *   <p>
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *   <p>
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   <p>
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.sitexa.android.data.cache;

import android.content.Context;

import com.sitexa.android.data.cache.serializer.EntityJsonSerializer;
import com.sitexa.android.data.exception.EntityNotFoundException;
import com.sitexa.android.domain.executor.ThreadExecutor;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by xnpeng on 15-9-6.
 * 写一个通用缓存类型
 */
@Singleton
public class EntityCacheImpl implements EntityCache {

    private static final String SETTINGS_FILE_NAME = "com.sitexa.android.SETTINGS";
    private static final String SETTINGS_KEY_LAST_CACHE_UPDATE = "last_cache_update";

    //private static final String DEFAULT_FILE_NAME = "entity_";
    private static final long EXPIRATION_TIME = 60 * 10 * 1000;

    private final Context context;
    private final EntityJsonSerializer serializer = new EntityJsonSerializer();
    private final File cacheDir;
    private final FileManager fileManager;
    private final ThreadExecutor threadExecutor;

    @Inject
    public EntityCacheImpl(Context context, File cacheDir, FileManager fileManager, ThreadExecutor threadExecutor) {
        if (context == null || fileManager == null || threadExecutor == null) {
            throw new IllegalArgumentException("Invalid null parameter");
        }
        this.context = context;
        this.cacheDir = cacheDir;
        this.fileManager = fileManager;
        this.threadExecutor = threadExecutor;
    }

    @Override
    public synchronized <T> Observable<T> get(String id, Class<?> aClass) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                File entityFile = EntityCacheImpl.this.buildFile(id);
                String fileContent = EntityCacheImpl.this.fileManager.readFileContent(entityFile);
                T entity = EntityCacheImpl.this.serializer.deserialize(fileContent, aClass);
                if (entity != null) {
                    subscriber.onNext(entity);
                    subscriber.onCompleted();
                } else {
                    subscriber.onError(new EntityNotFoundException());
                }
            }
        });
    }

    @Override
    public synchronized <T> void put(String id, T entity) {
        if (entity != null) {
            File entityFile = this.buildFile(id);
            if (!isCached(id)) {
                String jsonString = this.serializer.serialize(entity);
                this.executeAsynchronously(new CacheWriter(this.fileManager, entityFile, jsonString));
                setLastCacheUpdateTimeMillis();
            }
        }
    }

    @Override
    public boolean isCached(String id) {
        File entityFile = this.buildFile(id);
        return this.fileManager.exists(entityFile);
    }

    @Override
    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();
        long lastUpdateTime = this.getLastCacheUpdateTimeMillis();

        boolean expired = ((currentTime - lastUpdateTime) > EXPIRATION_TIME);

        if (expired) {
            this.evictAll();
        }

        return expired;
    }

    @Override
    public synchronized void evictAll() {
        this.executeAsynchronously(new CacheEvictor(this.fileManager, this.cacheDir));
    }

    /**
     * Build a file, used to be inserted in the disk cache.
     *
     * @param id The id user to build the file.
     * @return A valid file.
     */
    private File buildFile(String id) {
        //todo Check this line,Can I get the filename from this.getClass()?
        String filename = this.getClass().getSimpleName();

        StringBuilder fileNameBuilder = new StringBuilder();
        fileNameBuilder.append(this.cacheDir.getPath());
        fileNameBuilder.append(File.separator);
        //fileNameBuilder.append(DEFAULT_FILE_NAME);
        fileNameBuilder.append(filename);
        fileNameBuilder.append(id);

        return new File(fileNameBuilder.toString());
    }

    /**
     * Set in millis, the last time the cache was accessed.
     */
    private void setLastCacheUpdateTimeMillis() {
        long currentMillis = System.currentTimeMillis();
        this.fileManager.writeToPreferences(this.context, SETTINGS_FILE_NAME,
                SETTINGS_KEY_LAST_CACHE_UPDATE, currentMillis);
    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
    private long getLastCacheUpdateTimeMillis() {
        return this.fileManager.getFromPreferences(this.context, SETTINGS_FILE_NAME,
                SETTINGS_KEY_LAST_CACHE_UPDATE);
    }

    /**
     * Executes a {@link Runnable} in another Thread.
     *
     * @param runnable {@link Runnable} to execute
     */
    private void executeAsynchronously(Runnable runnable) {
        this.threadExecutor.execute(runnable);
    }
}
