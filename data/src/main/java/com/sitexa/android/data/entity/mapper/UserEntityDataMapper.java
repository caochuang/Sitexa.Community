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

import com.sitexa.android.data.entity.UserEntity;
import com.sitexa.android.domain.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link UserEntity} (in the data layer) to {@link User} in the
 * domain layer.
 */
@Singleton
public class UserEntityDataMapper {

    @Inject
    public UserEntityDataMapper() {
    }

    /**
     * Transform a {@link UserEntity} into an {@link User}.
     *
     * @param entity Object to be transformed.
     * @return {@link User} if valid {@link UserEntity} otherwise null.
     */
    public User transform(UserEntity entity) {
        User user = null;
        if (entity != null) {
            user = new User(entity.getId());
            user.setUserName(entity.getUsername());
            user.setAuditFlag(entity.isAuditFlag());
            user.setBirthday(entity.getBirthday());
            user.setCoverImagePath(entity.getCoverImagePath());
            user.setDeleteFlag(entity.isDeleteFlag());
            user.setEmail(entity.getEmail());
            user.setEncryptedLoginStr(entity.getEncryptedLoginStr());
            user.setGender(entity.getGender());
            user.setMobileNo(entity.getMobileNo());
            user.setQqno(entity.getQqno());
            user.setQrcode(entity.getQrcode());
            user.setQrcodePath(entity.getQrcodePath());
            user.setRegisterDate(entity.getRegisterDate());
            user.setRole(entity.getRole());
            user.setSignature(entity.getSignature());
            user.setSiteId(entity.getSiteId());
            user.setStatus(entity.getStatus());
            user.setWeiboNo(entity.getWeiboNo());
            user.setWeixinNo(entity.getWeixinNo());
            user.setCommunityId(entity.getCommunityId());
            user.setCommunityName(entity.getCommunityName());
        }
        return user;
    }

    /**
     * Transform a List of {@link UserEntity} into a Collection of {@link User}.
     *
     * @param userEntityCollection Object Collection to be transformed.
     * @return {@link User} if valid {@link UserEntity} otherwise null.
     */
    public List<User> transform(Collection<UserEntity> userEntityCollection) {
        List<User> userList = new ArrayList<>(20);
        User user;
        for (UserEntity userEntity : userEntityCollection) {
            user = transform(userEntity);
            if (user != null) {
                userList.add(user);
            }
        }

        return userList;
    }
}
