package com.xianlaifeng.join.entity;

import java.util.Date;

public class XLF_Join {

    private int id;
    private int methodId;
    private int actId;
    private int userId;
    private Date joinTime;
    private int joinStatus;
    private int ifNotice;

    public XLF_Join(int id, int methodId, int actId, int userId, Date joinTime, int joinStatus) {
        this.id = id;
        this.methodId = methodId;
        this.actId = actId;
        this.userId = userId;
        this.joinTime = joinTime;
        this.joinStatus = joinStatus;
    }


    public XLF_Join() {
    }

    public int getIfNotice() {
        return ifNotice;
    }

    public void setIfNotice(int ifNotice) {
        this.ifNotice = ifNotice;
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

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public int getJoinStatus() {
        return joinStatus;
    }

    public void setJoinStatus(int joinStatus) {
        this.joinStatus = joinStatus;
    }

    @Override
    public String toString() {
        return "XLF_Join{" +
                "id=" + id +
                ", methodId=" + methodId +
                ", actId=" + actId +
                ", userId=" + userId +
                ", joinTime=" + joinTime +
                ", joinStatus=" + joinStatus +
                '}';
    }
}
