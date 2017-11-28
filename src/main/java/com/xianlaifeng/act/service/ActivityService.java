package com.xianlaifeng.act.service;

import com.github.pagehelper.PageInfo;
import com.xianlaifeng.act.entity.XLF_Activity;

import java.util.List;
import java.util.Map;

public interface ActivityService {

    public Map<String, Object> getActivityDetails(int id);

    public PageInfo<XLF_Activity> getActivityShow(XLF_Activity activity, int pageNum, int pageSize);

    public void insertActivity(XLF_Activity activity);

    public void updateActivity(XLF_Activity activity);

}
