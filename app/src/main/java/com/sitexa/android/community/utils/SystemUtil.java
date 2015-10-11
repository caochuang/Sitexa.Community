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

package com.sitexa.android.community.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.sitexa.android.community.support.CallbackEmptyFunction;

import java.lang.ref.WeakReference;

import javax.inject.Inject;


public class SystemUtil {

    //todo ... check this point. Can I inject applicationContext?
    @Inject
    static Context applicationContext;

    /**
     * 网络是否可用
     *
     * @return
     */
    public static boolean isNetworkAvailable() {
        ConnectivityManager mgr = (ConnectivityManager) applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info = mgr.getAllNetworkInfo();
        if (info != null) {
            for (int i = 0; i < info.length; i++) {
                if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 是否是wifi网络
     *
     * @return
     */
    public static boolean isWifi() {
        ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }

    /**
     * 在编辑控件的第一位的地方弹出软键盘
     *
     * @param editText
     */
    public final static void showInputFromWindow(final EditText editText) {
        WeakReference<Handler> reference = new WeakReference<Handler>(new Handler());
        reference.get().postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(editText, 0);
            }
        }, 200);

    }


    /**
     * edittext输入完毕之后点击done键执行下一步
     *
     * @param editText
     * @param callbackFuntion
     */
    public final static void enterInputFromDoneKeyNext(final EditText editText, final CallbackEmptyFunction callbackFuntion) {
        editText.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    SystemUtil.hideInputFromWindow(editText);
                    callbackFuntion.callback();
                    return true;
                }
                return false;
            }

        });

    }


    /**
     * 隐藏软键盘
     *
     * @param editText
     */
    public final static void hideInputFromWindow(final EditText editText) {
        InputMethodManager imm = (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    /**
     * dip to px
     *
     * @param dipValue
     * @return
     */
    public static int dip2px(float dipValue) {
        final float scale = applicationContext.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * px to dip
     *
     * @param pxValue
     * @return
     */
    public static int px2dip(float pxValue) {
        final float scale = applicationContext.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取状态栏的高度
     *
     * @param activity
     * @return
     */
    public static int getStatusBarHeight(Activity activity) {
        Rect rectangle = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rectangle);
        return rectangle.top;
    }


    /**
     * sp转px.
     *
     * @param value the value
     * @return the int
     */
    public static int sp2px(float value) {
        Resources r;
        if (applicationContext == null) {
            r = Resources.getSystem();
        } else {
            r = applicationContext.getResources();
        }
        float spValue = value * r.getDisplayMetrics().scaledDensity;
        return (int) (spValue + 0.5f);
    }


    /**
     * 获取设备宽度
     *
     * @param activity
     * @return
     */
    public static int getDeviceWidth(Activity activity) {
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.widthPixels;
    }


    /**
     * 获取设备高度
     *
     * @param activity
     * @return
     */
    public static int getDeviceHeight(Activity activity) {
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.heightPixels;
    }


    /**
     * 获取设备信息
     *
     * @return
     */
    public static String getUserAgent() {
        return String.format("%s %s", Build.BRAND, Build.MODEL);
        // return Build.PRODUCT;
    }


    /**
     * 获取控件位置
     *
     * @param view
     * @return
     */
    public static int[] getViewLocation(View view) {
        int[] location = {0, 0};
        view.getLocationInWindow(location);
        return new int[]{location[0], location[1]};
    }
}
