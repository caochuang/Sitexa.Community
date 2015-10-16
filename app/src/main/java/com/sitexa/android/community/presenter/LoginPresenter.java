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

package com.sitexa.android.community.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.sitexa.android.community.exception.ErrorMessageFactory;
import com.sitexa.android.community.internal.di.PerActivity;
import com.sitexa.android.community.mapper.UserModelDataMapper;
import com.sitexa.android.community.model.UserModel;
import com.sitexa.android.community.view.UserLoginView;
import com.sitexa.android.domain.User;
import com.sitexa.android.domain.exception.DefaultErrorBundle;
import com.sitexa.android.domain.exception.ErrorBundle;
import com.sitexa.android.domain.interactor.DefaultSubscriber;
import com.sitexa.android.domain.interactor.UseCase;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * User login function. When logged in, save current user to application context,
 * then navigate to then main activity.
 * Created by xnpeng on 15-10-9.
 */
@PerActivity
public class LoginPresenter implements Presenter {

    private final static String TAG = LoginPresenter.class.getSimpleName();
    private final UseCase userLoginCase;
    private final UserModelDataMapper userModelDataMapper;
    private UserLoginView userLoginView;

    @Inject
    public LoginPresenter(@Named("userLogin") UseCase userLoginCase, UserModelDataMapper userModelDataMapper) {
        this.userLoginCase = userLoginCase;
        this.userModelDataMapper = userModelDataMapper;
    }

    public void setView(@NonNull UserLoginView userLoginView){
        this.userLoginView = userLoginView;
    }


    public void initialize(){
        this.hideViewLoading();
        this.hideViewRetry();
    }


    //////////Presenter//////////
    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.userLoginCase.unsubscribe();
    }

    //////////for View//////////
    private void showViewLoading() {
        this.userLoginView.showLoading();
    }

    private void hideViewLoading() {
        this.userLoginView.hideLoading();
    }

    private void showViewRetry() {
        this.userLoginView.showRetry();
    }

    private void hideViewRetry() {
        this.userLoginView.hideRetry();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        Context context = this.userLoginView.getContext();
        String errorMessage = ErrorMessageFactory.create(context, errorBundle.getException());
        this.userLoginView.showError(errorMessage);
    }

    private void loginSuccess(User user) {
        final UserModel userModel = this.userModelDataMapper.transform(user);
        this.userLoginView.loginSuccess(userModel);
    }

    //////////for Model//////////
    public void doLogin(String username, String password, String imei, String userAgent) {
        Map<String, String> fields = new HashMap<>();
        fields.put("username", username);
        fields.put("password", password);
        fields.put("imei", imei);
        fields.put("userAgent", userAgent);

        userLoginCase.execute(new LoginSubscriber(), fields);
    }

    private final class LoginSubscriber extends DefaultSubscriber<User> {

        @Override
        public void onCompleted() {
            LoginPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            LoginPresenter.this.hideViewLoading();
            LoginPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            LoginPresenter.this.hideViewRetry();
        }

        @Override
        public void onNext(User user) {
            LoginPresenter.this.loginSuccess(user);
        }
    }
}
