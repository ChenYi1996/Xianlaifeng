package com.xianlaifeng.ptj.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 兼职信息表
 */
public class XlfPartTimeJob {

    private int jobId;
    private String jobName;
    private int limitNumber;
    private String jobType;
    private BigDecimal wage;
    private String calculateMoneyType;
    private String calculateMoneyDate;
    private String workStreet;
    private Date releaseTime;
    private String workDate;
    private String workTime;
    private String jobContent;
    private String auditStatus;
    private int userId;
    private String delFlag;
    private int areaId;

    public XlfPartTimeJob() {
    }

    public XlfPartTimeJob(int jobId, String jobName, int limitNumber, String jobType, BigDecimal wage, String calculateMoneyType, String calculateMoneyDate, String workStreet, Date releaseTime, String workDate, String workTime, String jobContent, String auditStatus, int userId, String delFlag) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.limitNumber = limitNumber;
        this.jobType = jobType;
        this.wage = wage;
        this.calculateMoneyType = calculateMoneyType;
        this.calculateMoneyDate = calculateMoneyDate;
        this.workStreet = workStreet;
        this.releaseTime = releaseTime;
        this.workDate = workDate;
        this.workTime = workTime;
        this.jobContent = jobContent;
        this.auditStatus = auditStatus;
        this.userId = userId;
        this.delFlag = delFlag;
    }

    public XlfPartTimeJob(int jobId, String jobName, int limitNumber, String jobType, BigDecimal wage, String calculateMoneyType, String calculateMoneyDate, String workStreet, Date releaseTime, String workDate, String workTime, String jobContent, String auditStatus, int userId, String delFlag, int areaId) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.limitNumber = limitNumber;
        this.jobType = jobType;
        this.wage = wage;
        this.calculateMoneyType = calculateMoneyType;
        this.calculateMoneyDate = calculateMoneyDate;
        this.workStreet = workStreet;
        this.releaseTime = releaseTime;
        this.workDate = workDate;
        this.workTime = workTime;
        this.jobContent = jobContent;
        this.auditStatus = auditStatus;
        this.userId = userId;
        this.delFlag = delFlag;
        this.areaId = areaId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setLimitNumber(int limitNumber) {
        this.limitNumber = limitNumber;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setWage(BigDecimal wage) {
        this.wage = wage;
    }

    public void setCalculateMoneyType(String calculateMoneyType) {
        this.calculateMoneyType = calculateMoneyType;
    }

    public void setCalculateMoneyDate(String calculateMoneyDate) {
        this.calculateMoneyDate = calculateMoneyDate;
    }

    public void setWorkStreet(String workStreet) {
        this.workStreet = workStreet;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getAreaId() {
        return areaId;
    }

    public int getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public int getLimitNumber() {
        return limitNumber;
    }

    public String getJobType() {
        return jobType;
    }

    public BigDecimal getWage() {
        return wage;
    }

    public String getCalculateMoneyType() {
        return calculateMoneyType;
    }

    public String getCalculateMoneyDate() {
        return calculateMoneyDate;
    }

    public String getWorkStreet() {
        return workStreet;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public String getWorkDate() {
        return workDate;
    }

    public String getWorkTime() {
        return workTime;
    }

    public String getJobContent() {
        return jobContent;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public int getUserId() {
        return userId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return "XlfPartTimeJob{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", limitNumber=" + limitNumber +
                ", jobType='" + jobType + '\'' +
                ", wage=" + wage +
                ", calculateMoneyType='" + calculateMoneyType + '\'' +
                ", calculateMoneyDate='" + calculateMoneyDate + '\'' +
                ", workStreet='" + workStreet + '\'' +
                ", releaseTime=" + releaseTime +
                ", workDate='" + workDate + '\'' +
                ", workTime='" + workTime + '\'' +
                ", jobContent='" + jobContent + '\'' +
                ", auditStatus='" + auditStatus + '\'' +
                ", userId=" + userId +
                ", delFlag='" + delFlag + '\'' +
                ", areaId=" + areaId +
                '}';
    }
}
