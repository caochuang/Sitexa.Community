package com.sitexa.android.domain.repository;

import com.sitexa.android.domain.Blog;

import java.util.List;

import rx.Observable;

/**
 * Created by xnpeng on 15-9-5.
 */
public interface BlogRepository {

    Observable<List<Blog>> blogs();

    Observable<Blog> blog(final long blogId);

}
