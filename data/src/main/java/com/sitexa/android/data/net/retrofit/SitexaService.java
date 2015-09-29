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

package com.sitexa.android.data.net.retrofit;

import com.sitexa.android.data.entity.UserEntity;
import com.sitexa.android.data.net.okhttp.ApiResult;

import java.util.Map;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.QueryMap;
import rx.Observable;

/**
 * Created by xnpeng on 15-9-24.
 * Accompany with RetrofitApi
 */
public interface SitexaService {

    interface BaseService{
    }

    interface UserService{
        @GET("/user/search")
        Observable<ApiResult> search(@QueryMap Map<String,String> search);

        @GET("/user/{identity}")
        Observable<ApiResult> getByIdentity(@Path("identity") String identity);

        @POST("/user/new")
        Observable<ApiResult> createUser(@Body UserEntity user);

        @POST("/user/edit")
        Observable<ApiResult> updateUser(@Body UserEntity user);

        @GET("/user/{id}")
        Observable<ApiResult> deleteUser(@Path("id") String id);
    }

    interface CommunityService{}

    interface GroupService{}

    interface PostService{}

    interface CommentService{}

    interface SpaceService{}

    interface BlogService{}

}
