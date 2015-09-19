package com.sitexa.android.data.constant;

/**
 * 代码常量类，该类统一定义请求码，而且该请码与后端对应。每个类别的代码分别分配100个代码段
 */
public class CodeConstants {


    /**
     * 通用代码. 0-99
     */
    public final static class CommonCode {
        /**
         * 否
         */
        public final static int NO = 0;

        /**
         * 是
         */
        public final static int YES = 1;
    }


    /**
     * API请求代码. 100-200
     */
    public final static class ApiCode {

        /**
         * 成功
         */
        public final static int OK = 100;

        /**
         * 业务异常(非正常，不可预计)
         */
        public final static int ERROR = 101;

        /**
         * 业务失败(业务正常，但是验证错误)
         */
        public final static int FAILURE = 103;

        /**
         * 服务器链接异常
         */
        public final static int SERVER_CONNECTION_ERROR = 104;

        /**
         * 网络不可用
         */
        public final static int NETWORK_ERROR = 105;
    }

    /**
     * 网络请求代码
     */
    public final static class HttpCode {

        /**
         * 代码
         */
        public static final String CODE = "code";

        /**
         * 值
         */
        public static final String VALUE = "value";

        /**
         * 请求成功状态码
         */
        public static final String SUCCESS_CODE = "00000";

        /**
         * 业务处理异常状态码
         */
        public static final String BUSINESS_ERROR_CODE = "10000";

        /**
         * 用户没有登陆
         */
        public static final String USER_NOT_LOGIN = "10043";
    }


    /**
     * Intent识别代码。201-300
     */
    public final static class IntentCode {
        /**
         * 请求相机拍摄
         */
        public final static int REQUEST_CODE_CAMERA = 201;

        /**
         * 请求相册选择图片
         */
        public final static int REQUEST_CODE_ALBUM_CHOOSE_PHOTO = 202;

        /**
         * 请求剪裁图片
         */
        public final static int REQUEST_CODE_CROP_PHOTO = 203;
    }


    /**
     * 推送代码
     */
    public final static class PushCode {

        /**
         * 推送代码
         */
        public final static String PUSH_CODE = "code";

        /**
         * 推送值
         */
        public final static String PUSH_VALUE = "value";

        /**
         * 广场评论新消息推送
         */
        public final static int SQUARE_COMMENT_NEW_MESSAGE_CODE = 301;

        /**
         * 部落新帖子推送
         */
        public final static int GROUP_POST_NEW_MESSAGE_CODE = 302;

        /**
         * 部落评论新消息推送
         */
        public final static int GROUP_COMMENT_NEW_MESSAGE_CODE = 303;

        /**
         * 部落请求验证新消息推送
         */
        public final static int GROUP_REQUEST_NEW_MESSAGE_CODE = 304;

        /**
         * 个人空间评论新消息推送
         */
        public final static int BLOG_COMMENT_NEW_MESSAGE_CODE = 305;

        /**
         * 异地登陆消息推送
         */
        public final static int USER_LOGINED_NEW_CODE = 306;


        /**
         * 用户申请变更主社区。消息推送给管理员
         */
        public final static int COMMUNITY_USER_NEW_REQUEST = 307;

        /**
         * 社区用户申请请求已经被审核，消息推送给用户
         */
        public final static int COMMUNITY_USER_REQUEST_AUDITED = 308;

        /**
         * 用户申请加入部落消息被审核推送。审核后，消息推送给申请的用户
         */
        public final static int JOIN_GROUP_REQUEST_MESSAGE_AUDITED_CODE = 309;

        /**
         * 社区审核后推送消息给创建者
         */
        public final static int COMMUNITY_AUDITED_NEW_CODE = 310;

        /**
         * 用户创建社区后，推送给平台管理员
         */
        public final static int COMMUNITY_CREATE_NEW_CODE = 312;
    }


}
