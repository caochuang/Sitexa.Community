package com.sitexa.android.data.net;

import com.google.gson.reflect.TypeToken;
import com.sitexa.android.data.constant.ApplicationConstants;
import com.sitexa.android.data.entity.UserEntity;

import java.util.List;
import java.util.Map;

import retrofit.RestAdapter;
import rx.Observable;

/**
 * Created by xnpeng on 15-9-24.
 */
public class NetworkApi {

    private final String baseUrl = ApplicationConstants.API_DOMAIN;

    private RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(baseUrl)
            .setLogLevel(RestAdapter.LogLevel.BASIC)
            .build();

    public class UserRestApi {
        final SitexaService.UserService userService;

        public UserRestApi() {
            userService = restAdapter.create(SitexaService.UserService.class);
        }

        public Observable<List<UserEntity>> search(Map<String, String> search) {
            return userService.search(search).map(apiResult -> apiResult.getDomainList(new TypeToken<List<UserEntity>>() {
            }.getType()));
        }

        public Observable<UserEntity> getByIdentity(String identity) {
            return userService.getByIdentity(identity).map(apiResult -> apiResult.getDomain(UserEntity.class));
        }

        public Observable<UserEntity> createUser(UserEntity userEntity) {
            return userService.createUser(userEntity).map(apiResult -> apiResult.getDomain(UserEntity.class));
        }

        public Observable<String> updateUser(UserEntity userEntity) {
            return userService.updateUser(userEntity).map(apiResult -> apiResult.getCode() + "");
        }

        public Observable<String> deleteUser(String id) {
            return userService.deleteUser(id).map(apiResult -> apiResult.getCode() + "");
        }
    }

}
