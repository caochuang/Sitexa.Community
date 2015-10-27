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

import com.sitexa.android.community.R;
import com.sitexa.android.community.internal.di.HasComponent;
import com.sitexa.android.community.internal.di.components.DaggerApplicationComponent;
import com.sitexa.android.community.internal.di.components.DaggerUserComponent;
import com.sitexa.android.community.internal.di.components.UserComponent;
import com.sitexa.android.community.model.UserModel;
import com.sitexa.android.community.navigation.UserNavigator;
import com.sitexa.android.community.view.fragment.UserLoginFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by xnpeng on 15-10-9.
 */
public class UserLoginActivity extends BaseActivity implements HasComponent<UserComponent>,
        UserLoginFragment.UserLoginListener {

    static final String TAG = UserLoginActivity.class.getCanonicalName();

    @Inject
    UserNavigator userNavigator;

    private UserComponent userComponent;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, UserLoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.bind(this);

        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();

        this.userComponent.inject(this);
    }

    @Override
    public UserComponent getComponent() {
        return userComponent;
    }

    public void toMainActivity(UserModel userModel) {
        this.navigator.navigateToUserList(this);
    }

    @Override
    public void toFindPassword() {
        this.userNavigator.navigateToFindPassword(this);
    }

    @Override
    public void toRegisterUser() {
        this.userNavigator.navigateToRegisterUser(this);
    }
}
