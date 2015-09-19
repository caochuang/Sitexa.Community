package com.sitexa.android.domain.repository;

import com.sitexa.android.domain.Community;

import java.util.List;

import rx.Observable;

/**
 * Created by xnpeng on 15-9-5.
 */
public interface CommunityRepository {

    Observable<List<Community>> communities();

    Observable<Community> community(final long communityId);

}
