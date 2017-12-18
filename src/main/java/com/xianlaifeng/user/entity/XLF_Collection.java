package com.xianlaifeng.user.entity;

import java.util.Date;

public class XLF_Collection {
    private int id;
    private int methodId;
    private int actId;
    private int userId;
    private Date collectionTime;

    public XLF_Collection() {
    }

    public XLF_Collection(int methodId, int actId, int userId) {
        this.methodId = methodId;
        this.actId = actId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMethodId() {
        return methodId;
    }

    public void setMethodId(int methodId) {
        this.methodId = methodId;
    }

    public int getActId() {
        return actId;
    }

    public void setActId(int actId) {
        this.actId = actId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }

    @Override
    public String toString() {
        return "XLF_Collection{" +
                "id=" + id +
                ", methodId=" + methodId +
                ", actId=" + actId +
                ", userId=" + userId +
                ", collectionTime=" + collectionTime +
                '}';
    }
}
