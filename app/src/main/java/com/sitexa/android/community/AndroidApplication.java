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
package com.sitexa.android.community;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.sitexa.android.community.internal.di.components.ApplicationComponent;
import com.sitexa.android.community.internal.di.components.DaggerApplicationComponent;
import com.sitexa.android.community.internal.di.modules.ApplicationModule;
import com.sitexa.android.community.model.AppInfo;

public class AndroidApplication extends Application {

    protected static final String TAG = AndroidApplication.class.getCanonicalName();

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        //todo...uncomment next lines
        //UncaughtExceptionHandler instance = UncaughtExceptionHandler.getInstance();
        //instance.initialization(getApplicationContext());
        initAppInfo();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initAppInfo() {
        try {
            PackageManager pm = getPackageManager();
            PackageInfo packageInfo = pm.getPackageInfo(getPackageName(), 0);
            AppInfo.packageName = packageInfo.packageName;
            AppInfo.versionCode = packageInfo.versionCode;
            AppInfo.versionName = packageInfo.versionName;
            AppInfo.deviceId = ((TelephonyManager) getSystemService(TELEPHONY_SERVICE)).getDeviceId();
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

}
