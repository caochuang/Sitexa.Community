package com.sitexa.android.domain.interactor;

import com.sitexa.android.domain.executor.PostExecutionThread;
import com.sitexa.android.domain.executor.ThreadExecutor;
import com.sitexa.android.domain.repository.GroupRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by xnpeng on 15-9-5.
 */
public class GetGroupDetails extends UseCase {

    private final long groupId;
    private final GroupRepository groupRepository;

    @Inject
    public GetGroupDetails(long groupId, GroupRepository groupRepository,
                           ThreadExecutor threadExecutor,
                           PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.groupId = groupId;
        this.groupRepository = groupRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.groupRepository.group(this.groupId);
    }
}
