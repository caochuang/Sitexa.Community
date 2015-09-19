package com.sitexa.android.domain.repository;

import com.sitexa.android.domain.Space;

import java.util.List;

import rx.Observable;

/**
 * Created by xnpeng on 15-9-5.
 */
public interface SpaceRepository {

    Observable<List<Space>> spaces();

    Observable<Space> space(final long spaceId);
}
