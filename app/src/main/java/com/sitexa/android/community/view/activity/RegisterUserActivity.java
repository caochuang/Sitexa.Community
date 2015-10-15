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
import android.app.Activity;

import com.sitexa.android.community.R;
import com.sitexa.android.community.internal.di.components.DaggerUserComponent;
import com.sitexa.android.community.internal.di.components.UserComponent;
import com.sitexa.android.community.navigation.UserNavigator;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class RegisterUserActivity extends BaseActivity {

    @Inject
    UserNavigator userNavigator;
    //@Inject
    //RegisterUserPresenter registerUserPresenter;

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

    }

}
