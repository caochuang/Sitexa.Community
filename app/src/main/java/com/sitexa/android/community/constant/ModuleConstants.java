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

public class ModuleConstants {

    public final static class Square {

        /**
         * 自动刷新广场列表数据
         */
        public static final String AUTO_REFRESH_SQUARE_LIST = "auto_refresh_square_list";

        /**
         * 刷新类型
         */
        public static final String AUTO_REFRESH_SQUARE_LIST_TYPE = "auto_refresh_square_list_type";

        /**
         * 自动刷新广场列表头数据
         */
        public static final int AUTO_REFRESH_SQUARE_LIST_TYPE_FIRST = 0;

        /**
         * 自动刷新广场列表尾数据
         */
        public static final int AUTO_REFRESH_SQUARE_LIST_TYPE_LAST = 1;

        /**
         * 自动刷新广场列表本地分享
         */
        public static final int AUTO_REFRESH_SQUARE_LIST_TYPE_LOCAL_SHARE = 2;

        /**
         * 自动刷新广场列表数据更改
         */
        public static final int AUTO_REFRESH_SQUARE_LIST_TYPE_CHANGE_POST = 3;

        /**
         * 自动刷新广场列表帖子被删除
         */
        public static final int AUTO_REFRESH_SQUARE_LIST_TYPE_DELETE = 4;

        /**
         * 自动刷新广场列表原帖被删除
         */
        public static final int AUTO_REFRESH_SQUARE_LIST_TYPE_ORIGINAL_DELETE = 5;


        /**
         * 本地分享
         */
        public static final String LOCAL_SHARE_POST = "local_share_post";

        /**
         * post对象
         */
        public static final String POST_ = "post";

        /**
         * 位置
         */
        public static final String POST_POSITION = "position";

        /**
         * 分享图大小
         */
        public static final int FORWARD_IMAGE_WIDTH = 50;


        /**
         * 用户头像大小
         */
        public static final int USER_HEAD_ICON_WIDTH = 250;

        /**
         * 一张的图片宽度
         */
        public static final int SINGLE_IMAGE_WIDTH = 350;

        /**
         * 两张张的图片宽度
         */
        public static final int DOUBLE_IMAGE_WIDTH = 250;

        /**
         * 图片宽度
         */
        public static final int IMAGE_WIDTH = 200;

        /**
         * 视频封面宽度
         */
        public static final int VIDEO_COVER_IMAGE_WIDTH = 350;

        /**
         * 视频封面宽度
         */
        public static final int VIDEO_COVER_IMAGE_WIDTH_ = 150;


        /**
         * 评论分页带大小
         */
        public static final int COMMENT_PAGE_SIZE = 20;

        /**
         * 帖子不存在
         */
        public static final String POST_NOT_EXISTS = "10010";

        /**
         * 原帖已经被删除
         */
        public static final String ORIGINAL_IS_DELETED = "10032";


    }


    public final static class Group {
        /**
         * 全开放加入部落，不需要验证
         */
        public static final boolean JOIN_GROUP_FLAG_1 = true;

        /**
         * 非全开放加入部落，需要审核
         */
        public static final boolean JOIN_GROUP_FLAG_0 = false;

        /**
         * 默认分页大小
         */
        public static final int PAGE_SIZE = 20;

        /**
         * 1:当前登录用户创建的部落
         */
        public static final String CURRENT_USER_CREATE = "1";

        /**
         * 2:当前登录用户加入的部落
         */
        public static final String CURRENT_USER_JOIN = "2";

        /**
         * 3:当前登录用户未加入的部落
         */
        public static final String CURRENT_USER_UN_JOIN = "3";

        /**
         * 同意成员申请
         */
        public static final String JOIN_REQUEST_HANDLE_AGREE = "1";

        /**
         * 拒绝成员申请
         */
        public static final String JOIN_REQUEST_HANDLE_REJECT = "0";

        /**
         * 自动刷新部落列表数据
         */
        public static final String AUTO_REFRESH_GROUP_LIST = "auto_refresh_group_list";

        /**
         * 刷新类型
         */
        public static final String AUTO_REFRESH_GROUP_LIST_TYPE = "auto_refresh_group_list_type";

        /**
         * 自动刷新部落列表头数据
         */
        public static final int AUTO_REFRESH_GROUP_LIST_TYPE_FIRST = 0;

        /**
         * 自动刷新部落列表尾数据
         */
        public static final int AUTO_REFRESH_GROUP_LIST_TYPE_LAST = 1;

        /**
         * 自动刷新部落列表本地分享
         */
        public static final int AUTO_REFRESH_GROUP_LIST_TYPE_LOCAL_SHARE = 2;

        /**
         * 自动刷新部落列表数据更改
         */
        public static final int AUTO_REFRESH_GROUP_LIST_TYPE_CHANGE_GROUP = 3;

        /**
         * 自动刷新部落列表数据更改，加入后
         */
        public static final int AUTO_REFRESH_GROUP_LIST_TYPE_CHANGE_GROUP_JOIN = 4;

        /**
         * 自动刷新部落列表数据更改，退出后
         */
        public static final int AUTO_REFRESH_GROUP_LIST_TYPE_CHANGE_GROUP_QUIT = 5;

        /**
         * 自动刷新部落列表数据更改，解散后
         */
        public static final int AUTO_REFRESH_GROUP_LIST_TYPE_CHANGE_GROUP_DISMISS = 6;
        /**
         * 本地同步部落
         */
        public static final String LOCAL_NOTIFY_GROUP = "local_notify_group";

