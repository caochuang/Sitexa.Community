package com.sitexa.android.data.cache.serializer;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by xnpeng on 15-9-6.
 * 写一个通用类，用来对json和entity进行序列化和反系列化.
 */
@Singleton
public class EntityJsonSerializer {

    static Class<?> instance = null;

    private final Gson gson = new Gson();

    @Inject
    public EntityJsonSerializer() {
    }

    public <T> String serialize(T entity) {
        String jsonString = gson.toJson(entity, entity.getClass());
        return jsonString;
    }

    //如何获取运行时泛型的class?
    public <T> T deserialize(String jsonString) {
        instance = (Class<T>) new Object();
        T entity = (T) gson.fromJson(jsonString, instance.getClass());
        return entity;
    }

}
