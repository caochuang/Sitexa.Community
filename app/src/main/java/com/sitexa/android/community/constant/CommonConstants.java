package com.sitexa.android.community.constant;

public class CommonConstants {

    /**
     * common activity操作过程中使用的变量
     */
    public static final class ActivityConstant {

        /**
         * 手机号码
         */
        public static final String ACTION_BAR_TITLE = "actionBarTitle";

        /**
         * 手机号码
         */
        public static final String PHONE_NUMBER = "phoneNumber";

        /**
         * 验证手机号码过后下一步的按钮名称
         */
        public static final String CHECK_PHONE_FINISH_NEXT_BUTTON = "checkPhoneFinishNextButtonText";

        /**
         * 发送验证码的上一步指令
         */
        public static final String LAST_COMMAND = "last_command";
        /**
         * 验证验证码后的下一步指令
         */
        public static final String NEXT_COMMAND = "next_command";

        /**
         * 发送验证码的上一步指令
         */
        public static final String SHOW_RROER_MESSAGE = "show_error+message";

        /**
         * 发送验证码的类型标志 :注册
         */
        public static final String VERIFY_CODE_TYPE_REGISTER = "1";

        /**
         * 发送验证码的类型标志 :验证码登入
         */
        public static final String VERIFY_CODE_TYPE_LOGIN = "2";

        /**
         * 发送验证码的类型标志 :验证码登入
         */
        public static final String VERIFY_CODE_TYPE_FIND_PASSWORD = "3";

        /**
         * 验证手机号码过后点击下一步打开的activity
         */
        public static final String CHECK_PHONE_FINISH_NEXT_ACTIVITY = "checkPhoneFinishNextActivity";

        /**
         * 图片查看默认的导航器标点
         */
        public static final String IMAGE_SHOW_DEFAULT_INDICATOR_POSITION = "position";

        /**
         * 查看图片的信息
         */
        public static final String IMAGE_SHOW_ITEMS = "IMAGE_SHOW_ITEMS";

        /**
         * 已经选定的图片的数量
         */
        public static final String SELECTED_IMGAE_NUMBER = "selected_image_number";

        /**
         * 选择的图片的路径集合
         */
        public static final String CHOOSE_PHOTO_PATHS = "choose_photo_paths";


        /**
         * 帖子类型
         */
        public static final String POST_OBJECT_TYPE = "postObjectType";

        /**
         * 帖子类型
         */
        public static final int POST = 1;
        public static final int BLOG = 2;
        public static final int GROUPSPACE = 3;

        /**
         * 查询site 数据 的 site 类型
         */
        public static final String SITE_TYPE_PROVINCE = "2";

        public static final String SITE_TYPE_CITY = "3";

        public static final String SITE_TYPE_DISTRICT = "4";

    }

}