        /**
         * 自动刷新部落空间列表数据
         */
        public static final String AUTO_REFRESH_GROUP_SPACE_LIST = "auto_refresh_group_space_list";

        /**
         * 刷新类型
         */
        public static final String AUTO_REFRESH_GROUP_SPACE_LIST_TYPE = "auto_refresh_group_space_list_type";

        /**
         * 自动刷新部落列表头数据
         */
        public static final int AUTO_REFRESH_GROUP_SPACE_LIST_TYPE_FIRST = 0;

        /**
         * 自动刷新部落空间列表尾数据
         */
        public static final int AUTO_REFRESH_GROUP_SPACE_LIST_TYPE_LAST = 1;

        /**
         * 自动刷新部落空间列表本地分享
         */
        public static final int AUTO_REFRESH_GROUP_SPACE_LIST_TYPE_LOCAL_SHARE = 2;

        /**
         * 自动刷新部落空间列表数据更改
         */
        public static final int AUTO_REFRESH_GROUP_SPACE_LIST_TYPE_CHANGE_GROUP_SPACE = 3;

        /**
         * 本地同步部落空间
         */
        public static final String LOCAL_NOTIFY_GROUP_SPACE = "local_notify_group_space";

        /**
         * 自动刷新部落验证消息列表数据
         */
        public static final String AUTO_REFRESH_GROUP_REQUEST_LIST = "auto_refresh_group_request_list";

        /**
         * 刷新类型
         */
        public static final String AUTO_REFRESH_GROUP_REQUEST_LIST_TYPE = "auto_refresh_group_request_list_type";


        /**
         * 自动刷新部落验证消息列表本地分享
         */
        public static final int AUTO_REFRESH_GROUP_REQUEST_LIST_TYPE_LOCAL_SHARE = 2;


        /**
         * 自动刷新部落验证消息列表数据更改
         */
        public static final int AUTO_REFRESH_GROUP_REQUEST_LIST_TYPE_CHANGE_GROUP_REQUEST = 3;

        /**
         * 本地同步部落验证消息
         */
        public static final String LOCAL_NOTIFY_GROUP_REQUEST = "local_notify_group_request";

        /**
         * 部落申请消息处理结果
         */
        public static final String GROUP_REQEUST_AUDIT_RESULT = "group_request_audit_result";

        /**
         * 性别：男
         */
        public static final String GENDER_MALE = "1";

        /**
         * 性别：女
         */
        public static final String GENDER_FAMALE = "0";

        /**
         * 部落对象
         */
        public static final String GROUP_OBJECT = "group";

        /**
         * 部落空间对象
         */
        public static final String GROUP_SPACE_OBJECT = "group_space";

        /**
         * 部落对象位置
         */
        public static final String GROUP_OBJECT_POSITION = "group_position";

        /**
         * 部落空间对象位置
         */
        public static final String GROUP_SPACE_OBJECT_POSITION = "group_space_position";

        /**
         * 部落申请消息对象位置
         */
        public static final String GROUP_REQUEST_OBJECT_POSITION = "group_reqeust_position";

        /**
         * 部落主题，特殊处理
         */
        public static final String GROUP_THEME = "group_theme";

        /**
         * 部落空间关闭
         */
        public static final String GROUP_SPACE_FINISH = "group_space_finish";

    }

    public final static class Profile {

        /**
         * blog对象
         */
        public static final String BLOG = "blog";

        /**
         * 本地分享
         */
        public static final String LOCAL_SHARE_BLOG = "local_share_blog";

        /**
         * 位置
         */
        public static final String BLOG_POSITION = "position";
        /**
         * 自动刷新blog数据
         */
        public static final String AUTO_REFRESH_BLOG_LIST = "auto_refresh_blog_list";

        /**
         * 刷新类型
         */
        public static final String AUTO_REFRESH_BLOG_LIST_TYPE = "auto_refresh_blog_list_type";


        public static final String BLOG_ID = "blogId";


        /**
         * 自动刷新个人空间列表本地分享
         */
        public static final int AUTO_REFRESH_BLOG_LIST_TYPE_LOCAL_SHARE = 1;

        /**
         * 自动刷新个人空间列表数据更改
         */
        public static final int AUTO_REFRESH_BLOG_LIST_TYPE_CHANGE_BLOG = 2;

        /**
         * 自动刷新个人空间列表数据更改
         */
        public static final int AUTO_REFRESH_BLOG_LIST_TYPE_DELETE_BLOG = 3;

        /**
         * 用户名已被使用
         */
        public static final String ORIGINAL_CODE_USERNAME_USERD = "10056";

        /**
         * 验证码错误
         */
        public static final String ORIGINAL_CODE_VERIFY_CODE_ERROR= "10055";

        /**
         * 手机号已被注册
         */
        public static final String ORIGINAL_CODE_MOBILE_USERD = "10057";
    }


    public static final String OBEJCT_TYPE_POST = "POST";
    public static final String OBEJCT_TYPE_BLOG = "BLOG";
    public static final String OBEJCT_TYPE_GROUPSPACE = "GROUPSPACE";


    /**
     * 分享相关
     */
    public static class Share {

        /**
         * 音频文件夹
         */
        public static final String VOICE_CACHE_DIR_NAME = "voice";
    }


    public static final class COMMUNITY_USER_REQUEST_STATUS {
        public static final String WAITING_FOR_AUDIT = "00"; //待审核
        public static final String AUDITED_AGREE = "10";     //审核通过
        public static final String AUDITED_REJECT = "20";    //审核拒绝
    }

}
