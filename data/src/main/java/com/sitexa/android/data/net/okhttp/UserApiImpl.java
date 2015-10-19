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

package com.sitexa.android.data.net.okhttp;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sitexa.android.data.constant.ApplicationConstants;
import com.sitexa.android.data.entity.UserEntity;

import java.util.ArrayList;
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
    private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

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
        return Observable.create(subscriber -> {
            try {
                String json = OkHttpApi.newInstance(this.context)
                        .getRequest(API_URL_GET_USER_LIST, params)
                        .call();

                ApiResult apiResult = new ApiResult();
                apiResult.setValue(json);
                List<UserEntity> entities = apiResult.getDomainList(new TypeToken<List<UserEntity>>() {
                }.getType());
                entities = reformImageUrl(entities);
                subscriber.onNext(entities);
                subscriber.onCompleted();
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });

    }

    @Override
    public Observable<UserEntity> userEntityById(final long userId) {
        Map<String, String> params = new HashMap<>();
        params.put("userId", String.valueOf(userId));
        return Observable.create(subscriber -> {
            try {
                String json = OkHttpApi.newInstance(this.context)
                        .getRequest(API_URL_GET_USER_DETAILS, params)
                        .call();
                ApiResult apiResult = new ApiResult();
                apiResult.setValue(json);
                UserEntity entity = apiResult.getDomain(UserEntity.class);
                entity = reformImageUrl(entity);
                subscriber.onNext(entity);
                subscriber.onCompleted();
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });
    }

    @Override
    public Observable<UserEntity> userLogin(Map<String, String> fields) {
        return Observable.create(subscriber -> {
            try {
                String json = OkHttpApi.newInstance(this.context)
                        .getRequest(API_URL_USER_LOGIN, fields)
                        .call();
                ApiResult apiResult = new ApiResult();
                apiResult.setValue(json);
                UserEntity entity = apiResult.getDomain(UserEntity.class);
                entity = reformImageUrl(entity);
                subscriber.onNext(entity);
                subscriber.onCompleted();
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });
    }

    @Override
    public Observable<String> getVerifyCode(Map<String, String> param) {
        return Observable.create(subscriber -> {
            try {
                String json = OkHttpApi.newInstance(this.context)
                        .getRequest(SEND_VERIFY_CODE_2_REGISTER, param)
                        .call();
                subscriber.onNext(json);
                subscriber.onCompleted();
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });
    }

    private UserEntity reformImageUrl(UserEntity userEntity) {
        String imgUrl = userEntity.getCoverImagePath();
        if (imgUrl != null && !"".equals(imgUrl))
            userEntity.setCoverImagePath(ApplicationConstants.IMAGE_DOMAIN + imgUrl);

        String img2 = userEntity.getHeadIcon();
        if (img2 != null && !"".equals(img2))
            userEntity.setHeadIcon(ApplicationConstants.IMAGE_DOMAIN + img2);

        return userEntity;
    }

    private List<UserEntity> reformImageUrl(List<UserEntity> userEntities) {
        List<UserEntity> entities = new ArrayList<>(userEntities.size());
        for (UserEntity entity : userEntities) {
            entity = reformImageUrl(entity);
            entities.add(entity);
        }
        return entities;
    }

}
