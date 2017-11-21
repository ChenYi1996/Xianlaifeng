package com.xianlaifeng.user.entity;

public class XLF_Wechat {

    private int id;
    private String openid;
    private String avatarUrl;
    private String nickName;
    private int gender;
    private String country;
    private String province;
    private String city;
    private int user_id;

    public XLF_Wechat(String openid) {
        this.openid = openid;
    }

    public XLF_Wechat() {


    }

    public XLF_Wechat(int id, String openid, String avatarUrl, String nickName, int gender, String country, String province, String city, int user_id) {
        this.id = id;
        this.openid = openid;
        this.avatarUrl = avatarUrl;
        this.nickName = nickName;
        this.gender = gender;
        this.country = country;
        this.province = province;
        this.city = city;
        this.user_id = user_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    @Override
    public String toString() {
        return "XLF_Wechat{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", user_id=" + user_id +
                '}';
    }



}
