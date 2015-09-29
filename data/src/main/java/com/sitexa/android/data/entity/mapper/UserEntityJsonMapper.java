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
package com.sitexa.android.data.entity.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sitexa.android.data.constant.CodeConstants;
import com.sitexa.android.data.entity.UserEntity;
import com.sitexa.android.data.exception.NetworkConnectionException;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Class used to transform from Strings representing json to valid objects.
 */
public class UserEntityJsonMapper {

    private final static String TAG = UserEntityJsonMapper.class.getSimpleName();

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    @Inject
    public UserEntityJsonMapper() {
    }

    /**
     * Transform from valid json string to {@link UserEntity}.
     *
     * @param userJsonResponse A json representing a user profile.
     * @return {@link UserEntity}.
     * @throws JsonSyntaxException if the json string is not a valid json structure.
     */
    public UserEntity transformUserEntity(String userJsonResponse) throws Exception {
        try {
            Map map = gson.fromJson(userJsonResponse, Map.class);
            String code = (String) map.get(CodeConstants.HttpCode.CODE);
            Object value = map.get(CodeConstants.HttpCode.VALUE);

            if (CodeConstants.HttpCode.SUCCESS_CODE.equals(code)) {
                Type userEntityType = new TypeToken<UserEntity>() {
                }.getType();
                return gson.fromJson(gson.toJson(value), userEntityType);
            } else {
                throw new RuntimeException(new NetworkConnectionException(CodeConstants.ApiCode.ERROR + " : " + String.valueOf(code) + " : " + value.toString()));
            }
        } catch (Exception e) {
            throw new Exception(TAG + ":json mapping error " + e.getMessage());
        }
    }

    /**
     * Transform from valid json string to List of {@link UserEntity}.
     *
     * @param userListJsonResponse A json representing a collection of users.
     * @return List of {@link UserEntity}.
     * @throws JsonSyntaxException if the json string is not a valid json structure.
     */
    public List<UserEntity> transformUserEntityCollection(String userListJsonResponse)
            throws Exception {

        List<UserEntity> userEntityCollection;
        try {
            Map map = gson.fromJson(userListJsonResponse, Map.class);
            String code = (String) map.get(CodeConstants.HttpCode.CODE);
            Object value = map.get(CodeConstants.HttpCode.VALUE);

            if (CodeConstants.HttpCode.SUCCESS_CODE.equals(code)) {
                Type listOfUserEntityType = new TypeToken<List<UserEntity>>() {
                }.getType();
                userEntityCollection = gson.fromJson(gson.toJson(value), listOfUserEntityType);
            } else {
                throw new RuntimeException(new NetworkConnectionException(CodeConstants.ApiCode.ERROR + " : " + String.valueOf(code) + " : " + value.toString()));
            }
            return userEntityCollection;
        } catch (Exception e) {
            throw new Exception(TAG + ":json mapping error " + e.getMessage());
        }
    }
}
