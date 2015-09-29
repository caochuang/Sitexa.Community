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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xnpeng on 15-9-5.
 */
public class Space {
    private long id;
    private long groupId;
    private String groupName;
    private long communityId;
    private String communityName;
    private long creatorId;
    private String creatorName;
    private Date createDate;
    private String contents;
    private String oContents;
    private List<String> imagePath = new ArrayList<>();
    private String videoPath;
    private String videoCoverPath;
    private long videoSize;
    private String audioPath;
    private int pitch;
    private int readCount;
    private int likeCount;
    private int unLikeCount;
    private int forwardCount;
    private String sourceURL;
    private String userAgent;
    private boolean auditFlag;
    private boolean deleteFlag;
    private boolean topFlag;

    public Space(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getoContents() {
        return oContents;
    }

    public void setoContents(String oContents) {
        this.oContents = oContents;
    }

    public List<String> getImagePath() {
        return imagePath;
    }

    public void setImagePath(List<String> imagePath) {
        this.imagePath = imagePath;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getVideoCoverPath() {
        return videoCoverPath;
    }

    public void setVideoCoverPath(String videoCoverPath) {
        this.videoCoverPath = videoCoverPath;
    }

    public long getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(long videoSize) {
        this.videoSize = videoSize;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public int getPitch() {
        return pitch;
    }

    public void setPitch(int pitch) {
        this.pitch = pitch;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getUnLikeCount() {
        return unLikeCount;
    }

    public void setUnLikeCount(int unLikeCount) {
        this.unLikeCount = unLikeCount;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void setForwardCount(int forwardCount) {
        this.forwardCount = forwardCount;
    }

    public String getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(String sourceURL) {
        this.sourceURL = sourceURL;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
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

    public boolean isTopFlag() {
        return topFlag;
    }

    public void setTopFlag(boolean topFlag) {
        this.topFlag = topFlag;
    }

    @Override
    public String toString() {
        return "GroupSpace{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", communityId=" + communityId +
                ", communityName='" + communityName + '\'' +
                ", creatorId=" + creatorId +
                ", creatorName='" + creatorName + '\'' +
                ", createDate=" + createDate +
                ", contents='" + contents + '\'' +
                ", oContents='" + oContents + '\'' +
                ", imagePath=" + imagePath +
                ", videoPath='" + videoPath + '\'' +
                ", videoCoverPath='" + videoCoverPath + '\'' +
                ", videoSize=" + videoSize +
                ", audioPath='" + audioPath + '\'' +
                ", pitch=" + pitch +
                ", readCount=" + readCount +
                ", likeCount=" + likeCount +
                ", unLikeCount=" + unLikeCount +
                ", forwardCount=" + forwardCount +
                ", sourceURL='" + sourceURL + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", auditFlag=" + auditFlag +
                ", deleteFlag=" + deleteFlag +
                ", topFlag=" + topFlag +
                '}';
    }
}
