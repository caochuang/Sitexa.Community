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

package com.sitexa.android.community.navigation;

import android.content.Context;
import android.content.Intent;

import com.sitexa.android.community.view.activity.FindPasswordActivity;
import com.sitexa.android.community.view.activity.RegisterUserActivity;
import com.sitexa.android.community.view.activity.UserLoginActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by xnpeng on 15-10-15.
 */
public class UserNavigator extends Navigator {

    @Inject
    public UserNavigator() {
        super();
    }

    public void navigateToFindPassword(Context context) {
        if (context != null) {
            Intent intentToLaunch = FindPasswordActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }

    public void navigateToRegisterUser(Context context) {
        if (context != null) {
            Intent intentToLaunch = RegisterUserActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }
}
