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
package com.sitexa.android.community.internal.di.modules;

import com.sitexa.android.community.internal.di.PerActivity;
import com.sitexa.android.community.navigation.Navigator;
import com.sitexa.android.community.navigation.UserNavigator;
import com.sitexa.android.domain.executor.PostExecutionThread;
import com.sitexa.android.domain.executor.ThreadExecutor;
import com.sitexa.android.domain.interactor.UseCase;
import com.sitexa.android.domain.interactor.user.GetUserDetails;
import com.sitexa.android.domain.interactor.user.GetUserList;
import com.sitexa.android.domain.interactor.user.GetVerifyCode;
import com.sitexa.android.domain.interactor.user.RegisterUser;
import com.sitexa.android.domain.interactor.user.SendVerifyCode;
import com.sitexa.android.domain.interactor.user.SetPassword;
import com.sitexa.android.domain.interactor.user.UserLoginCase;
import com.sitexa.android.domain.repository.UserRepository;

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
    long provideUserId() {
        return userId;
    }

    @Provides
    @PerActivity
    Navigator provideNavigator() {
        return new Navigator();
    }


    @Provides
    @PerActivity
    UserNavigator provideUserNavigator() {
        return new UserNavigator();
    }

    /**
     * 因为GetUserList不需要客户提供参数，Dagger可以自动生成构造函数所需的参数GetUserList，
     * 故可以直接返回该对象。但GetUserDetails需要传入客户参数userId,所以需要完整传入构造函数所需的参数。
     * 问题：如果要进行翻页查询，需要传入页码和每页记录数，是否需要一个新的构造函数？
     * 如：UserModule(int pageNo,int pageSize)?
     *
     * @param getUserList UseCase instance
     * @return UseCase
     */
    @Provides
    @PerActivity
    @Named("userList")
    UseCase provideGetUserListUseCase(GetUserList getUserList) {
        return getUserList;
    }

/*
    @Provides
    @PerActivity
    @Named("userList")
    UseCase provideGetUserListUseCase(UserRepository userRepository,
                                      ThreadExecutor threadExecutor,
                                      PostExecutionThread postExecutionThread) {
        return new GetUserList(userRepository,threadExecutor,postExecutionThread);
    }
*/

    @Provides
    @PerActivity
    @Named("userDetails")
    UseCase provideGetUserDetailsUseCase(UserRepository userRepository,
                                         ThreadExecutor threadExecutor,
                                         PostExecutionThread postExecutionThread) {
        return new GetUserDetails(userId, userRepository, threadExecutor, postExecutionThread);
    }

    @Provides
    @PerActivity
    @Named("userLogin")
    UseCase provideUserLoginUseCase(UserRepository userRepository,
                                    ThreadExecutor threadExecutor,
                                    PostExecutionThread postExecutionThread) {
        return new UserLoginCase(userRepository, threadExecutor, postExecutionThread);
    }

    @Provides
    @PerActivity
    @Named("getVerifyCode")
    UseCase provideGetVerifyCode(UserRepository userRepository,
                                 ThreadExecutor threadExecutor,
                                 PostExecutionThread postExecutionThread) {
        return new GetVerifyCode(userRepository, threadExecutor, postExecutionThread);
    }

    @Provides
    @PerActivity
    @Named("sendVerifyCode")
    UseCase provideSendVerify(UserRepository userRepository,
                              ThreadExecutor threadExecutor,
                              PostExecutionThread postExecutionThread) {
        return new SendVerifyCode(userRepository, threadExecutor, postExecutionThread);
    }

    @Provides
    @PerActivity
    @Named("setPassword")
    UseCase provideSetPassword(UserRepository userRepository,
                               ThreadExecutor threadExecutor,
                               PostExecutionThread postExecutionThread) {
        return new SetPassword(userRepository, threadExecutor, postExecutionThread);
    }

    @Provides
    @PerActivity
    @Named("registerUser")
    UseCase provideRegisterUser(UserRepository userRepository,
                               ThreadExecutor threadExecutor,
                               PostExecutionThread postExecutionThread) {
        return new RegisterUser(userRepository, threadExecutor, postExecutionThread);
    }
}