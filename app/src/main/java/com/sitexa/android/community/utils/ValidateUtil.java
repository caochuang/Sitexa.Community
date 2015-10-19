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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {

    private static final String mobileNoPattern = "\\b^(13[0-9]|15[012356789]|17[0678]|18[0-9]|14[57])[0-9]{8}$\\b";
    private static final String emailAddressPattern = "\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";

    public static boolean validateEmail(String email) {
        return true;
    }

    public static boolean validateMobile(String mobileNo) {
        Pattern pattern = Pattern.compile(mobileNoPattern);
        Matcher matcher = pattern.matcher(mobileNo);
        return matcher.matches();
    }

    public static boolean validateDate(String sDate) {
        return true;
    }

    public static boolean validateDateTime(String sDateTime) {
        return true;
    }
}
