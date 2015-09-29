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
public class Post {
    private long id;
    private long communityId;
    private String communityName;
    private String siteId;
    private long creatorId;
    private String creatorName;
    private Date createDate;
    private String contents;
    private List<String> imagePath = new ArrayList<>();
    private String videoPath;
    private String videoCoverPath;
    private long videoSize;
    private int pitch;
    private String audioPath;
    private int sourceURL;
    private int readCount;
    private int likeCount;
    private int unLikeCount;
    private int forwardCount;
    private String userAgent;

    public Post(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
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

    public int getPitch() {
        return pitch;
    }

    public void setPitch(int pitch) {
        this.pitch = pitch;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public int getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(int sourceURL) {
        this.sourceURL = sourceURL;
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

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", communityId=" + communityId +
                ", communityName='" + communityName + '\'' +
                ", siteId='" + siteId + '\'' +
                ", creatorId=" + creatorId +
                ", creatorName='" + creatorName + '\'' +
                ", createDate=" + createDate +
                ", contents='" + contents + '\'' +
                ", imagePath=" + imagePath +
                ", videoPath='" + videoPath + '\'' +
                ", videoCoverPath='" + videoCoverPath + '\'' +
                ", videoSize=" + videoSize +
                ", pitch=" + pitch +
                ", audioPath='" + audioPath + '\'' +
                ", sourceURL=" + sourceURL +
                ", readCount=" + readCount +
                ", likeCount=" + likeCount +
                ", unLikeCount=" + unLikeCount +
                ", forwardCount=" + forwardCount +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }
}
