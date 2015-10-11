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

package com.sitexa.android.data.net.okhttp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sitexa.android.data.constant.ApplicationConstants;
import com.sitexa.android.data.constant.CodeConstants;
import com.sitexa.android.data.exception.NetworkConnectionException;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by xnpeng on 15-9-25.
 */
public class OkHttpApi implements Callable<String> {

    private static final String TAG = OkHttpApi.class.getSimpleName();

    private static final String CONTENT_TYPE_LABEL = "Content-Type";
    private static final String CONTENT_TYPE_VALUE_JSON = "application/json; charset=utf-8";
    private static final MediaType JSON = MediaType.parse(CONTENT_TYPE_VALUE_JSON);
    private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    private Context context;
    private URL url;
    private RequestBody requestBody = null;
    private String response;

    private OkHttpApi(Context context) {
        this.context = context;
    }

    @NonNull
    public static OkHttpApi newInstance(Context context) {
        return new OkHttpApi(context);
    }

    @NonNull
    public OkHttpApi getRequest(String doAction, Map<String, String> requestParam) {
        try {
            String uri = getUrlString(doAction) + getGetMethodParams(requestParam);
            this.url = new URL(uri);
            return this;
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
            throw new RuntimeException(new NetworkConnectionException(e.getMessage()));
        }
    }

    @NonNull
    public OkHttpApi postRequest(String doAction, Map<String, String> requestParam) {
        try {
            String uri = getUrlString(doAction);
            this.url = new URL(uri);
            String params = getPostMethodParams(requestParam);
            this.requestBody = RequestBody.create(JSON, params);
            return this;
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
            throw new RuntimeException(new NetworkConnectionException(e.getMessage()));
        }
    }

    private String getUrlString(String doAction) {
        return ApplicationConstants.API_DOMAIN + doAction;
    }

    @NonNull
    private String getGetMethodParams(Map<String, String> params) {
        if (params != null && params.size() > 0) {
            try {
                StringBuilder actionUrl = new StringBuilder();
                actionUrl.append("?");
                for (String key : params.keySet()) {
                    actionUrl.append(key).append("=").append(URLEncoder.encode(params.get(key), "utf-8")).append("&");
                }
                return actionUrl.toString();
            } catch (UnsupportedEncodingException e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
        return "";
    }

    @NonNull
    private String getPostMethodParams(Map<String, String> params) {
        if (params != null && params.size() > 0) {
            try {
                StringBuilder actionUrl = new StringBuilder();
                for (String key : params.keySet()) {
                    actionUrl.append(key).append("=").append(URLEncoder.encode(params.get(key), "utf-8")).append("&");
                }
                return actionUrl.toString();
            } catch (UnsupportedEncodingException e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
        return "";
    }

    private void doGet() {
        OkHttpClient okHttpClient = this.createClient();
        final Request request = new Request.Builder()
                .url(this.url)
                .addHeader(CONTENT_TYPE_LABEL, CONTENT_TYPE_VALUE_JSON)
                .get()
                .build();
        if (isThereInternetConnection()) {
            try {
                String json = okHttpClient.newCall(request).execute().body().string();
                Log.d(TAG,json);
                Map map = gson.fromJson(json, Map.class);
                String code = (String) map.get(CodeConstants.HttpCode.CODE);
                Object value = map.get(CodeConstants.HttpCode.VALUE);

                if (CodeConstants.HttpCode.SUCCESS_CODE.equals(code)) {
                    this.response = gson.toJson(value);
                } else {
                    throw new RuntimeException(new NetworkConnectionException(CodeConstants.ApiCode.ERROR + " : " + String.valueOf(code) + " : " + value.toString()));
                }
            } catch (Exception e) {
                throw new RuntimeException(new NetworkConnectionException(CodeConstants.ApiCode.SERVER_CONNECTION_ERROR + " : " + e.getMessage()));
            }
        } else {
            throw new RuntimeException(new NetworkConnectionException());
        }
    }

    private void doPost() {
        OkHttpClient okHttpClient = this.createClient();
        final Request request = new Request.Builder()
                .url(this.url)
                .addHeader(CONTENT_TYPE_LABEL, CONTENT_TYPE_VALUE_JSON)
                .post(requestBody)
                .build();

        if (isThereInternetConnection()) {
            try {
                String json = okHttpClient.newCall(request).execute().body().string();
                Log.d(TAG,json);
                Map map = gson.fromJson(json, Map.class);
                String code = (String) map.get(CodeConstants.HttpCode.CODE);
                Object value = map.get(CodeConstants.HttpCode.VALUE);

                if (CodeConstants.HttpCode.SUCCESS_CODE.equals(code)) {
                    this.response = gson.toJson(value);
                } else {
                    throw new RuntimeException(new NetworkConnectionException(CodeConstants.ApiCode.ERROR + ":" + String.valueOf(code) + ":" + value.toString()));
                }
            } catch (Exception e) {
                throw new RuntimeException(new NetworkConnectionException(CodeConstants.ApiCode.SERVER_CONNECTION_ERROR + ":" + e.getMessage()));
            }
        } else {
            throw new RuntimeException(new NetworkConnectionException());
        }

    }

    private OkHttpClient createClient() {
        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(10000, TimeUnit.MILLISECONDS);
        okHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS);

        return okHttpClient;
    }

    @Override
    public String call() {
        if (this.requestBody != null)
            doPost();
        else
            doGet();

        return this.response;
    }

    private boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }

}
