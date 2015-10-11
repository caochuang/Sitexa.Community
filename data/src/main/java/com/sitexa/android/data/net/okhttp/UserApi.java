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

import com.sitexa.android.data.entity.UserEntity;

import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * RestApi for retrieving data from the network.
 */
public interface UserApi {
    /**
     * Api url for getting all users
     */
    String API_URL_GET_USER_LIST = "/user/getUserList";

    /**
     * Api url for getting a user profile
     */
    String API_URL_GET_USER_DETAILS = "/user/findUserById";

    String API_URL_USER_LOGIN = "/authority/doLogin";

    /**
     * Retrieves an {@link Observable} which will emit a List of {@link UserEntity}.
     */
    Observable<List<UserEntity>> userEntityList();

    /**
     * Retrieves an {@link Observable} which will emit a {@link UserEntity}.
     *
     * @param userId The user id used to get user data.
     */
    Observable<UserEntity> userEntityById(final long userId);

    Observable<UserEntity> userLogin(final Map<String, String> fields);
}
