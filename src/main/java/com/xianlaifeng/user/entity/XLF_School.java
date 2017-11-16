package com.xianlaifeng.user.entity;

public class XLF_School {

    private int id;
    private String school_name;
    private String school_place;
    private String school_type;
    private String school_properties;

    public XLF_School() {
    }

    public XLF_School(int id, String school_name, String school_place, String school_type, String school_properties) {
        this.id = id;
        this.school_name = school_name;
        this.school_place = school_place;
        this.school_type = school_type;
        this.school_properties = school_properties;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getSchool_place() {
        return school_place;
    }

    public void setSchool_place(String school_place) {
        this.school_place = school_place;
    }

    public String getSchool_type() {
        return school_type;
    }

    public void setSchool_type(String school_type) {
        this.school_type = school_type;
    }

    public String getSchool_properties() {
        return school_properties;
    }

    public void setSchool_properties(String school_properties) {
        this.school_properties = school_properties;
    }

    @Override
    public String toString() {
        return "XLF_School{" +
                "id=" + id +
                ", school_name='" + school_name + '\'' +
                ", school_place='" + school_place + '\'' +
                ", school_type='" + school_type + '\'' +
                ", school_properties='" + school_properties + '\'' +
                '}';
    }
}
