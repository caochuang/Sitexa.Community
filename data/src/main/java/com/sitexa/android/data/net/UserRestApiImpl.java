/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sitexa.android.data.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.sitexa.android.data.constant.ApplicationConstants;
import com.sitexa.android.data.entity.UserEntity;
import com.sitexa.android.data.entity.mapper.UserEntityJsonMapper;
import com.sitexa.android.data.exception.NetworkConnectionException;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * {@link UserRestApi} implementation for retrieving data from the network.
 */
public class UserRestApiImpl implements UserRestApi {

    private final Context context;
    private final UserEntityJsonMapper userEntityJsonMapper;

    /**
     * Constructor of the class
     *
     * @param context              {@link android.content.Context}.
     * @param userEntityJsonMapper {@link UserEntityJsonMapper}.
     */
    public UserRestApiImpl(Context context, UserEntityJsonMapper userEntityJsonMapper) {
        if (context == null || userEntityJsonMapper == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.context = context.getApplicationContext();
        this.userEntityJsonMapper = userEntityJsonMapper;
    }

    @Override
    public Observable<List<UserEntity>> userEntityList() {
        return Observable.create(new Observable.OnSubscribe<List<UserEntity>>() {
            @Override
            public void call(Subscriber<? super List<UserEntity>> subscriber) {

                if (isThereInternetConnection()) {
                    try {
                        String responseUserEntities = getUserEntitiesFromApi();

                        if (responseUserEntities != null) {
                            List<UserEntity> userEntities = userEntityJsonMapper.transformUserEntityCollection(responseUserEntities);
                            userEntities = reformImageUrl(userEntities);
                            subscriber.onNext(userEntities);
                            subscriber.onCompleted();
                        } else {
                            subscriber.onError(new NetworkConnectionException("response userEntities is null"));
                        }
                    } catch (Exception e) {
                        subscriber.onError(new NetworkConnectionException(e.getCause()));
                    }
                } else {
                    subscriber.onError(new NetworkConnectionException("no network connection error"));
                }
            }
        });
    }

    @Override
    public Observable<UserEntity> userEntityById(final int userId) {
        return Observable.create(new Observable.OnSubscribe<UserEntity>() {
            @Override
            public void call(Subscriber<? super UserEntity> subscriber) {

                if (isThereInternetConnection()) {
                    try {
                        String responseUserDetails = getUserDetailsFromApi(userId);
                        if (responseUserDetails != null) {
                            UserEntity userEntity = userEntityJsonMapper.transformUserEntity(responseUserDetails);
                            userEntity = reformImageUrl(userEntity);
                            subscriber.onNext(userEntity);
                            subscriber.onCompleted();
                        } else {
                            subscriber.onError(new NetworkConnectionException("response UserDetails is null"));
                        }
                    } catch (Exception e) {
                        subscriber.onError(new NetworkConnectionException(e.getCause()));
                    }
                } else {
                    subscriber.onError(new NetworkConnectionException("no network connection error"));
                }
            }
        });
    }

    private String getUserEntitiesFromApi() throws Exception {
        return ApiConnection.createGET(UserRestApi.API_URL_GET_USER_LIST).requestSyncCall();
    }

    private String getUserDetailsFromApi(int userId) throws Exception {
        String apiUrl = UserRestApi.API_URL_GET_USER_DETAILS + userId;
        return ApiConnection.createGET(apiUrl).requestSyncCall();
    }

    /**
     * Checks if the device has any active internet connection.
     *
     * @return true device with internet connection, otherwise false.
     */
    private boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
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
