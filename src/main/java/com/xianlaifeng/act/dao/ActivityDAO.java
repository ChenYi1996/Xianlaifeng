package com.xianlaifeng.act.dao;

import com.xianlaifeng.act.entity.XLF_Activity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ActivityDAO {

    /**
     * 活动列表查询
     * @param xlf_activity
     * @return
     */
    public List<XLF_Activity> getActivityShow(XLF_Activity xlf_activity);


    /**
     * 显示活动详情
     * @param id
     * @return
     */
    public List<Map<String,Object>> getActivityDetails(int id);

    /**
     * 更新活动
     * @param xlf_activity
     */
    public void updateActivity(XLF_Activity xlf_activity);


    /**
     *由定时器触发，更新活动状态，将结束时间小于当前时间的活动状态置位已结束,即数据库中activityStatus为2
     * @param activityStatus
     */
    public void updateActivityStatusByTime(int activityStatus,Date date);


}
