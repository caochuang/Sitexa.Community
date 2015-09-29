/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sitexa.android.community.internal.di.modules;

import com.sitexa.android.domain.executor.PostExecutionThread;
import com.sitexa.android.domain.executor.ThreadExecutor;
import com.sitexa.android.domain.interactor.GetUserDetails;
import com.sitexa.android.domain.interactor.GetUserList;
import com.sitexa.android.domain.interactor.UseCase;
import com.sitexa.android.domain.repository.UserRepository;
import com.sitexa.android.community.internal.di.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides user related collaborators.
 */
@Module
public class UserModule {

    private long userId = -1;

    public UserModule() {
    }

    public UserModule(long userId) {
        this.userId = userId;
    }

    @Provides
    @PerActivity
    @Named("userList")
    UseCase provideGetUserListUseCase(GetUserList getUserList) {
        return getUserList;
    }

    @Provides
    @PerActivity
    @Named("userDetails")
    UseCase provideGetUserDetailsUseCase(UserRepository userRepository,
                                         ThreadExecutor threadExecutor,
                                         PostExecutionThread postExecutionThread) {
        return new GetUserDetails(userId, userRepository, threadExecutor, postExecutionThread);
    }
}