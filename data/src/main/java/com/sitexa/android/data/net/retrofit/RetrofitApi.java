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
public class RetrofitApi {

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
