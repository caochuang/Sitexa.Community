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
package com.sitexa.android.community.model;

import java.util.Date;
import java.util.List;

/**
 * Class that represents a user in the presentation layer.
 */
public class UserModel {

    private final long userId;
    private String Username;
    private String CoverImagePath;
    private String Signature;
    private String Status;
    private String MobileNo;
    private String Email;
    private String QQNo;
    private String WeixinNo;
    private String WeiboNo;
    private String SiteID;
    private String SiteName;
    private String Gender;
    private Date Birthday;
    private Date RegisterDate;
    private String QRCode;
    private String QRCodePath;
    private String HeadIcon;
    private boolean AuditFlag;
    private boolean DeleteFlag;
    private String Role;
    private SiteModel site;
    private CommunityModel mainCommunity;
    private List<CommunityModel> communities;

    public UserModel(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getCoverImagePath() {
        return CoverImagePath;
    }

    public void setCoverImagePath(String coverImagePath) {
        CoverImagePath = coverImagePath;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getQQNo() {
        return QQNo;
    }

    public void setQQNo(String QQNo) {
        this.QQNo = QQNo;
    }

    public String getWeixinNo() {
        return WeixinNo;
    }

    public void setWeixinNo(String weixinNo) {
        WeixinNo = weixinNo;
    }

    public String getWeiboNo() {
        return WeiboNo;
    }

    public void setWeiboNo(String weiboNo) {
        WeiboNo = weiboNo;
    }

    public String getSiteID() {
        return SiteID;
    }

    public void setSiteID(String siteID) {
        SiteID = siteID;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public Date getRegisterDate() {
        return RegisterDate;
    }

    public void setRegisterDate(Date registerDate) {
        RegisterDate = registerDate;
    }

    public String getQRCode() {
        return QRCode;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }

    public String getQRCodePath() {
        return QRCodePath;
    }

    public void setQRCodePath(String QRCodePath) {
        this.QRCodePath = QRCodePath;
    }

    public String getHeadIcon() {
        return HeadIcon;
    }

    public void setHeadIcon(String headIcon) {
        HeadIcon = headIcon;
    }

    public boolean isAuditFlag() {
        return AuditFlag;
    }

    public void setAuditFlag(boolean auditFlag) {
        AuditFlag = auditFlag;
    }

    public boolean isDeleteFlag() {
        return DeleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        DeleteFlag = deleteFlag;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public SiteModel getSite() {
        return site;
    }

    public void setSite(SiteModel site) {
        this.site = site;
    }

    public List<CommunityModel> getCommunities() {
        return communities;
    }

    public void setCommunities(List<CommunityModel> communities) {
        this.communities = communities;
    }

    public CommunityModel getMainCommunity() {
        return mainCommunity;
    }

    public void setMainCommunity(CommunityModel mainCommunity) {
        this.mainCommunity = mainCommunity;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", Username='" + Username + '\'' +
                ", CoverImagePath='" + CoverImagePath + '\'' +
                ", Signature='" + Signature + '\'' +
                ", Status='" + Status + '\'' +
                ", MobileNo='" + MobileNo + '\'' +
                ", Email='" + Email + '\'' +
                ", QQNo='" + QQNo + '\'' +
                ", WeixinNo='" + WeixinNo + '\'' +
                ", WeiboNo='" + WeiboNo + '\'' +
                ", SiteID='" + SiteID + '\'' +
                ", SiteName='" + SiteName + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Birthday='" + Birthday + '\'' +
                ", RegisterDate='" + RegisterDate + '\'' +
                ", QRCode='" + QRCode + '\'' +
                ", QRCodePath='" + QRCodePath + '\'' +
                ", HeadIcon='" + HeadIcon + '\'' +
                ", AuditFlag=" + AuditFlag +
                ", DeleteFlag=" + DeleteFlag +
                ", Role='" + Role + '\'' +
                '}';
    }
}
