package com.xianlaifeng.act.dao;

import com.xianlaifeng.act.entity.XLF_Activity;

import java.util.List;
import java.util.Map;

public interface ActivityDAO {

    public List<XLF_Activity> getActivityShow(XLF_Activity xlf_activity);

    public List<Map<String,Object>> getActivityDetails(int id);

    public void updateActivity(XLF_Activity xlf_activity);


}
