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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sitexa.android.community.R;
import com.sitexa.android.community.internal.di.HasComponent;
import com.sitexa.android.community.internal.di.components.DaggerUserComponent;
import com.sitexa.android.community.internal.di.components.UserComponent;
import com.sitexa.android.community.navigation.UserNavigator;
import com.sitexa.android.community.presenter.RegisterUserPresenter;
import com.sitexa.android.community.view.RegisterUserView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

public class RegisterUserActivity extends BaseActivity implements HasComponent<UserComponent>, RegisterUserView {

    @Inject
    UserNavigator userNavigator;
    @Inject
    RegisterUserPresenter registerUserPresenter;

    @Bind(R.id.mobileNo)
    EditText etMobileNo;
    @Bind(R.id.verifyCode)
    EditText etVerifyCode;
    @Bind(R.id.getVerifyCodeButton)
    Button btnGetVerifyCode;
    @Bind(R.id.username)
    EditText etUsername;
    @Bind(R.id.password)
    EditText etPassword;
    @Bind(R.id.registerUserButton)
    Button btnRegisterUser;
    @Bind(R.id.readServiceCheckbox)
    CheckBox cbReadService;
    @Bind(R.id.serviceStatement)
    TextView tvServiceStatement;

    private UserComponent userComponent;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, RegisterUserActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        ButterKnife.bind(this);

        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();

        this.userComponent.inject(this);

        this.registerUserPresenter.setView(this);
        this.registerUserPresenter.initialize();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.registerUserPresenter.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.registerUserPresenter.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.registerUserPresenter.destroy();
        ButterKnife.unbind(this);
    }

    @Override
    public UserComponent getComponent() {
        return this.userComponent;
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.getVerifyCodeButton)
    @Override
    public void getVerifyCode() {
        this.registerUserPresenter.doGetVerifyCode();
    }

    @OnClick(R.id.serviceStatement)
    @Override
    public void readServiceStatement() {
        this.userNavigator.navigateToServiceStatement(this);
    }

    @OnClick(R.id.registerUserButton)
    @Override
    public void registerUser() {

    }

    @Override
    public void navigateToLoginActivity() {
        this.userNavigator.navigateToUserLogin(this);
    }
}
