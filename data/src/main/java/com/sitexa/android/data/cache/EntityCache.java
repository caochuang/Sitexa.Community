package com.sitexa.android.data.cache;

import rx.Observable;

/**
 * Created by xnpeng on 15-9-5.
 */
public interface EntityCache {

    <T> Observable<T> get(final long id);

    <T> void put(T entity);

    boolean isCached(final long id);

    boolean isExpired();

    void evictAll();
}
