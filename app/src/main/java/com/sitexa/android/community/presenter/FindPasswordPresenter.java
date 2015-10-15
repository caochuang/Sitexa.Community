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

import android.support.annotation.NonNull;

import com.sitexa.android.community.exception.ErrorMessageFactory;
import com.sitexa.android.community.view.FindPasswordView;
import com.sitexa.android.community.view.activity.FindPasswordActivity;
import com.sitexa.android.domain.exception.DefaultErrorBundle;
import com.sitexa.android.domain.exception.ErrorBundle;
import com.sitexa.android.domain.interactor.DefaultSubscriber;
import com.sitexa.android.domain.interactor.UseCase;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xnpeng on 15-10-12.
 */
public class FindPasswordPresenter implements Presenter {

    private final UseCase setPasswordUseCase;
    private final UseCase getVerifyCodeUseCase;
    private final UseCase sendVerifyCodeUseCase;

    private FindPasswordView findPasswordView;

    @Inject
    public FindPasswordPresenter(
            @Named("getVerifyCode") UseCase getVerifyCodeUseCase,
            @Named("sendVerifyCode") UseCase sendVerifyCodeUseCase,
            @Named("setPassword") UseCase setPasswordUseCase) {
        this.getVerifyCodeUseCase = getVerifyCodeUseCase;
        this.sendVerifyCodeUseCase = sendVerifyCodeUseCase;
        this.setPasswordUseCase = setPasswordUseCase;
    }

    public void setView(@NonNull FindPasswordView view) {
        this.findPasswordView = view;
    }

    public void initialize() {
        this.getVerifyCode();
    }

    //////////for view//////////
    private void getVerifyCode(){
        this.findPasswordView.showGetVerifyCodeView();
        this.findPasswordView.hideSendVerifyCodeView();
        this.findPasswordView.hideSetPasswordView();
    }

    private void sendVerifyCode(){
        this.findPasswordView.hideGetVerifyCodeView();
        this.findPasswordView.showSendVerifyCodeView();
        this.findPasswordView.hideSetPasswordView();
    }

    private void setPassword(){
        this.findPasswordView.hideGetVerifyCodeView();
        this.findPasswordView.hideSendVerifyCodeView();
        this.findPasswordView.showSetPasswordView();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        FindPasswordActivity aActivity = (FindPasswordActivity)this.findPasswordView;
        String errorMessage = ErrorMessageFactory.create(aActivity, errorBundle.getException());
        this.findPasswordView.showError(errorMessage);
    }

    private void forwardToLoginActivity(){
        this.findPasswordView.forwardToLoginActivity();
    }

    //////////for Model//////////
    public void doGetVerifyCode() {
        final Map params = new HashMap();

        this.getVerifyCodeUseCase.execute(new GetVerifyCodeSubscriber(), params);
    }

    public void doSendVerifyCode() {
        final Map params = new HashMap();
        this.sendVerifyCodeUseCase.execute(new SendVerifyCodeSubscriber(), params);
    }

    public void doSetPassword() {
        final Map params = new HashMap();
        this.setPasswordUseCase.execute(new SetPasswordSubscriber(), params);
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
        this.getVerifyCodeUseCase.unsubscribe();
        this.sendVerifyCodeUseCase.unsubscribe();
        this.setPasswordUseCase.unsubscribe();
    }


    private final class GetVerifyCodeSubscriber extends DefaultSubscriber<String> {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            FindPasswordPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception)e));
        }

        @Override
        public void onNext(String result) {
            FindPasswordPresenter.this.sendVerifyCode();
        }
    }

    private final class SendVerifyCodeSubscriber extends DefaultSubscriber<String> {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            FindPasswordPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception)e));
        }

        @Override
        public void onNext(String result) {
            FindPasswordPresenter.this.setPassword();
        }
    }

    private final class SetPasswordSubscriber extends DefaultSubscriber<String> {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            FindPasswordPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception)e));
        }

        @Override
        public void onNext(String result) {
            FindPasswordPresenter.this.forwardToLoginActivity();
        }
    }
}
