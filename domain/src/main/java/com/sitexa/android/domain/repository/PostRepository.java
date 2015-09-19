package com.sitexa.android.domain.repository;

import com.sitexa.android.domain.Post;

import java.util.List;

import rx.Observable;

/**
 * Created by xnpeng on 15-9-5.
 */
public interface PostRepository {

    Observable<List<Post>> posts();

    Observable<Post> post(final long postId);
}
