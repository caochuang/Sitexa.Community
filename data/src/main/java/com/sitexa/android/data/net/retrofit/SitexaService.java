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
