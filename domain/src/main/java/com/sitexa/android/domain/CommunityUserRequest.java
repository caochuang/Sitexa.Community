package com.sitexa.android.domain;

import java.util.Date;

/**
 * Created by xnpeng on 15-9-4.
 */
public class CommunityUserRequest {

    private long id;
    private long requestUserID;
    private long communityID;
    private String message;
    private Date createDate;
    private String status;

    public CommunityUserRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRequestUserID() {
        return requestUserID;
    }

    public void setRequestUserID(long requestUserID) {
        this.requestUserID = requestUserID;
    }

    public long getCommunityID() {
        return communityID;
    }

    public void setCommunityID(long communityID) {
        this.communityID = communityID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    @Override
    public String toString() {
        return "CommunityUserRequest{" +
                "id=" + id +
                ", requestUserID=" + requestUserID +
                ", communityID=" + communityID +
                ", message='" + message + '\'' +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                '}';
    }
}
