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

package com.sitexa.android.community.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.sitexa.android.community.R;
import com.sitexa.android.community.internal.di.HasComponent;
import com.sitexa.android.community.internal.di.components.DaggerUserComponent;
import com.sitexa.android.community.internal.di.components.UserComponent;
import com.sitexa.android.community.navigation.UserNavigator;
import com.sitexa.android.community.presenter.FindPasswordPresenter;
import com.sitexa.android.community.view.FindPasswordView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FindPasswordActivity extends BaseActivity
        implements HasComponent<UserComponent>, FindPasswordView {

    @Inject
    FindPasswordPresenter findPasswordPresenter;
    @Inject
    UserNavigator userNavigator;

    @Bind(R.id.rl_get_verify_code)
    RelativeLayout rl_get_verify_code;
    @Bind(R.id.rl_send_verify_code)
    RelativeLayout rl_send_verify_code;
    @Bind(R.id.rl_set_password)
    RelativeLayout rl_set_password;
    @Bind(R.id.etMobileNo)
    EditText etMobileNo;
    @Bind(R.id.etVerifyCode)
    EditText etVerifyCode;
    @Bind(R.id.etPassword)
    EditText etPassword;
    @Bind(R.id.etPassword2)
    EditText getEtPassword2;
    @Bind(R.id.set_password_ok_button)
    Button btnSetPassword;
    @Bind(R.id.get_verify_code_button)
    Button btnGetVerifyCode;
    @Bind(R.id.send_verify_code_button)
    Button btnSendVerifyCode;

    private UserComponent userComponent;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, FindPasswordActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_find_password);
        ButterKnife.bind(this);

        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();

        this.userComponent.inject(this);

        this.findPasswordPresenter.setView(this);
        this.findPasswordPresenter.initialize();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.findPasswordPresenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.findPasswordPresenter.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.findPasswordPresenter.destroy();
    }

    @Override
    public UserComponent getComponent() {
        return this.userComponent;
    }

    @OnClick(R.id.get_verify_code_button)
    @Override
    public void getVerifyCode() {
        String mobileNo = etMobileNo.getText().toString();
        this.findPasswordPresenter.doGetVerifyCode();
    }

    @OnClick(R.id.send_verify_code_button)
    @Override
    public void sendVerifyCode() {
        this.findPasswordPresenter.doSendVerifyCode();
    }

    @OnClick(R.id.set_password_ok_button)
    @Override
    public void setPassword() {
        this.findPasswordPresenter.doSetPassword();
    }

    @Override
    public void forwardToLoginActivity() {
        this.userNavigator.navigateToUserLogin(this);
    }

    @Override
    public void showGetVerifyCodeView() {
        this.rl_get_verify_code.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideGetVerifyCodeView() {
        this.rl_get_verify_code.setVisibility(View.GONE);
    }

    @Override
    public void showSendVerifyCodeView() {
        this.rl_send_verify_code.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideSendVerifyCodeView() {
        this.rl_send_verify_code.setVisibility(View.GONE);
    }

    @Override
    public void showSetPasswordView() {
        this.rl_set_password.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideSetPasswordView() {
        this.rl_set_password.setVisibility(View.GONE);
    }

    public void showError(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
