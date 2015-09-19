package com.sitexa.android.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by xnpeng on 15-9-4.
 */
public class Group {
    private long groupId;
    private String groupName;
    private long communityId;
    private String communityName;
    private String headIcon;
    private String introduction;
    private long creatorId;
    private Date createDate;
    private String status;
    private boolean publicFlag;
    private boolean joinFlag;
    private String groupFlag;
    private double activityIndex;
    private int indexVersion;

    public Group(long groupId) {
        this.groupId = groupId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPublicFlag() {
        return publicFlag;
    }

    public void setPublicFlag(boolean publicFlag) {
        this.publicFlag = publicFlag;
    }

    public boolean isJoinFlag() {
        return joinFlag;
    }

    public void setJoinFlag(boolean joinFlag) {
        this.joinFlag = joinFlag;
    }

    public String getGroupFlag() {
        return groupFlag;
    }

    public void setGroupFlag(String groupFlag) {
        this.groupFlag = groupFlag;
    }

    public double getActivityIndex() {
        return activityIndex;
    }

    public void setActivityIndex(double activityIndex) {
        this.activityIndex = activityIndex;
    }

    public int getIndexVersion() {
        return indexVersion;
    }

    public void setIndexVersion(int indexVersion) {
        this.indexVersion = indexVersion;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", communityId=" + communityId +
                ", communityName='" + communityName + '\'' +
                ", headIcon='" + headIcon + '\'' +
                ", introduction='" + introduction + '\'' +
                ", creatorId=" + creatorId +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                ", publicFlag=" + publicFlag +
                ", joinFlag=" + joinFlag +
                ", groupFlag='" + groupFlag + '\'' +
                ", activityIndex=" + activityIndex +
                ", indexVersion=" + indexVersion +
                '}';
    }
}
