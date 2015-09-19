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
package com.sitexa.android.community.mapper;

import com.sitexa.android.domain.User;
import com.sitexa.android.community.internal.di.PerActivity;
import com.sitexa.android.community.model.UserModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

/**
 * Mapper class used to transform {@link User} (in the domain layer) to {@link UserModel} in the
 * presentation layer.
 */
@PerActivity
public class UserModelDataMapper {

    @Inject
    public UserModelDataMapper() {
    }

    /**
     * Transform a {@link User} into an {@link UserModel}.
     *
     * @param user Object to be transformed.
     * @return {@link UserModel}.
     */
    public UserModel transform(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        UserModel userModel = new UserModel(user.getUserId());
        userModel.setAuditFlag(user.isAuditFlag());
        userModel.setBirthday(user.getBirthday());
        userModel.setCommunityID(user.getCommunityId());
        userModel.setCommunityName(user.getCommunityName());
        userModel.setCoverImagePath(user.getCoverImagePath());
        userModel.setDeleteFlag(user.isDeleteFlag());
        userModel.setEmail(user.getEmail());
        userModel.setEncryptedLoginStr(user.getEncryptedLoginStr());
        userModel.setEncryptKey(user.getEncryptKey());
        userModel.setGender(user.getGender());
        userModel.setHeadIcon(user.getHeadIcon());
        userModel.setIMEI(user.getIMEI());
        userModel.setMobileNo(user.getMobileNo());
        userModel.setPassword(user.getPassword());
        userModel.setQQNo(user.getQqno());
        userModel.setQRCode(user.getQrcode());
        userModel.setQRCodePath(user.getQrcodePath());
        userModel.setRegisterDate(user.getRegisterDate());
        userModel.setRole(user.getRole());
        userModel.setSignature(user.getSignature());
        userModel.setSiteID(user.getSiteId());
        userModel.setSiteName(user.getSiteName());
        userModel.setStatus(user.getStatus());
        userModel.setUsername(user.getUserName());
        userModel.setWeiboNo(user.getWeiboNo());
        userModel.setWeixinNo(user.getWeixinNo());
        return userModel;
    }

    /**
     * Transform a Collection of {@link User} into a Collection of {@link UserModel}.
     *
     * @param usersCollection Objects to be transformed.
     * @return List of {@link UserModel}.
     */
    public Collection<UserModel> transform(Collection<User> usersCollection) {
        Collection<UserModel> userModelsCollection;

        if (usersCollection != null && !usersCollection.isEmpty()) {
            userModelsCollection = new ArrayList<>();
            for (User user : usersCollection) {
                userModelsCollection.add(transform(user));
            }
        } else {
            userModelsCollection = Collections.emptyList();
        }

        return userModelsCollection;
    }
}
