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
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.sitexa.android.community.utils.StringUtil;
import com.sitexa.android.community.utils.SystemUtil;
import com.sitexa.android.community.utils.ValidateUtil;
import com.sitexa.android.community.view.RegisterUserView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @Bind(R.id.password2)
    EditText etPassword2;
    @Bind(R.id.registerUserButton)
    Button btnRegisterUser;
    @Bind(R.id.readServiceCheckbox)
    CheckBox cbReadService;
    @Bind(R.id.serviceStatement)
    TextView tvServiceStatement;

    private String phoneNumber = null;
    private boolean phoneNumber_isNotNull, verifyCode_isNotNull, username_isNotNull, password_isNotNull;
    private int resendSecond = 60;

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
        this.addTextChangedListener();

        SystemUtil.showInputFromWindow(etMobileNo);

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
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.getVerifyCodeButton)
    @Override
    public void getVerifyCode() {
        String phoneNumber = etMobileNo.getText().toString();
        this.registerUserPresenter.doGetVerifyCode(phoneNumber);
        this.resendSecond = 60;
    }

    @Override
    public void inputVerifyCode(){
        this.showMessage("VerifyCode have been send to your mobile phone.");
        this.reGetVerifyCode();
    }

    @OnClick(R.id.serviceStatement)
    @Override
    public void readServiceStatement() {
        this.userNavigator.navigateToServiceStatement(this);
    }

    @OnClick(R.id.registerUserButton)
    @Override
    public void registerUser() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        String mobileNo = etMobileNo.getText().toString();
        String verifyCode = etVerifyCode.getText().toString();

        this.registerUserPresenter.doRegisterUser(mobileNo,verifyCode,username,password);
    }

    @Override
    public void navigateToLoginActivity() {
        this.userNavigator.navigateToUserLogin(this);
    }

    private void addTextChangedListener() {
        this.etMobileNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                phoneNumber = etMobileNo.getText().toString();
                phoneNumber_isNotNull = true;
                if (StringUtil.isEmpty(phoneNumber)) {
                    btnGetVerifyCode.setTextColor(Color.GRAY);
                    btnGetVerifyCode.setBackgroundResource(R.drawable.btn_white_selector);
                    btnGetVerifyCode.setEnabled(false);
                    phoneNumber_isNotNull = false;
                    return;
                }

                if (!ValidateUtil.validateMobile(phoneNumber)) {
                    btnGetVerifyCode.setTextColor(Color.GRAY);
                    btnGetVerifyCode.setBackgroundResource(R.drawable.btn_white_selector);
                    btnGetVerifyCode.setEnabled(false);
                    phoneNumber_isNotNull = false;
                    return;
                }
                btnGetVerifyCode.setTextColor(Color.WHITE);
                btnGetVerifyCode.setBackgroundResource(R.drawable.btn_theme_color_selector);
                btnGetVerifyCode.setEnabled(true);
                updateRegisterBtn();
            }
        });

        etVerifyCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String v = etVerifyCode.getText().toString();
                if (StringUtil.isNotEmpty(v)) {
                    verifyCode_isNotNull = true;
                } else {
                    verifyCode_isNotNull = false;
                }
                updateRegisterBtn();
            }
        });

        etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String v = etUsername.getText().toString();
                if (StringUtil.isNotEmpty(v)) {
                    username_isNotNull = true;
                } else {
                    username_isNotNull = false;
                }
                updateRegisterBtn();
            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String v = etPassword.getText().toString();
                String v2 = etPassword2.getText().toString();
                if (StringUtil.isNotEmpty(v) && StringUtil.isNotEmpty(v2) && v.equals(v2)) {
                    password_isNotNull = true;
                } else {
                    password_isNotNull = false;
                }
                updateRegisterBtn();
            }
        });

        etPassword2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String v = etPassword.getText().toString();
                String v2 = etPassword2.getText().toString();
                if (StringUtil.isNotEmpty(v) && StringUtil.isNotEmpty(v2) && v.equals(v2)) {
                    password_isNotNull = true;
                } else {
                    password_isNotNull = false;
                }
                updateRegisterBtn();
            }
        });
    }

    private void updateRegisterBtn() {
        if (phoneNumber_isNotNull && verifyCode_isNotNull && username_isNotNull && password_isNotNull) {
            btnRegisterUser.setEnabled(true);
        } else {
            btnRegisterUser.setEnabled(false);
        }
    }

    private void reGetVerifyCode() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                btnGetVerifyCode.setText(String.format(getString(R.string.resendSecond), resendSecond));
                resendSecond--;
                if (resendSecond > 0) {
                    handler.postDelayed(this, 1000);
                    btnGetVerifyCode.setEnabled(false);
                } else {
                    btnGetVerifyCode.setText(getString(R.string.reGetVerifyCode));
                    btnGetVerifyCode.setEnabled(true);
                }
            }
        });
    }
}
