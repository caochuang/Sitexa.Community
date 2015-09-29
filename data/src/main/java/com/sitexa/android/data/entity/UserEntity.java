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
package com.sitexa.android.data.entity;

import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;
import java.util.Date;

/**
 * User Entity used in the data layer.
 */
public class UserEntity {

    @SerializedName("userid")
    private long userId;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("coverimagepath")
    private String coverImagePath;

    @SerializedName("signature")
    private String signature;

    @SerializedName("status")
    private String status;

    @SerializedName("mobileno")
    private String mobileNo;

    @SerializedName("email")
    private String email;

    @SerializedName("qqno")
    private String qqno;

    @SerializedName("weixinno")
    private String weixinNo;

    @SerializedName("weibono")
    private String weiboNo;

    @SerializedName("siteid")
    private String siteId;

    @SerializedName("sitename")
    private String sitename;

    @SerializedName("communityid")
    private long communityId;

    @SerializedName("communityname")
    private String communityName;

    @SerializedName("gender")
    private String gender;

    @SerializedName("birthday")
    private Date birthday;

    @SerializedName("registerdate")
    private Timestamp registerDate;

    @SerializedName("qrcode")
    private String qrcode;

    @SerializedName("qrcodepath")
    private String qrcodePath;

    @SerializedName("headicon")
    private String headIcon;

    @SerializedName("auditflag")
    private boolean auditFlag;

    @SerializedName("deleteflag")
    private boolean deleteFlag;

    @SerializedName("encryptkey")
    private String encryptKey;

    @SerializedName("encryptedloginstr")
    private String encryptedLoginStr;

    @SerializedName("imei")
    private String imei;

    @SerializedName("role")
    private String role;

    public UserEntity() {
        //empty
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCoverImagePath() {
        return coverImagePath;
    }

    public void setCoverImagePath(String coverImagePath) {
        this.coverImagePath = coverImagePath;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQqno() {
        return qqno;
    }

    public void setQqno(String qqno) {
        this.qqno = qqno;
    }

    public String getWeixinNo() {
        return weixinNo;
    }

    public void setWeixinNo(String weixinNo) {
        this.weixinNo = weixinNo;
    }

    public String getWeiboNo() {
        return weiboNo;
    }

    public void setWeiboNo(String weiboNo) {
        this.weiboNo = weiboNo;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(long communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getQrcodePath() {
        return qrcodePath;
    }

    public void setQrcodePath(String qrcodePath) {
        this.qrcodePath = qrcodePath;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public boolean isAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(boolean auditFlag) {
        this.auditFlag = auditFlag;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public String getEncryptedLoginStr() {
        return encryptedLoginStr;
    }

    public void setEncryptedLoginStr(String encryptedLoginStr) {
        this.encryptedLoginStr = encryptedLoginStr;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", coverImagePath='" + coverImagePath + '\'' +
                ", signature='" + signature + '\'' +
                ", status='" + status + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", email='" + email + '\'' +
                ", qqno='" + qqno + '\'' +
                ", weixinNo='" + weixinNo + '\'' +
                ", weiboNo='" + weiboNo + '\'' +
                ", siteId='" + siteId + '\'' +
                ", sitename='" + sitename + '\'' +
                ", communityId=" + communityId +
                ", communityName='" + communityName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", registerDate=" + registerDate +
                ", qrcode='" + qrcode + '\'' +
                ", qrcodePath='" + qrcodePath + '\'' +
                ", headIcon='" + headIcon + '\'' +
                ", auditFlag=" + auditFlag +
                ", deleteFlag=" + deleteFlag +
                ", encryptKey='" + encryptKey + '\'' +
                ", encryptedLoginStr='" + encryptedLoginStr + '\'' +
                ", imei='" + imei + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
