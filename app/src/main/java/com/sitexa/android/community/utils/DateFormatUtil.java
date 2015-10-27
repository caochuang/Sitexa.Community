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

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

public class DateFormatUtil extends DateFormatUtils {


    /**
     * 默认的时间戳格式
     */
    public static final String TIMESTAMP_DEFAULT_PATTERN = "yyyyMMdd_HHmmss";

    /**
     * 默认的时间格式
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy/MM/dd HH:mm";

    /**
     * 文件存储格式
     */
    public static final String FILE_STORAGE_FORMAT = "yyyy-MM";

    /**
     * 格式化当前时间
     *
     * @return
     */
    public static final String formatCurrentDate() {
        return DateFormatUtil.format(new Date(), DateFormatUtil.DEFAULT_DATE_FORMAT);
    }

    /**
     * 格式化当前时间
     *
     * @return
     */
    public static final String formatCurrentDate(String format) {
        return DateFormatUtil.format(new Date(), format);
    }

    /**
     * 格式化当前时间
     *
     * @return
     */
    public static final String formatDate(Date date) {
        return DateFormatUtil.format(date, DateFormatUtil.DEFAULT_DATE_FORMAT);
    }


    /**
     * 获取当前时间时间戳
     *
     * @return
     */
    public static final String formatCurrentTimestamp() {
        return DateFormatUtil.format(new Date(), DateFormatUtil.TIMESTAMP_DEFAULT_PATTERN);
    }

}
