package com.xianlaifeng.act.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class XLF_Activity {

    private int id;
    private String activityName;
    private String activityDetails;
    private int activityIfSchool;
    private String activityPic;
    private String activityProvince;
    private String activityCity;
    private String activityDistrict;
    private String activityLocation;

    private double activityLatitude;
    private double activityLongitude;

    private int activityPerson;

    private Date activityStartTime;

    private Date activityCreateTime;

    private int activityCreateUser;
    private int activityStatus;


    private List<String> activityDistricts;


    public XLF_Activity(int id, String activityName, String activityDetails, int activityIfSchool, String activityPic, String activityProvince, String activityCity, String activityDistrict, String activityLocation, Double activityLatitude, Double activityLongitude, int activityPerson, Date activityStartTime, Date activityCreateTime, int activityCreateUser, int activityStatus) {
        this.id = id;
        this.activityName = activityName;
        this.activityDetails = activityDetails;
        this.activityIfSchool = activityIfSchool;
        this.activityPic = activityPic;
        this.activityProvince = activityProvince;
        this.activityCity = activityCity;
        this.activityDistrict = activityDistrict;
        this.activityLocation = activityLocation;
        this.activityLatitude = activityLatitude;
        this.activityLongitude = activityLongitude;
        this.activityPerson = activityPerson;
        this.activityStartTime = activityStartTime;
        this.activityCreateTime = activityCreateTime;
        this.activityCreateUser = activityCreateUser;
        this.activityStatus = activityStatus;
    }

    public XLF_Activity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDetails() {
        return activityDetails;
    }

    public void setActivityDetails(String activityDetails) {
        this.activityDetails = activityDetails;
    }

    public int getActivityIfSchool() {
        return activityIfSchool;
    }

    public void setActivityIfSchool(int activityIfSchool) {
        this.activityIfSchool = activityIfSchool;
    }

    public String getActivityPic() {
        return activityPic;
    }

    public void setActivityPic(String activityPic) {
        this.activityPic = activityPic;
    }

    public String getActivityProvince() {
        return activityProvince;
    }

    public void setActivityProvince(String activityProvince) {
        this.activityProvince = activityProvince;
    }

    public String getActivityCity() {
        return activityCity;
    }

    public void setActivityCity(String activityCity) {
        this.activityCity = activityCity;
    }

    public String getActivityDistrict() {
        return activityDistrict;
    }

    public void setActivityDistrict(String activityDistrict) {
        this.activityDistrict = activityDistrict;
    }

    public String getActivityLocation() {
        return activityLocation;
    }

    public void setActivityLocation(String activityLocation) {
        this.activityLocation = activityLocation;
    }

    public int getActivityPerson() {
        return activityPerson;
    }

    public void setActivityPerson(int activityPerson) {
        this.activityPerson = activityPerson;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getActivityCreateTime() {
        return activityCreateTime;
    }

    public void setActivityCreateTime(Date activityCreateTime) {
        this.activityCreateTime = activityCreateTime;
    }

    public int getActivityCreateUser() {
        return activityCreateUser;
    }

    public void setActivityCreateUser(int activityCreateUser) {
        this.activityCreateUser = activityCreateUser;
    }

    public int getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(int activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Double getActivityLatitude() {
        return activityLatitude;
    }

    public void setActivityLatitude(Double activityLatitude) {
        this.activityLatitude = activityLatitude;
    }

    public Double getActivityLongitude() {
        return activityLongitude;
    }

    public void setActivityLongitude(Double activityLongitude) {
        this.activityLongitude = activityLongitude;
    }

    public void setActivityLatitude(double activityLatitude) {
        this.activityLatitude = activityLatitude;
    }

    public void setActivityLongitude(double activityLongitude) {
        this.activityLongitude = activityLongitude;
    }

    public List<String> getActivityDistricts() {
        return activityDistricts;
    }

    public void setActivityDistricts(List<String> activityDistricts) {
        this.activityDistricts = activityDistricts;
    }

    @Override
    public String toString() {
        return "XLF_Activity{" +
                "id=" + id +
                ", activityName='" + activityName + '\'' +
                ", activityDetails='" + activityDetails + '\'' +
                ", activityIfSchool=" + activityIfSchool +
                ", activityPic='" + activityPic + '\'' +
                ", activityProvince='" + activityProvince + '\'' +
                ", activityCity='" + activityCity + '\'' +
                ", activityDistrict='" + activityDistrict + '\'' +
                ", activityLocation='" + activityLocation + '\'' +
                ", activityLatitude=" + activityLatitude +
                ", activityLongitude=" + activityLongitude +
                ", activityPerson=" + activityPerson +
                ", activityStartTime=" + activityStartTime +
                ", activityCreateTime=" + activityCreateTime +
                ", activityCreateUser=" + activityCreateUser +
                ", activityStatus=" + activityStatus +
                '}';
    }
}
