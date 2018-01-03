package org.bryanzzz.entity;

import java.util.Date;

public class tag {

    private long tagId;

    private String tagName;

    private User user;

    private Date createdAt;

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "tag{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", user=" + user +
                ", createdAt=" + createdAt +
                '}';
    }
}
