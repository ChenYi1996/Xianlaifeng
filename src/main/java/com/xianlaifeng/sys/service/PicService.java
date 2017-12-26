package com.xianlaifeng.sys.service;

import java.util.List;
import java.util.Map;

public interface PicService {

    public List<String> getActPicList();

    public List<String> getUserPicList();

    public List<Map<String,Object>> getActPic();

}
