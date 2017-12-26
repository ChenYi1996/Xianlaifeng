package com.xianlaifeng.sys.dao;


import java.util.List;
import java.util.Map;

public interface PicDAO {

    public List<String> getActPicList();

    public List<String> getUserPicList();

    public List<Map<String,Object>> getActPic();

    public List<String> getActPicType();



}
