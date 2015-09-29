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
package com.sitexa.android.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Class that represents a User in the domain layer.
 */
public class User {

    //显示数据拼音的首字母
    private String sortletters;
    private int userId;
    private String mobileNo;
    private String userName;
    private String email;
    private String qqno;
    private String weixinNo;
    private String weiboNo;
    private String siteId;
    private String siteName;
    private long communityId;
    private String communityName;
    private long currentCommunityId;
    private String currentCommunityName;
    private String gender;
    private Date birthday;
    private Timestamp registerDate;
    private String qrcode;
    private String qrcodePath;
    private String headIcon;
    private boolean auditFlag;
    private boolean deleteFlag;
    private String EncryptKey;
    private String encryptedLoginStr;
    private String coverImagePath;
    private String signature;
    private List<Community> CommunityList;
    private String pushId;
    private String status;
    private String role;
    private String IMEI;
    private String Password;

    public User(int userId) {
        this.userId = userId;
    }

    public String getSortletters() {
        return sortletters;
    }

    public void setSortletters(String sortletters) {
        this.sortletters = sortletters;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public long getCurrentCommunityId() {
        return currentCommunityId;
    }

    public void setCurrentCommunityId(long currentCommunityId) {
        this.currentCommunityId = currentCommunityId;
    }

    public String getCurrentCommunityName() {
        return currentCommunityName;
    }

    public void setCurrentCommunityName(String currentCommunityName) {
        this.currentCommunityName = currentCommunityName;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(long communityId) {
        this.communityId = communityId;
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

    public String getEncryptedLoginStr() {
        return encryptedLoginStr;
    }

    public void setEncryptedLoginStr(String encryptedLoginStr) {
        this.encryptedLoginStr = encryptedLoginStr;
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

    public List<Community> getCommunityList() {
        return CommunityList;
    }

    public void setCommunityList(List<Community> communityList) {
        CommunityList = communityList;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEncryptKey() {
        return EncryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        EncryptKey = encryptKey;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    @Override
    public String toString() {
        return "User{" +
                "sortletters='" + sortletters + '\'' +
                ", userId=" + userId +
                ", mobileNo='" + mobileNo + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", qqno='" + qqno + '\'' +
                ", weixinNo='" + weixinNo + '\'' +
                ", weiboNo='" + weiboNo + '\'' +
                ", siteId='" + siteId + '\'' +
                ", currentCommunityId=" + currentCommunityId +
                ", currentCommunityName='" + currentCommunityName + '\'' +
                ", communityName='" + communityName + '\'' +
                ", communityId=" + communityId +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", registerDate=" + registerDate +
                ", qrcode='" + qrcode + '\'' +
                ", qrcodePath='" + qrcodePath + '\'' +
                ", headIcon='" + headIcon + '\'' +
                ", auditFlag=" + auditFlag +
                ", deleteFlag=" + deleteFlag +
                ", encryptedLoginStr='" + encryptedLoginStr + '\'' +
                ", coverImagePath='" + coverImagePath + '\'' +
                ", signature='" + signature + '\'' +
                ", CommunityList=" + CommunityList +
                ", pushId='" + pushId + '\'' +
                '}';
    }
}
