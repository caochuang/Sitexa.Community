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

package com.sitexa.android.data.net.volley;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sitexa.android.data.constant.ApplicationConstants;
import com.sitexa.android.data.constant.CodeConstants;
import com.sitexa.android.data.exception.NetworkConnectionException;
import com.sitexa.android.data.net.okhttp.ApiResult;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;

public class VolleyApi {

    protected final static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    protected static String TAG = "[BaseApi]";
    protected static String mCookie;
    protected RequestQueue requestQueue;
    protected Context context;

    public VolleyApi(Context context) {
        this.context = context.getApplicationContext();
        this.requestQueue = Volley.newRequestQueue(this.context);
    }

    public static Cache.Entry cache(NetworkResponse response, long maxAge) {
        long now = System.currentTimeMillis();
        if (maxAge == 0) maxAge = 60;
        Map<String, String> headers = response.headers;

        long serverDate = 0;
        long softExpire = 0;
        String serverEtag = null;
        String headerValue;

        headerValue = headers.get("Date");
        if (headerValue != null) {
            serverDate = HttpHeaderParser.parseDateAsEpoch(headerValue);
        }
        softExpire = now + maxAge * 1000;
        Cache.Entry entry = new Cache.Entry();
        entry.data = response.data;
        entry.etag = serverEtag;
        entry.softTtl = softExpire;
        entry.ttl = entry.softTtl;
        entry.serverDate = serverDate;
        entry.responseHeaders = headers;
        return entry;
    }

    public Observable<ApiResult> get(String doAction, Map<String, String> requestParam) {
        return doGet(doAction, requestParam, false, false, false);
    }

    public Observable<ApiResult> post(String doAction, final Map<String, String> requestParam) {
        return doPost(doAction, requestParam, false, false, false);
    }

    public Observable<ApiResult> get(String doAction, Map<String, String> requestParam, boolean checkNetwork) {
        return doGet(doAction, requestParam, false, false, checkNetwork);
    }

    public Observable<ApiResult> post(String doAction, final Map<String, String> requestParam, boolean checkNetwork) {
        return doPost(doAction, requestParam, false, false, checkNetwork);
    }

    public Observable<ApiResult> getShouldCache(String doAction, Map<String, String> requestParam, final boolean refreshCache) {
        return doGet(doAction, requestParam, true, refreshCache, false);
    }

    public Observable<ApiResult> postShouldCache(String doAction, final Map<String, String> requestParam, final boolean refreshCache) {
        return doPost(doAction, requestParam, true, refreshCache, false);
    }

    public Observable<ApiResult> getShouldCache(String doAction, Map<String, String> requestParam, final boolean refreshCache, boolean checkNetwork) {
        return doGet(doAction, requestParam, true, refreshCache, checkNetwork);
    }

    public Observable<ApiResult> postShouldCache(String doAction, final Map<String, String> requestParam, final boolean refreshCache, boolean checkNetwork) {
        return doPost(doAction, requestParam, true, refreshCache, checkNetwork);
    }

    protected Observable<ApiResult> doGet(final String doAction, final Map<String, String> requestParam, final boolean shouldCache, final boolean refreshCache, final boolean checkNetwork) {
        final ApiResult result = new ApiResult();

        return Observable.create(
                new Observable.OnSubscribe<ApiResult>() {
                    @Override
                    public void call(Subscriber<? super ApiResult> subscriber) {

                        if (checkNetwork && !isThereInternetConnection()) {
                            subscriber.onError(new NetworkConnectionException(CodeConstants.ApiCode.NETWORK_ERROR + ":" + "Network connection error"));
                        } else {
                            try {

                                final String api = getApi(doAction) + getGetMethodParams(requestParam);
                                Log.d(TAG, String.format("Request url %s", api));

                                StringRequest request = new StringRequest(Request.Method.GET, api, json -> {
                                    Map map = gson.fromJson(json, Map.class);
                                    Object code = map.get(CodeConstants.HttpCode.CODE);
                                    Object value = map.get(CodeConstants.HttpCode.VALUE);
                                    if (CodeConstants.HttpCode.SUCCESS_CODE.equals(code)) {
                                        result.setCode(CodeConstants.ApiCode.OK);
                                        result.setOriginalCode(String.valueOf(code));
                                        result.setValue(gson.toJson(value));
                                        subscriber.onNext(result);
                                        subscriber.onCompleted();
                                    } else {
                                        subscriber.onError(new NetworkConnectionException(CodeConstants.ApiCode.ERROR + ":" + String.valueOf(code) + ":" + value.toString()));
                                    }
                                    Log.d(TAG, String.format("Request %s success. Result code: %s value: %s", api, CodeConstants.ApiCode.ERROR, value.toString()));
                                }, volleyError -> {
                                    subscriber.onError(new NetworkConnectionException(CodeConstants.ApiCode.SERVER_CONNECTION_ERROR + ":" + (volleyError != null ? volleyError.getMessage() : "")));
                                    Log.d(TAG, String.format("Request %s failure. Result code: %s message: %s", api, CodeConstants.ApiCode.SERVER_CONNECTION_ERROR, volleyError != null ? volleyError.getMessage() : ""));
                                }) {
                                    @Override
                                    protected Response<String> parseNetworkResponse(NetworkResponse response) {
                                        String setCookie = response.headers.get("Set-Cookie");
                                        if (StringUtils.isNotEmpty(setCookie)) {
                                            mCookie = setCookie;
                                        }
                                        Log.d(TAG, "Response cookie " + mCookie);
                                        String json = "";
                                        if (shouldCache) {
                                            int maxAge = 7 * 24 * 60 * 60;
                                            response.headers.remove("Cache-Control");
                                            response.headers.remove("Pragma");
                                            response.headers.remove("Expires");
                                            if (refreshCache) {
                                                invalidateCached(api);
                                            }
                                            try {
                                                json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                                            } catch (UnsupportedEncodingException e) {
                                                Log.e(TAG, e.getMessage(), e);
                                            }
                                            return Response.success(json, cache(response, maxAge));
                                        }

                                        return super.parseNetworkResponse(response);
                                    }

                                    @Override
                                    public Map<String, String> getHeaders() throws AuthFailureError {
                                        Map<String, String> localHashMap = new HashMap<String, String>();
                                        if (StringUtils.isNotEmpty(mCookie)) {
                                            localHashMap.put("Cookie", mCookie);
                                        }
                                        return localHashMap;
                                    }
                                };
                                request.setShouldCache(shouldCache);
                                requestQueue.add(request);

                            } catch (Exception e) {
                                subscriber.onError(new NetworkConnectionException(e.getCause()));
                            }
                        }

                    }
                }
        );
    }

