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

package com.sitexa.android.data.module.site.entity.mapper;

import com.sitexa.android.data.module.site.entity.SiteEntity;
import com.sitexa.android.domain.Site;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by xnpeng on 15-10-8.
 */
public class SiteEntityDataMapper {

    public SiteEntityDataMapper() {
    }

    public Site transform(SiteEntity entity) {
        Site domain = null;
        if (entity != null) {
            try {
                domain = new Site(entity.getSiteId());
                domain.setFullname(entity.getFullname());
                domain.setIntroduction(entity.getIntroduction());
                domain.setLatitude(entity.getLatitude());
                domain.setLongitude(entity.getLongitude());
                domain.setParentId(entity.getParentId());
                domain.setSiteName(entity.getSiteName());
                domain.setSiteType(entity.getSiteType());
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        return domain;
    }

    public List<Site> transform(Collection<SiteEntity> entityCollection) {
        List<Site> domainList = new ArrayList<>();
        Site domain;
        for (SiteEntity entity : entityCollection) {
            domain = transform(entity);
            if (domain != null) {
                domainList.add(domain);
            }
        }
        return domainList;
    }
}
