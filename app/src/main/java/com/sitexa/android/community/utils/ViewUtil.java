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
import android.app.Dialog;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.sitexa.android.community.support.CallbackSingleParamFunction;
import com.sitexa.android.community.widget.MaterialDialog;
import com.sitexa.android.community.R;

public class ViewUtil {

    /**
     * 设置当前页面的透明度
     *
     * @param window 当前窗口
     * @param alpha  透明度值
     */
    public final static void setCurrentLayoutAlpha(Window window, float alpha) {
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.alpha = alpha;
        window.setAttributes(layoutParams);
    }


    /**
     * 显示自定义的Dialog
     *
     * @param context
     * @param view
     */
    public static Dialog showDialog(Activity context, View view) {
        Dialog dialog = new Dialog(context, R.style.MenuDialog);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        Window dialogWindow = dialog.getWindow();
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metric);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.width = (int) (metric.widthPixels * 0.8);
        lp.x = 0;
        lp.y = -(SystemUtil.dip2px(20));
        dialogWindow.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);
        dialogWindow.setAttributes(lp);
        dialog.show();
        return dialog;
    }


    /**
     * 显示加载等待框
     *
     * @param activity
     * @param text
     * @return
     */
    public static Dialog showLoading(Activity activity, String text) {
        View view = LayoutInflater.from(activity).inflate(R.layout.popupwindow_loading, null);
        TextView textView = (TextView) view.findViewById(R.id.tv_loading);
        textView.setText(text);
        Dialog dialog = showDialog(activity, view);
        dialog.setCanceledOnTouchOutside(false);
        //    dialog.setCancelable(false);
        return dialog;
    }


    /**
     * 显示加载等待框
     *
     * @param activity
     * @param resId
     * @return
     */
    public static Dialog showLoading(Activity activity, int resId) {
        return showLoading(activity, activity.getResources().getString(resId));
    }


    /**
     * 弹出询问框
     *
     * @param activity                    弹出的activity
     * @param message                     提示消息
     * @param title                       标题
     * @param positiveButton              右边按钮
     * @param negativeButton              左边按钮
     * @param callbackSingleParamFunction 右边按钮回调函数
     * @param callbackSingleParamFunction 左边按钮回调函数
     * @return
     */
    public static MaterialDialog showAsk(Activity activity, int message, int title, int positiveButton, int negativeButton, final CallbackSingleParamFunction callbackSingleParamFunction, final CallbackSingleParamFunction callbackSingleParamFunction1) {
        final MaterialDialog builder = new MaterialDialog(activity);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setPositiveButton(positiveButton, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callbackSingleParamFunction != null) {
                    callbackSingleParamFunction.callback(null);
                }
                builder.dismiss();
            }
        });
        builder.setNegativeButton(negativeButton, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callbackSingleParamFunction1 != null) {
                    callbackSingleParamFunction1.callback(null);
                }
                builder.dismiss();
            }
        });
        builder.setCanceledOnTouchOutside(true);
        builder.show();
        return builder;
    }

    /**
     * 弹出询问框
     *
     * @param activity                    弹出的activity
     * @param message                     提示消息
     * @param title                       标题
     * @param positiveButton              右边按钮
     * @param negativeButton              左边按钮
     * @param callbackSingleParamFunction 右边按钮回调函数
     */
    public static MaterialDialog showAsk(Activity activity, int message, int title, int positiveButton, int negativeButton, final CallbackSingleParamFunction callbackSingleParamFunction) {
        return showAsk(activity, message, title, positiveButton, negativeButton, callbackSingleParamFunction, null);
    }

    /**
     * 弹出是和否询问框
     *
     * @param activity                    弹出的activity
     * @param message                     提示消息
     * @param callbackSingleParamFunction 右边按钮回调函数
     */
    public static MaterialDialog showYesOrNoAsk(Activity activity, int message, final CallbackSingleParamFunction callbackSingleParamFunction) {
        return showAsk(activity, message, R.string.prompt, R.string.ok, R.string.cancel, callbackSingleParamFunction, null);
    }


    /**
     * 在底部提示信息
     *
     * @param text
     */
    public static void showToast(Activity activity, String text) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();
    }

    /**
     * 在底部提示信息
     *
     * @param resid
     */
    public static void showToast(Activity activity, int resid) {
        Toast.makeText(activity, resid, Toast.LENGTH_SHORT).show();
    }

}
