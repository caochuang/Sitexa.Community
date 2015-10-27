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

package com.sitexa.android.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by xnpeng on 15-9-4.
 */
public class Community {
    private long communityid;
    private String communityname;
    private String siteid;
    private String sitename;
    private String introduction;
    private String headicon;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String mapflashpath;
    private String qrcode;
    private String qrcodepath;
    private String committee;
    private String propertymanagement;
    private Date createdate;
    private long creatorid;
    private boolean checked;
    private String creatorName;
    private String auditflag;
    private boolean deleteflag;

    public Community() {
    }

    public Community(long communityid) {
        this.communityid = communityid;
    }

    public long getCommunityid() {
        return communityid;
    }

    public void setCommunityid(long communityid) {
        this.communityid = communityid;
    }

    public String getCommunityname() {
        return communityname;
    }

    public void setCommunityname(String communityname) {
        this.communityname = communityname;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getHeadicon() {
        return headicon;
    }

    public void setHeadicon(String headicon) {
        this.headicon = headicon;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getMapflashpath() {
        return mapflashpath;
    }

    public void setMapflashpath(String mapflashpath) {
        this.mapflashpath = mapflashpath;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getQrcodepath() {
        return qrcodepath;
    }

    public void setQrcodepath(String qrcodepath) {
        this.qrcodepath = qrcodepath;
    }

    public String getCommittee() {
        return committee;
    }

    public void setCommittee(String committee) {
        this.committee = committee;
    }

    public String getPropertymanagement() {
        return propertymanagement;
    }

    public void setPropertymanagement(String propertymanagement) {
        this.propertymanagement = propertymanagement;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public long getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(long creatorid) {
        this.creatorid = creatorid;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getAuditflag() {
        return auditflag;
    }

    public void setAuditflag(String auditflag) {
        this.auditflag = auditflag;
    }

    public boolean isDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(boolean deleteflag) {
        this.deleteflag = deleteflag;
    }

    @Override
    public String toString() {
        return "Community{" +
                "communityid=" + communityid +
                ", communityname='" + communityname + '\'' +
                ", siteid='" + siteid + '\'' +
                ", sitename='" + sitename + '\'' +
                ", introduction='" + introduction + '\'' +
                ", headicon='" + headicon + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", mapflashpath='" + mapflashpath + '\'' +
                ", qrcode='" + qrcode + '\'' +
                ", qrcodepath='" + qrcodepath + '\'' +
                ", committee='" + committee + '\'' +
                ", propertymanagement='" + propertymanagement + '\'' +
                ", createdate=" + createdate +
                ", creatorid=" + creatorid +
                ", checked=" + checked +
                ", creatorName='" + creatorName + '\'' +
                ", auditflag='" + auditflag + '\'' +
                ", deleteflag=" + deleteflag +
                '}';
    }
}
