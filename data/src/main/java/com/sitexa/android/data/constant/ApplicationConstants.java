package com.sitexa.android.data.constant;

public final class ApplicationConstants {

    /**
     * 图片路径
     */
    public final static String IMAGE_DOMAIN = "http://daigone-image.b0.upaiyun.com";

    /**
     * 多媒体路径
     */
    public final static String MEDIA_DOMAIN = "http://daigone-media.b0.upaiyun.com";

    /**
     * api地址
     */
    public final static String API_DOMAIN = "http://192.168.0.100:8080";
    /**
     * 图片前缀
     */
    public final static String IMAGE_NAME_PREFIX = "DG_";
    /**
     * 默认的图片格式
     */
    public final static String DEFAULT_IMAGE_NAME_FORMAT = ".jpg";
    /**
     * 上传图片的张数
     */
    public final static int UPLOAD_IMAGE_LIMIT = 9;
    /**
     * 没有图片的情况下显示默认的图片
     */
    public final static String NO_IMAGE_SHOW_DEFAULT = "default_show_image";
    /**
     * APK下载地址
     */
    public final static String APK_DOWNLOAD_URL = "apk_download_url";
    /**
     * logo
     */
    public final static String LOGO = "icon_logo";
    /**
     * 是否播放过启动引导
     */
    public final static String HAS_PLAYING_GUIDE_ANIM = "HAS_PLAYING_GUIDE_ANIM";
    /**
     * 超级老大们的社区
     */
    public final static int SUPER_COMMUNITY = 1;
    /**
     * 重新登陆社区
     */
    public final static String RE_LOGIN_COMMUNITY = "reLoginCommunity";

    /**
     * 云存储配置
     */
    public final static class CloudStorage {

        /**
         * 又拍云路径
         */
        public final static String UPYUN_IMAGE_DOMAIN = "http://daigone-image.b0.upaiyun.com";

        /**
         * FORM API KEYl
         */
        public final static String UPYUN_IMAGE_FORM_API_KEY = "hsWcLg8pGptMWUzxVjLTVrvR6MU=";

        /**
         * FORM API KEYl
         */
        public final static String UPYUN_MEDIA_FORM_API_KEY = "uprTSDvcKc4mLqTKgrjYM1Y84io=";

        /**
         * 又拍云图片空间
         */
        public final static String UPYUN_IMAGE_BUCKET = "daigone-image";

        /**
         * 又拍云多媒体空间
         */
        public final static String UPYUN_MEDIA_BUCKET = "daigone-media";

        /**
         * 又拍云存储根目录空间
         */
        public final static String UPYUN_DAIGONE_ROOT = "/daigone";

        /**
         * 通用图片存储空间
         */
        public final static String UPYUN_COMMON_IMAGE_BUCKET = UPYUN_DAIGONE_ROOT + "/common";

        /**
         * 用户图片存储空间
         */
        public final static String UPYUN_USER_IMAGE_BUCKET = UPYUN_DAIGONE_ROOT + "/user";

        /**
         * 通用视频存储目录
         */
        public final static String UPYUN_COMMON_VIDEO_BUCKET = UPYUN_DAIGONE_ROOT + "/common/video";

        /**
         * 用户视频存储目录
         */
        public final static String UPYUN_USER_VIDEO_BUCKET = UPYUN_DAIGONE_ROOT + "/user/video";

        /**
         * 通用音频存储目录
         */
        public final static String UPYUN_COMMON_AUDIO_BUCKET = UPYUN_DAIGONE_ROOT + "/common/audio";

        /**
         * 用户音频存储目录
         */
        public final static String UPYUN_USER_AUDIO_BUCKET = UPYUN_DAIGONE_ROOT + "/user/audio";

        /**
         * 又拍云存储图片宽度固定，高度自己适应的版本
         */
        public final static String UPYUN_IMAGE_VERSION_WIDTH_ = "!width%d";

        /**
         * 图片版本名称
         */
        public final static String UPYUN_IMAGE_VERSION_NAME = "!width";

    }

    /**
     * 开放SDK配置
     */
    public final static class OpenSDK_APPID {

        /**
         * 科大讯飞云语音开发SDK
         */
        public final static String XUNFEI_VOICE_CLOUD_APP_ID = "54700de3";

    }

    /**
     * 通知动作
     */
    public final static class IntentAction {
        /**
         * 关闭所有活着的activity以退出系统
         */
        public final static String FINISH_ACTIVITY_ACTION = "finish_activity_action";

        /**
         * 服务器推送到了新消息
         */
        public final static String SERVER_PUSH_MESSAGE_ACTION = "server_push_message_action";

        /**
         * 切换社区通知
         */
        public final static String CHANGE_COMMUNITY_ACTION = "change_community_action";

        /**
         * 审核社区成功
         */
        public final static String AUDIT_COMMUNITY_SUCCESS = "audit_community_success";
        /**
         * 审核社区成员成功
         */
        public final static String AUDIT_COMMUNITY_MEMBER_SUCCESS = "audit_community_member_success";

        /**
         * 用户已经在别的机器重新登陆过
         */
        public final static String USER_RE_LOGIN = "user_re_login";

        /**
         * 重新登陆社区
         */
        public final static String RE_LOGIN_COMMUNITY = "reLoginCommunity";
    }
}

