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

package com.sitexa.android.community.exception;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    public static final String LOG_TAG = UncaughtExceptionHandler.class.getName();
    /**
     * 全局异常处理类
     */
    private static UncaughtExceptionHandler sitexaUncaughtExceptionHandler;
    //系统默认UncaughtException处理类
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private Context context;

    private UncaughtExceptionHandler() {
    }

    /**
     * 实例化单例类
     */
    public static UncaughtExceptionHandler getInstance() {
        if (sitexaUncaughtExceptionHandler == null) {
            sitexaUncaughtExceptionHandler = SitexaUncaughtExceptionHandlerHolder.sitexaUncaughtExceptionHandler;
        }
        return sitexaUncaughtExceptionHandler;
    }

    /**
     * 初始化未捕获异常处理方案
     */
    public void initialization(Context context) {
        this.context = context;
        uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        //设置该当前类为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /**
     * 当系统发生没有捕获的异常的时候系统将会调用这里
     */
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if (!handleException(throwable) && uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, throwable);
        } else {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Log.e(LOG_TAG, "error : ", e);
            } finally {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
            }

        }
    }

    /**
     * 异常处理
     */
    private boolean handleException(Throwable throwable) {
        if (throwable == null) {
            return false;
        }
        //使用Toast来显示异常信息
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(context, "很抱歉，系统崩溃，即将自动退出...", Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        }.start();
        throwable.printStackTrace();
        //异常处理
        return true;
    }

    /**
     * 单例持有类，类级内部类，只有在正真使用的时候才会实例化
     */
    private static class SitexaUncaughtExceptionHandlerHolder {
        public static UncaughtExceptionHandler sitexaUncaughtExceptionHandler = new UncaughtExceptionHandler();
    }
}
