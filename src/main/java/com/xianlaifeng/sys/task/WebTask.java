package com.xianlaifeng.sys.task;

import com.xianlaifeng.act.dao.ActivityDAO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class WebTask {

    @Resource
    private ActivityDAO activityDAO;


    //每天凌晨和十二点调动任务，将结束时间已过的活动置位已结束
    @Scheduled(cron = "0 0 0 * * ?")
    public void TaskJob() {
        activityDAO.updateActivityStatusByTime(1,new Date());
    }
}