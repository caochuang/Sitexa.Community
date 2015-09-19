package com.sitexa.android.domain.repository;

import java.util.List;

import rx.Observable;

/**
 * Created by xnpeng on 15-9-13.
 */
public interface BaseRepository<T> {

    Observable<List<T>> listOfT();

    Observable<T> domainT(long id);

    Observable<String> save(T t);

    Observable<String> delete(long id);

    Observable<String> update(T t);

    Observable<List<T>> query(String condition);

}
