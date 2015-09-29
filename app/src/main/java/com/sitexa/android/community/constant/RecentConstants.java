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

package com.sitexa.android.community.constant;

public class RecentConstants {

    /**
     * 消息类型 纯文字
     */

    public static final int TYPE_TEXT = 1;
    /**
     * 消息类型 图片
     */
    public static final int TYPE_IMAGE = 2;

    /**
     * 消息类型 地理位置
     */
    public static final int TYPE_LOCATION = 3;
    /**
     * 消息类型 语音
     */
    public static final int TYPE_VOICE = 4;
    /**
     * 消息阅读状态 未读
     */
    public static final int STATE_UNREAD = 0;
    /**
     * 消息阅读状态 已读
     */
    public static final int STATE_READED = 1;

    /**
     * 消息阅读状态 已接收未读
     */
    public static final int STATE_UNREAD_RECEIVED = 2;

    /**
     * 消息发送状态 开始上传
     */
    public static final int STATUS_SEND_START = 0;
    /**
     * 消息发送状态 发送成功
     */
    public static final int STATUS_SEND_SUCCESS = 1;
    /**
     * 消息发送状态 发送失败
     */
    public static final int STATUS_SEND_FAIL = 2;
    /**
     * 消息发送状态 已接收
     */
    public static final int STATUS_SEND_RECEIVERED = 3;

}
