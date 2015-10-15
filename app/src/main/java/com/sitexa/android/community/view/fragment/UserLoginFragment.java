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

package com.sitexa.android.community.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.sitexa.android.community.AndroidApplication;
import com.sitexa.android.community.R;
import com.sitexa.android.community.internal.di.components.UserComponent;
import com.sitexa.android.community.model.UserModel;
import com.sitexa.android.community.presenter.LoginPresenter;
import com.sitexa.android.community.utils.AnimationUtil;
import com.sitexa.android.community.utils.StringUtil;
import com.sitexa.android.community.utils.SystemUtil;
import com.sitexa.android.community.utils.ViewUtil;
import com.sitexa.android.community.view.UserLoginView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xnpeng on 15-10-9.
 */
public class UserLoginFragment extends BaseFragment implements UserLoginView {

    @Inject
    LoginPresenter loginPresenter;

    @Bind(R.id.username)
    EditText et_username;
    @Bind(R.id.password)
    EditText et_password;
    @Bind(R.id.rl_progress)
    RelativeLayout rl_progress;
    @Bind(R.id.rl_retry)
    RelativeLayout rl_retry;
    @Bind(R.id.bt_retry)
    Button bt_retry;

    private UserLoginListener userLoginListener;

    public UserLoginFragment() {
        super();
    }

    //////////Fragment//////////
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_user_login, container, false);
        ButterKnife.bind(this, fragmentView);

        return fragmentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.getComponent(UserComponent.class).inject(this);

        this.userLoginListener = (UserLoginListener) getActivity();

        this.loginPresenter.setView(this);
        this.loginPresenter.initialize();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.loginPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.loginPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.loginPresenter.destroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    //////////LoadDataView//////////
    @Override
    public void showLoading() {
        this.rl_progress.setVisibility(View.VISIBLE);
        this.getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void hideLoading() {
        this.rl_progress.setVisibility(View.GONE);
        this.getActivity().setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void showRetry() {
        this.rl_retry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        this.rl_retry.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        //this.showToastMessage(message);
        this.dialog(message);
    }

    @Override
    public Context getContext() {
        return getActivity().getApplicationContext();
    }

    //////////UserLoginView//////////
    @Override
    public void loginSuccess(UserModel user) {
        if (userLoginListener != null) {
            userLoginListener.toMainActivity(user);
        }
    }

    @OnClick(R.id.find_password)
    @Override
    public void findPassword() {
        if (userLoginListener != null) {
            userLoginListener.toFindPassword();
        }
    }

    @OnClick(R.id.register_user)
    @Override
    public void registerUser() {
        if (userLoginListener != null) {
            userLoginListener.toRegisterUser();
        }
    }

    @OnClick(R.id.do_login)
    void onButtonDoLoginClick() {

        String username = this.et_username.getText().toString();
        String password = this.et_password.getText().toString();
        String imei = AndroidApplication.deviceId;
        String userAgent = SystemUtil.getUserAgent();

        if (StringUtil.isEmpty(username)) {
            ViewUtil.showToast(getActivity(), R.string.please_enter_username);
            et_username.startAnimation(AnimationUtil.shakeAnimation(5));
            return;
        }
        if (StringUtil.isEmpty(password)) {
            ViewUtil.showToast(getActivity(), R.string.please_enter_password);
            et_password.startAnimation(AnimationUtil.shakeAnimation(5));
            return;
        }

        if (this.loginPresenter != null) {
            this.loginPresenter.doLogin(username, password, imei, userAgent);
        }
    }

    //////////interface//////////
    public interface UserLoginListener {
        void toMainActivity(final UserModel userModel);

        void toFindPassword();

        void toRegisterUser();
    }
}
