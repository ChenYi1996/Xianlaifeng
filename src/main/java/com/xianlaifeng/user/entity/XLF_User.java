package com.xianlaifeng.user.entity;

//用户信息实体类
public class XLF_User {

    private int id;
    private String user_name; //用户名
    private int user_sex;  // 1:male 2:female
    private int user_role; //用户角色（企业发布，兼职学生）1:公司代理人 2：学生
    private String user_company; //用户公司（企业用户）
    private int user_age;
    private int user_high;
    private int user_school_id; //用户学校
    private String user_phone;  //用户电话
    private String user_details; //用户简历

    public XLF_User(String user_name, int user_sex, int user_role, String user_company, int user_age, int user_high, int user_school_id, String user_phone, String user_details) {
        this.user_name = user_name;
        this.user_sex = user_sex;
        this.user_role = user_role;
        this.user_company = user_company;
        this.user_age = user_age;
        this.user_high = user_high;
        this.user_school_id = user_school_id;
        this.user_phone = user_phone;
        this.user_details = user_details;
    }

    public XLF_User(int id, String user_name, int user_sex, int user_role, String user_company, int user_age, int user_high, int user_school_id, String user_phone, String user_details) {
        this.id = id;
        this.user_name = user_name;
        this.user_sex = user_sex;
        this.user_role = user_role;
        this.user_company = user_company;
        this.user_age = user_age;
        this.user_high = user_high;
        this.user_school_id = user_school_id;
        this.user_phone = user_phone;
        this.user_details = user_details;
    }

    public XLF_User() {



    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public int getUser_high() {
        return user_high;
    }

    public void setUser_high(int user_high) {
        this.user_high = user_high;
    }

    public int getUser_school_id() {
        return user_school_id;
    }

    public void setUser_school_id(int user_school_id) {
        this.user_school_id = user_school_id;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_details() {
        return user_details;
    }

    public void setUser_details(String user_details) {
        this.user_details = user_details;
    }

    public XLF_User(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "XLF_User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", user_sex=" + user_sex +
                ", user_role=" + user_role +
                ", user_company='" + user_company + '\'' +
                ", user_age=" + user_age +
                ", user_high=" + user_high +
                ", user_school_id=" + user_school_id +
                ", user_phone='" + user_phone + '\'' +
                ", user_details='" + user_details + '\'' +
                '}';
    }
}
