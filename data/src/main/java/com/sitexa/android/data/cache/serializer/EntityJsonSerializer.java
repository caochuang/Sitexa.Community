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

package com.sitexa.android.data.cache.serializer;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by xnpeng on 15-9-6.
 * 写一个通用类，用来对json和entity进行序列化和反系列化.
 */
@Singleton
public class EntityJsonSerializer {

    static Class<?> instance = null;

    private final Gson gson = new Gson();

    @Inject
    public EntityJsonSerializer() {
    }

    public <T> String serialize(T entity) {
        String jsonString = gson.toJson(entity, entity.getClass());
        return jsonString;
    }

    //如何获取运行时泛型的class?
    public <T> T deserialize(String jsonString) {
        instance = (Class<T>) new Object();
        T entity = (T) gson.fromJson(jsonString, instance.getClass());
        return entity;
    }

}
