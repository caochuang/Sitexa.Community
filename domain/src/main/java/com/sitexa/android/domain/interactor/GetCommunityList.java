package com.sitexa.android.domain.interactor;

import com.sitexa.android.domain.executor.PostExecutionThread;
import com.sitexa.android.domain.executor.ThreadExecutor;
import com.sitexa.android.domain.repository.CommunityRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by xnpeng on 15-9-5.
 */
public class GetCommunityList extends UseCase {

    private final CommunityRepository communityRepository;

    @Inject
    public GetCommunityList(CommunityRepository communityRepository,
                            ThreadExecutor threadExecutor,
                            PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.communityRepository = communityRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.communityRepository.communities();
    }
}
