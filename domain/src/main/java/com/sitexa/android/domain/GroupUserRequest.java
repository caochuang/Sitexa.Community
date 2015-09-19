package com.sitexa.android.domain;

import java.util.Date;

/**
 * Created by xnpeng on 15-9-4.
 */
public class GroupUserRequest {
    private long id;
    private long groupId;
    private long requestId;
    private String message;
    private Date requestDate;

    public GroupUserRequest(long id) {
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

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public String toString() {
        return "GroupRequest{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", requestId=" + requestId +
                ", message='" + message + '\'' +
                ", requestDate=" + requestDate +
                '}';
    }
}
