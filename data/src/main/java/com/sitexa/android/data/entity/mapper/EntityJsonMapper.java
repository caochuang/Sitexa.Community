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

package com.sitexa.android.data.entity.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by xnpeng on 15-9-5.
 * Generic Json Mapper
 */
public class EntityJsonMapper {

    private final Gson gson;

    @Inject
    public EntityJsonMapper() {
        this.gson = new Gson();
    }

    public <T> T transformEntity(String jsonResponse) {
        try {
            Type entityType = new TypeToken<T>() {
            }.getType();
            T entity = this.gson.fromJson(jsonResponse, entityType);
            return entity;
        } catch (JsonSyntaxException jsonException) {
            throw jsonException;
        }
    }

    public <T> List<T> transformEntityCollection(String listJsonResponse) throws JsonSyntaxException {

        List<T> entityCollection;
        try {
            Type listOfEntityType = new TypeToken<List<T>>() {
            }.getType();
            entityCollection = this.gson.fromJson(listJsonResponse, listOfEntityType);
            return entityCollection;
        } catch (JsonSyntaxException jsonException) {
            throw jsonException;
        }
    }
}
