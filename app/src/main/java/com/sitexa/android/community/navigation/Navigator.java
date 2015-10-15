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
import com.sitexa.android.community.view.activity.UserDetailsActivity;
import com.sitexa.android.community.view.activity.UserListActivity;
import com.sitexa.android.community.view.activity.UserLoginActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class used to navigate through the application.
 * Comment: One Navigator for whole project is not enough, there must bu ModuleNavigator for each module,
 * Or, instead of Navigator , directly use context.startActivity(intentToLaunch).
 */
@Singleton
public class Navigator {

    @Inject
    public void Navigator() {
        //empty
    }

    /**
     * Goes to the user list screen.
     *
     * @param context A Context needed to open the destiny activity.
     */
    public void navigateToUserList(Context context) {
        if (context != null) {
            Intent intentToLaunch = UserListActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }

    /**
     * Goes to the user details screen.
     *
     * @param context A Context needed to open the destiny activity.
     */
    public void navigateToUserDetails(Context context, long userId) {
        if (context != null) {
            Intent intentToLaunch = UserDetailsActivity.getCallingIntent(context, userId);
            context.startActivity(intentToLaunch);
        }
    }

    public void navigateToUserLogin(Context context) {
        if (context != null) {
            Intent intentToLaunch = UserLoginActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }

 /*    public void navigateToFindPassword(Context context) {
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
    }*/
}
