package com.xianlaifeng.model;

public class XLF_OAuth {

    private int id;
    private String user_id;
    private String oau_method;
    private String oau_id;

    public XLF_OAuth(int id, String user_id, String oau_method, String oau_id) {
        this.id = id;
        this.user_id = user_id;
        this.oau_method = oau_method;
        this.oau_id = oau_id;
    }

    public XLF_OAuth(){

    }

    public XLF_OAuth(String oau_method, String oau_id) {
        this.oau_method = oau_method;
        this.oau_id = oau_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOau_method() {
        return oau_method;
    }

    public void setOau_method(String oau_method) {
        this.oau_method = oau_method;
    }

    public String getOau_id() {
        return oau_id;
    }

    public void setOau_id(String oau_id) {
        this.oau_id = oau_id;
    }

    @Override
    public String toString() {
        return "XLF_OAuth{" +
                "id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", oau_method='" + oau_method + '\'' +
                ", oau_id='" + oau_id + '\'' +
                '}';
    }
}
