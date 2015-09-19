package com.sitexa.android.domain.interactor;

import com.sitexa.android.domain.executor.PostExecutionThread;
import com.sitexa.android.domain.executor.ThreadExecutor;
import com.sitexa.android.domain.repository.SpaceRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by xnpeng on 15-9-5.
 */
public class GetSpaceList extends UseCase {

    private final SpaceRepository spaceRepository;

    @Inject
    public GetSpaceList(SpaceRepository spaceRepository,
                        ThreadExecutor threadExecutor,
                        PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.spaceRepository = spaceRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.spaceRepository.spaces();
    }
}
