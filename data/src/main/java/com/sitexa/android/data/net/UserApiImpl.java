package com.sitexa.android.data.net;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.sitexa.android.data.entity.UserEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * Created by xnpeng on 15-9-16.
 */
public class UserApiImpl implements UserApi {

    private final String TAG = UserApiImpl.class.getSimpleName();
    private Context context;

    public UserApiImpl(Context context) {
        this.context = context;
        if (context == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
    }

    @Override
    public Observable<List<UserEntity>> userEntityList() {
        Map<String, String> params = new HashMap<>();
        params.put("pageNumber", "0");
        params.put("pageSize", "20");
        return OkHttpApi.newInstance(this.context)
                .getRequest(UserApi.API_URL_GET_USER_LIST, params)
                .call()
                .map(apiResult -> apiResult.getDomainList(new TypeToken<List<UserEntity>>() {
                }.getType()));
    }

    @Override
    public Observable<UserEntity> userEntityById(final long userId) {
        Map<String, String> params = new HashMap<>();
        params.put("userId", String.valueOf(userId));
        return OkHttpApi.newInstance(this.context)
                .getRequest(UserApi.API_URL_GET_USER_DETAILS, params)
                .call()
                .map(apiResult -> apiResult.getDomain(UserEntity.class));
    }

}
