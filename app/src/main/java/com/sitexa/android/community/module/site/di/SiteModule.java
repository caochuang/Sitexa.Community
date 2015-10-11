/*
 *   Copyright (C) 2015 Sitexa Open Source Project
 *   <p>
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *   <p>
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   <p>
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.sitexa.android.community.module.site.di;

import com.sitexa.android.community.internal.di.PerActivity;
import com.sitexa.android.domain.executor.PostExecutionThread;
import com.sitexa.android.domain.executor.ThreadExecutor;
import com.sitexa.android.domain.interactor.UseCase;
import com.sitexa.android.domain.interactor.site.GetSiteDetails;
import com.sitexa.android.domain.interactor.site.GetSiteList;
import com.sitexa.android.domain.repository.SiteRepository;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xnpeng on 15-9-30.
 */
@Module
public class SiteModule {
    private String siteId = null;

    public SiteModule() {
    }

    public SiteModule(String siteId) {
        this.siteId = siteId;
    }

    @Provides
    @PerActivity
    @Named("siteList")
    UseCase provideGetSiteListUseCase(GetSiteList getSiteList) {
        return getSiteList;
    }

    @Provides
    @PerActivity
    @Named("siteDetails")
    UseCase provideGetSiteDetailsUseCase(SiteRepository siteRepository,
                                         ThreadExecutor threadExecutor,
                                         PostExecutionThread postExecutionThread) {
        return new GetSiteDetails(siteId,siteRepository,threadExecutor,postExecutionThread);
    }

}
