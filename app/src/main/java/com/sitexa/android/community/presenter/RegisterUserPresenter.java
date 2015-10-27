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

import com.sitexa.android.community.exception.ErrorMessageFactory;
import com.sitexa.android.community.internal.di.PerActivity;
import com.sitexa.android.community.view.RegisterUserView;
import com.sitexa.android.community.view.activity.RegisterUserActivity;
import com.sitexa.android.domain.exception.DefaultErrorBundle;
import com.sitexa.android.domain.exception.ErrorBundle;
import com.sitexa.android.domain.interactor.DefaultSubscriber;
import com.sitexa.android.domain.interactor.UseCase;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xnpeng on 15-10-17.
 */
@PerActivity
public class RegisterUserPresenter implements Presenter {

    private final UseCase getVerifyCodeUC;
    private final UseCase sendVerifyCodeUC;
    private final UseCase registerUserUC;

    private RegisterUserView registerUserView;

    @Inject
    public RegisterUserPresenter(@Named("getVerifyCode") UseCase getVerifyCode,
                                 @Named("sendVerifyCode") UseCase sendVerifyCode,
                                 @Named("registerUser") UseCase registerUser) {
        this.getVerifyCodeUC = getVerifyCode;
        this.sendVerifyCodeUC = sendVerifyCode;
        this.registerUserUC = registerUser;
    }

    public void setView(RegisterUserView view) {
        this.registerUserView = view;
    }

    public void initialize() {
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
        this.getVerifyCodeUC.unsubscribe();
        this.sendVerifyCodeUC.unsubscribe();
        this.registerUserUC.unsubscribe();
    }

    //////////for View//////////
    private void showErrorMessage(ErrorBundle errorBundle) {
        RegisterUserActivity aActivity = (RegisterUserActivity) this.registerUserView;
        String errorMessage = ErrorMessageFactory.create(aActivity, errorBundle.getException());
        this.registerUserView.showMessage(errorMessage);
    }

    private void showMessage(String message) {
        this.registerUserView.showMessage(message);
    }


    private void inputVerifyCode() {
        this.registerUserView.inputVerifyCode();
    }

    private void finishRegister(String msg) {
        this.showMessage(msg);
        this.registerUserView.navigateToLoginActivity();
    }

    //////////for Model//////////
    public void doGetVerifyCode(String phoneNumber) {
        final Map params = new HashMap();
        params.put("phoneNumber",phoneNumber);
        this.getVerifyCodeUC.execute(new GetVerifyCodeSubscriber(), params);
    }

    @SuppressWarnings("unchecked")
    public void doRegisterUser(String mobileNo, String verifyCode, String username, String password) {
        final Map params = new HashMap();
        params.put("mobileNo", mobileNo);
        params.put("verifyCode", verifyCode);
        params.put("username", username);
        params.put("password", password);
        this.registerUserUC.execute(new RegisterUserSubscriber(), params);
    }

    //////////Subscriber//////////
    private final class GetVerifyCodeSubscriber extends DefaultSubscriber<String> {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            RegisterUserPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
        }

        @Override
        public void onNext(String result) {
            if ("00000".equals(result))
                RegisterUserPresenter.this.inputVerifyCode();
            else
                RegisterUserPresenter.this.showMessage(result);
        }
    }

    private final class RegisterUserSubscriber extends DefaultSubscriber<String> {

        @Override
        public void onCompleted() {
            super.onCompleted();
        }

        @Override
        public void onError(Throwable e) {
            RegisterUserPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
        }

        @Override
        public void onNext(String msg) {
            RegisterUserPresenter.this.finishRegister(msg);
        }
    }
}
