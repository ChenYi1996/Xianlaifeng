package com.xianlaifeng.sys.entity;

public class XlfArea {

    private int areaId;
    private String province;
    private String city;
    private String district;

    private String CityFirst;
    private String hotCity;


    public void setCityFirst(String cityFirst) {
        CityFirst = cityFirst;
    }

    public void setHotCity(String hotCity) {
        this.hotCity = hotCity;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getAreaId() {
        return areaId;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getCityFirst() {
        return CityFirst;
    }

    public String getHotCity() {
        return hotCity;
    }
}
