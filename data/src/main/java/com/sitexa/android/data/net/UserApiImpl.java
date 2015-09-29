package com.sitexa.android.data.net;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sitexa.android.data.constant.ApplicationConstants;
import com.sitexa.android.data.entity.UserEntity;
import com.sitexa.android.data.exception.RepositoryErrorBundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by xnpeng on 15-9-16.
 */
public class UserApiImpl implements UserApi {

    private final String TAG = UserApiImpl.class.getSimpleName();
    private Context context;
    private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public UserApiImpl(Context context) {
        this.context = context;
        if (context == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
    }

    @Override
    public Observable<List<UserEntity>> userEntityList() {
        Map<String, String> params = new HashMap<>();
        params.put("pageNumber", "0");
        params.put("pageSize", "20");
        return Observable.create(subscriber -> {
            try {
                String result = OkHttpApi.newInstance(this.context)
                        .getRequest(UserApi.API_URL_GET_USER_LIST, params)
                        .call();
                ApiResult apiResult = new ApiResult();
                apiResult.setValue(result);
                List<UserEntity> entities = apiResult.getDomainList(new TypeToken<List<UserEntity>>() {
                }.getType());
                entities = reformImageUrl(entities);
                subscriber.onNext(entities);
                subscriber.onCompleted();
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });

    }

    @Override
    public Observable<UserEntity> userEntityById(final long userId) {
        Map<String, String> params = new HashMap<>();
        params.put("userId", String.valueOf(userId));
        return Observable.create(subscriber -> {
            try {
                String result = OkHttpApi.newInstance(this.context)
                        .getRequest(UserApi.API_URL_GET_USER_DETAILS, params)
                        .call();
                ApiResult apiResult = new ApiResult();
                apiResult.setValue(result);
                UserEntity entity = apiResult.getDomain(UserEntity.class);
                entity = reformImageUrl(entity);
                subscriber.onNext(entity);
                subscriber.onCompleted();
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });
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
