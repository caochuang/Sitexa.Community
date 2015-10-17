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
import android.webkit.WebView;

import com.sitexa.android.community.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xnpeng on 15-10-17.
 */
public class ServiceStatementActivity extends BaseActivity {

    @Bind(R.id.service_statement)
    WebView webview;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, ServiceStatementActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSwipeBackEnable(true);
        getSwipeBackLayout().setSensitivity(this, 0.1f);
        setContentView(R.layout.activity_service_statement);
        ButterKnife.bind(this);
        webview.loadUrl("file:///android_asset/service_statement.html");
    }
}