    protected Observable<ApiResult> doPost(final String doAction, final Map<String, String> requestParam, final boolean shouldCache, final boolean refreshCache, final boolean checkNetwork) {
        final ApiResult result = new ApiResult();

        return Observable.create(
                new Observable.OnSubscribe<ApiResult>() {
                    @Override
                    public void call(Subscriber<? super ApiResult> subscriber) {

                        if (checkNetwork && !isThereInternetConnection()) {
                            subscriber.onError(new NetworkConnectionException(CodeConstants.ApiCode.NETWORK_ERROR + ":" + "Network connection error"));
                        } else {

                            try {

                                final String api = getApi(doAction);
                                Log.d(TAG, String.format("Request url %s", api));

                                StringRequest request = new StringRequest(Request.Method.POST, api, json -> {
                                    Log.d(TAG, json);
                                    Map map = gson.fromJson(json, Map.class);
                                    Object code = map.get(CodeConstants.HttpCode.CODE);
                                    Object value = map.get(CodeConstants.HttpCode.VALUE);
                                    if (CodeConstants.HttpCode.SUCCESS_CODE.equals(code)) {
                                        result.setCode(CodeConstants.ApiCode.OK);
                                        result.setOriginalCode(String.valueOf(code));
                                        result.setValue(gson.toJson(value));
                                        subscriber.onNext(result);
                                        subscriber.onCompleted();
                                    } else {
                                        subscriber.onError(new NetworkConnectionException(CodeConstants.ApiCode.ERROR + ":" + String.valueOf(code) + ":" + value.toString()));
                                    }
                                    Log.d(TAG, String.format("Request %s success. Result code: %s value: %s", api, CodeConstants.ApiCode.ERROR, value.toString()));
                                }, volleyError -> {
                                    subscriber.onError(new NetworkConnectionException(CodeConstants.ApiCode.SERVER_CONNECTION_ERROR + ":" + (volleyError != null ? volleyError.getMessage() : "")));
                                    Log.d(TAG, String.format("Request %s failure. Result code: %s message: %s", api, CodeConstants.ApiCode.SERVER_CONNECTION_ERROR, volleyError != null ? volleyError.getMessage() : ""));
                                }) {

                                    @Override
                                    protected Map<String, String> getParams() throws AuthFailureError {
                                        return requestParam;
                                    }

                                    @Override
                                    protected Response<String> parseNetworkResponse(NetworkResponse response) {
                                        String setCookie = response.headers.get("Set-Cookie");
                                        if (StringUtils.isNotEmpty(setCookie)) {
                                            mCookie = setCookie;
                                        }
                                        Log.d(TAG, "Response cookie " + mCookie);
                                        String json = "";
                                        if (shouldCache) {
                                            int maxAge = 7 * 24 * 60 * 60;
                                            response.headers.remove("Cache-Control");
                                            response.headers.remove("Pragma");
                                            response.headers.remove("Expires");
                                            if (refreshCache) {
                                                invalidateCached(api);
                                            }
                                            try {
                                                json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                                            } catch (UnsupportedEncodingException e) {
                                                Log.e(TAG, e.getMessage(), e);
                                            }
                                            return Response.success(json, cache(response, maxAge));
                                        }

                                        return super.parseNetworkResponse(response);
                                    }

                                    @Override
                                    public Map<String, String> getHeaders() throws AuthFailureError {
                                        Map<String, String> localHashMap = new HashMap<String, String>();
                                        if (StringUtils.isNotEmpty(mCookie)) {
                                            localHashMap.put("Cookie", mCookie);
                                        }
                                        return localHashMap;
                                    }
                                };

                                request.setShouldCache(shouldCache);
                                requestQueue.add(request);

                            } catch (Exception e) {
                                subscriber.onError(new NetworkConnectionException(e.getCause()));
                            }
                        }
                    }
                }
        );
    }

    private void invalidateCached(String api) {
        Cache.Entry entry = requestQueue.getCache().get(api);
        if (entry != null && entry.data != null && entry.data.length > 0)
            if (!entry.isExpired()) {
                requestQueue.getCache().invalidate(api, true);
            }
    }

    public String getApi(String doAction) {
        return ApplicationConstants.API_DOMAIN + doAction;
    }

    private String getGetMethodParams(Map<String, String> params) {
        if (params != null && params.size() > 0) {
            try {
                StringBuffer actionUrl = new StringBuffer();
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

    private boolean isThereInternetConnection() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnectedOrConnecting());
    }

}
