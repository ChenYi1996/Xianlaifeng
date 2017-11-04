package com.xianlaifeng.model;

//用户信息实体类
public class T_B_User {

    private String id;
    private String user_name; //用户名
    private int user_sex;  //
    private int user_role; //用户角色（企业发布，兼职学生）
    private String user_company; //用户公司（企业用户）
    private String user_birthday;
    private int user_high;
    private String user_school_id; //用户学校
    private String user_qq;   //用户QQ
    private int user_phone;  //用户电话
    private String user_details; //用户简历

    public T_B_User() {
    }

    public T_B_User(String id, String user_name, int user_sex, int user_role, String user_company, String user_birthday, int user_high, String user_school_id, String user_qq, int user_phone, String user_details) {
        this.id = id;
        this.user_name = user_name;
        this.user_sex = user_sex;
        this.user_role = user_role;
        this.user_company = user_company;
        this.user_birthday = user_birthday;
        this.user_high = user_high;
        this.user_school_id = user_school_id;
        this.user_qq = user_qq;
        this.user_phone = user_phone;
        this.user_details = user_details;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(int user_sex) {
        this.user_sex = user_sex;
    }

    public int getUser_role() {
        return user_role;
    }

    public void setUser_role(int user_role) {
        this.user_role = user_role;
    }

    public String getUser_company() {
        return user_company;
    }

    public void setUser_company(String user_company) {
        this.user_company = user_company;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public int getUser_high() {
        return user_high;
    }

    public void setUser_high(int user_high) {
        this.user_high = user_high;
    }

    public String getUser_school_id() {
        return user_school_id;
    }

    public void setUser_school_id(String user_school_id) {
        this.user_school_id = user_school_id;
    }

    public String getUser_qq() {
        return user_qq;
    }

    public void setUser_qq(String user_qq) {
        this.user_qq = user_qq;
    }

    public int getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(int user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_details() {
        return user_details;
    }

    public void setUser_details(String user_details) {
        this.user_details = user_details;
    }

    @Override
    public String toString() {
        return "T_B_User{" +
                "id='" + id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_sex=" + user_sex +
                ", user_role=" + user_role +
                ", user_company='" + user_company + '\'' +
                ", user_birthday='" + user_birthday + '\'' +
                ", user_high=" + user_high +
                ", user_school_id='" + user_school_id + '\'' +
                ", user_qq='" + user_qq + '\'' +
                ", user_phone=" + user_phone +
                ", user_details='" + user_details + '\'' +
                '}';
    }
}
