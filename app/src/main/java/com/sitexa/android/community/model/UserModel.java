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
package com.sitexa.android.community.model;

import java.util.Date;

/**
 * Class that represents a user in the presentation layer.
 */
public class UserModel {

    private final long userId;
    private String Username;
    private String Password;
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
    private long CommunityID;
    private String CommunityName;
    private String Gender;
    private Date Birthday;
    private Date RegisterDate;
    private String QRCode;
    private String QRCodePath;
    private String HeadIcon;
    private boolean AuditFlag;
    private boolean DeleteFlag;
    private String EncryptKey;
    private String EncryptedLoginStr;
    private String IMEI;
    private String Role;


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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
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

    public long getCommunityID() {
        return CommunityID;
    }

    public void setCommunityID(long communityID) {
        CommunityID = communityID;
    }

    public String getCommunityName() {
        return CommunityName;
    }

    public void setCommunityName(String communityName) {
        CommunityName = communityName;
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

    public String getEncryptKey() {
        return EncryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        EncryptKey = encryptKey;
    }

    public String getEncryptedLoginStr() {
        return EncryptedLoginStr;
    }

    public void setEncryptedLoginStr(String encryptedLoginStr) {
        EncryptedLoginStr = encryptedLoginStr;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
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
                ", CommunityID=" + CommunityID +
                ", CommunityName='" + CommunityName + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Birthday='" + Birthday + '\'' +
                ", RegisterDate='" + RegisterDate + '\'' +
                ", QRCode='" + QRCode + '\'' +
                ", QRCodePath='" + QRCodePath + '\'' +
                ", HeadIcon='" + HeadIcon + '\'' +
                ", AuditFlag=" + AuditFlag +
                ", DeleteFlag=" + DeleteFlag +
                ", EncryptKey='" + EncryptKey + '\'' +
                ", EncryptedLoginStr='" + EncryptedLoginStr + '\'' +
                ", IMEI='" + IMEI + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
}
