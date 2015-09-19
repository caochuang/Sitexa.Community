package com.sitexa.android.domain.interactor;

import com.sitexa.android.domain.executor.PostExecutionThread;
import com.sitexa.android.domain.executor.ThreadExecutor;
import com.sitexa.android.domain.repository.PostRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by xnpeng on 15-9-5.
 */
public class GetPostDetails extends UseCase {

    private final long postId;
    private final PostRepository postRepository;

    @Inject
    public GetPostDetails(long postId, PostRepository postRepository,
                          ThreadExecutor threadExecutor,
                          PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.postId = postId;
        this.postRepository = postRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return null;
    }
}
