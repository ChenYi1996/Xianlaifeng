package com.xianlaifeng.act.entity;

import java.util.Date;

public class XLF_Join_Act {


    private int id;
    private int actId;
    private int userId;
    private Date joinTime;
    private int joinStatus;

    public XLF_Join_Act(int id, int actId, int userId, Date joinTime, int joinStatus) {
        this.id = id;
        this.actId = actId;
        this.userId = userId;
        this.joinTime = joinTime;
        this.joinStatus = joinStatus;
    }

    public XLF_Join_Act() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
