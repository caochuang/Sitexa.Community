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

package com.sitexa.android.data.module.site.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xnpeng on 15-10-8.
 */
public class SiteEntity {

    @SerializedName("siteId")
    private String siteId;
    @SerializedName("siteName")
    private String siteName;
    @SerializedName("parentId")
    private String parentId;
    @SerializedName("fullname")
    private String fullname;
    @SerializedName("siteType")
    private String siteType;
    @SerializedName("longitude")
    private Float longitude;
    @SerializedName("latitude")
    private Float latitude;
    @SerializedName("introduction")
    private String introduction;

    public SiteEntity() {
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "SiteEntity{" +
                "siteId='" + siteId + '\'' +
                ", siteName='" + siteName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", fullname='" + fullname + '\'' +
                ", siteType='" + siteType + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
