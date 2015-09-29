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

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.sitexa.android.data.constant.CodeConstants;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class ApiResult implements Serializable {

    private int code;

    private String originalCode;

    private String value;

    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOriginalCode() {
        return originalCode;
    }

    public void setOriginalCode(String originalCode) {
        this.originalCode = originalCode;
    }

    /**
     * 将json转换为对应的实体对象
     *
     * @param aClass
     * @return
     */
    public <T> T getDomain(Class<?> aClass) {
        if (CodeConstants.ApiCode.NETWORK_ERROR == code) {
            return null;
        }
        try {
            Object fromJson = gson.fromJson(value, aClass);
            Log.d(this.getClass().getCanonicalName(), "Json convert to :" + fromJson);
            return (T) fromJson;
        } catch (JsonSyntaxException e) {
            Log.e(this.getClass().getCanonicalName(), e.getMessage(), e);
        }
        return null;

    }


    /**
     * 将json转换为对应的实体对象集合
     *
     * @return
     */
    public <T> List<T> getDomainList(Type type) {
        if (CodeConstants.ApiCode.NETWORK_ERROR == code) {
            return null;
        }
        try {
            Log.d(this.getClass().getCanonicalName(),value + "");
            return gson.fromJson(value, type);
        } catch (JsonSyntaxException e) {
            Log.e(this.getClass().getCanonicalName(),e.getMessage(), e);
        }
        return null;
    }


}
