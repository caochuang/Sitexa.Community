package com.sitexa.android.domain.repository;

import com.sitexa.android.domain.Group;

import java.util.List;

import rx.Observable;

/**
 * Created by xnpeng on 15-9-5.
 */
public interface GroupRepository {

    Observable<List<Group>> groups();

    Observable<Group> group(final long groupId);

}
