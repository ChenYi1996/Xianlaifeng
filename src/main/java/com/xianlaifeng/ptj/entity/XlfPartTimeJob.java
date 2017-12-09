package com.xianlaifeng.ptj.entity;

import com.xianlaifeng.sys.entity.XlfArea;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 兼职信息表
 */
public class XlfPartTimeJob {

    private int jobId;
    private String jobName;
    private int limitNumber;
    private int jobTypeId;
    private BigDecimal wage;
    private String wageType;
    private String calculateMoneyType;
    private String calculateMoneyDate;
    private String workStreet;
    private Date releaseTime;
    private Date startWorkDate;
    private Date endWorkDate;
    private String jobContent;
    private String auditStatus;
    private int userId;
    private String delFlag;
    private int areaId;
    private String timeType;
    private String sexDemand;
    private String workTime;

    private List<Integer> areaIds;
    private List<Integer> jobTypeIds;
    private List<String> timeTypes;

    public String getWorkTime() {
        return workTime;
    }

    public List<String> getTimeTypes() {
        return timeTypes;
    }

    public List<Integer> getJobTypeIds() {
        return jobTypeIds;
    }

    public List<Integer> getAreaIds() {
        return areaIds;
    }

    public int getJobId() {
        return jobId;
    }

    public String getWageType() {
        return wageType;
    }

    public String getJobName() {
        return jobName;
    }

    public int getLimitNumber() {
        return limitNumber;
    }

    public int getJobTypeId() {
        return jobTypeId;
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

    public Date getStartWorkDate() {
        return startWorkDate;
    }

    public Date getEndWorkDate() {
        return endWorkDate;
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

    public int getAreaId() {
        return areaId;
    }

    public String getTimeType() {
        return timeType;
    }

    public String getSexDemand() {
        return sexDemand;
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

    public void setJobTypeId(int jobTypeId) {
        this.jobTypeId = jobTypeId;
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

    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public void setEndWorkDate(Date endWorkDate) {
        this.endWorkDate = endWorkDate;
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

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public void setSexDemand(String sexDemand) {
        this.sexDemand = sexDemand;
    }


    public void setWageType(String wageType) {
        this.wageType = wageType;
    }

    public void setAreaIds(List<Integer> areaIds) {
        this.areaIds = areaIds;
    }

    public void setJobTypeIds(List<Integer> jobTypes) {
        this.jobTypeIds = jobTypes;
    }

    public void setTimeTypes(List<String> timeTypes) {
        this.timeTypes = timeTypes;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }
}
