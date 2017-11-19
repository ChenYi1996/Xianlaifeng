package com.xianlaifeng.sys.entity;

public class XlfArea {

    private int areaId;
    private String province;
    private String city;
    private String district;

    public XlfArea() {
    }

    public XlfArea(int areaId, String province, String city, String district) {
        this.areaId = areaId;
        this.province = province;
        this.city = city;
        this.district = district;
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

    @Override
    public String toString() {
        return "XlfArea{" +
                "areaId=" + areaId +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
