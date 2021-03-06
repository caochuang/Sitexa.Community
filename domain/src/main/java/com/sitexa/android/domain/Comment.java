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

import java.util.Date;

/**
 * Created by xnpeng on 15-9-4.
 */
public class Comment {

    private long id;
    private String objectType;
    private String objectId;
    private String contents;
    private long creatorId;
    private String creatorName;
    private long toUserId;
    private String toUserName;
    private Date createDate;
    private String remark;
    private int commentIndex;

    public Comment(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
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

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getCommentIndex() {
        return commentIndex;
    }

    public void setCommentIndex(int commentIndex) {
        this.commentIndex = commentIndex;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", objectType='" + objectType + '\'' +
                ", objectId='" + objectId + '\'' +
                ", contents='" + contents + '\'' +
                ", creatorId=" + creatorId +
                ", creatorName='" + creatorName + '\'' +
                ", toUserId=" + toUserId +
                ", toUserName='" + toUserName + '\'' +
                ", createDate=" + createDate +
                ", remark='" + remark + '\'' +
                ", commentIndex=" + commentIndex +
                '}';
    }
}
