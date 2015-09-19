package com.sitexa.android.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xnpeng on 15-9-4.
 */
public class Blog {


    private long id;
    private long communityId;
    private String communityName;
    private long groupId;
    private String groupName;
    private long creatorId;
    private String creatorName;
    private String headIcon;
    private Date createDate;
    private String contents;
    private List<String> imagePaths = new ArrayList<>();
    private String videoPath;
    private String videoCoverPath;
    private long videoSize;
    private boolean isLocalMediaPath;
    private String audioPath;
    private int pitch;
    private int readCount;
    private int likeCount;
    private int unLikeCount;
    private int forwardCount;
    private int sourcePath;
    private String userAgent;
    private List<String> imageFullPath = new ArrayList<>();
    private List<Comment> comments;
    private long commentCount;
    private boolean liked;
    private boolean isOrigial;
    private String oContents;
    private String objectType;
    private String oSource;

    public Blog(long id) {
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

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
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

    public List<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(List<String> imagePaths) {
        this.imagePaths = imagePaths;
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

    public boolean isLocalMediaPath() {
        return isLocalMediaPath;
    }

    public void setIsLocalMediaPath(boolean isLocalMediaPath) {
        this.isLocalMediaPath = isLocalMediaPath;
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

    public int getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(int sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public List<String> getImageFullPath() {
        return imageFullPath;
    }

    public void setImageFullPath(List<String> imageFullPath) {
        this.imageFullPath = imageFullPath;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public boolean isOrigial() {
        return isOrigial;
    }

    public void setIsOrigial(boolean isOrigial) {
        this.isOrigial = isOrigial;
    }

    public String getoContents() {
        return oContents;
    }

    public void setoContents(String oContents) {
        this.oContents = oContents;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getoSource() {
        return oSource;
    }

    public void setoSource(String oSource) {
        this.oSource = oSource;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", communityId=" + communityId +
                ", communityName='" + communityName + '\'' +
                ", groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", creatorId=" + creatorId +
                ", creatorName='" + creatorName + '\'' +
                ", headIcon='" + headIcon + '\'' +
                ", createDate=" + createDate +
                ", contents='" + contents + '\'' +
                ", imagePaths=" + imagePaths +
                ", videoPath='" + videoPath + '\'' +
                ", videoCoverPath='" + videoCoverPath + '\'' +
                ", videoSize=" + videoSize +
                ", isLocalMediaPath=" + isLocalMediaPath +
                ", audioPath='" + audioPath + '\'' +
                ", pitch=" + pitch +
                ", readCount=" + readCount +
                ", likeCount=" + likeCount +
                ", unLikeCount=" + unLikeCount +
                ", forwardCount=" + forwardCount +
                ", sourcePath=" + sourcePath +
                ", userAgent='" + userAgent + '\'' +
                ", imageFullPath=" + imageFullPath +
                ", comments=" + comments +
                ", commentCount=" + commentCount +
                ", liked=" + liked +
                ", isOrigial=" + isOrigial +
                ", oContents='" + oContents + '\'' +
                ", objectType='" + objectType + '\'' +
                ", oSource='" + oSource + '\'' +
                '}';
    }
}
