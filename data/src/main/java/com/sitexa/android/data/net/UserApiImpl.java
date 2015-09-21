package com.sitexa.android.data.net;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.sitexa.android.data.entity.UserEntity;
import com.sitexa.android.data.entity.mapper.UserEntityJsonMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * Created by xnpeng on 15-9-16.
 */
public class UserApiImpl extends BaseApi implements UserApi {

    private final UserEntityJsonMapper userEntityJsonMapper;

    public UserApiImpl(Context context, UserEntityJsonMapper userEntityJsonMapper) {
        super(context);
        if (context == null || userEntityJsonMapper == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.userEntityJsonMapper = userEntityJsonMapper;
    }

    @Override
    public Observable<List<UserEntity>> userEntityList() {
        String url = UserApi.API_URL_GET_USER_LIST;
        Map<String,String> params = new HashMap<>();
        params.put("pageNumber","0");
        params.put("pageSize", "20");
        return this.get(url,params).map(apiResult -> apiResult.getDomainList(new TypeToken<List<UserEntity>>() { }.getType()));
    }

    @Override
    public Observable<UserEntity> userEntityById(long userId) {
        String url = UserApi.API_URL_GET_USER_DETAILS;
        Map<String,String> params = new HashMap<>();
        params.put("userId",String.valueOf(userId));
        return this.get(url,params).map(apiResult -> apiResult.getDomain(UserEntity.class));
    }
}
