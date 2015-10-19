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
package com.sitexa.android.data.repository;

import android.util.Log;

import com.sitexa.android.data.entity.mapper.UserEntityDataMapper;
import com.sitexa.android.data.repository.datasource.UserDataStore;
import com.sitexa.android.data.repository.datasource.UserDataStoreFactory;
import com.sitexa.android.domain.User;
import com.sitexa.android.domain.repository.UserRepository;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * {@link UserRepository} for retrieving user data.
 */
@Singleton
public class UserDataRepository implements UserRepository {

    private final static String TAG = UserDataRepository.class.getSimpleName();
    private final UserDataStoreFactory userDataStoreFactory;
    private final UserEntityDataMapper userEntityDataMapper;

    /**
     * Constructs a {@link UserRepository}.
     *
     * @param dataStoreFactory A factory to construct different data source implementations.
     * @param userEntityDataMapper {@link UserEntityDataMapper}.
     */
    @Inject
    public UserDataRepository(UserDataStoreFactory dataStoreFactory,
                              UserEntityDataMapper userEntityDataMapper) {
        this.userDataStoreFactory = dataStoreFactory;
        this.userEntityDataMapper = userEntityDataMapper;
    }

    @SuppressWarnings("Convert2MethodRef")
    @Override
    public Observable<List<User>> users() {
        //we always get all users from the cloud
        final UserDataStore userDataStore = this.userDataStoreFactory.createCloudDataStore();
        return userDataStore.userEntityList()
                .map(userEntities -> this.userEntityDataMapper.transform(userEntities));
    }

    @SuppressWarnings("Convert2MethodRef")
    @Override
    public Observable<User> user(long userId) {
        final UserDataStore userDataStore = this.userDataStoreFactory.create(userId);
        return userDataStore.userEntityDetails(userId)
                .map(userEntity -> this.userEntityDataMapper.transform(userEntity));
    }

    @SuppressWarnings("Convert2MethodRef")
    @Override
    public Observable<User> userLogin(Map<String, String> fields) {
        final UserDataStore userDataStore = this.userDataStoreFactory.createCloudDataStore();
        return userDataStore.userLogin(fields)
                .map(entity -> this.userEntityDataMapper.transform(entity));
    }

    @Override
    public Observable<String> getVerifyCode(Map<String, String> param) {
        Observable<String> myObservable = Observable.just("00000");
        return myObservable;

        //final UserDataStore userDataStore = this.userDataStoreFactory.createCloudDataStore();
        //return userDataStore.getVerifyCode(param);
    }

    @Override
    public Observable<String> sendVerifyCode(Map<String, String> param) {
        Observable<String> myObservable = Observable.just("true");
        return myObservable;
        //final UserDataStore userDataStore = this.userDataStoreFactory.createCloudDataStore();
        //return userDataStore.sendVerifyCode(fields);
    }

    @Override
    public Observable<String> setPassword(Map<String, String> param) {
        Observable<String> myObservable = Observable.just("true");
        return myObservable;
        //final UserDataStore userDataStore = this.userDataStoreFactory.createCloudDataStore();
        //return userDataStore.setPassword(fields);
    }

    @Override
    public Observable<String> registerUser(Map<String, String> param) {
        Observable<String> myObservable = Observable.just("true");
        return myObservable;
        //final UserDataStore userDataStore = this.userDataStoreFactory.createCloudDataStore();
        //return userDataStore.registerUser(fields);
    }
}
