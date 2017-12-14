package com.xianlaifeng.test;


import com.xianlaifeng.act.dao.ActivityDAO;
import com.xianlaifeng.act.dao.JoinActDAO;
import com.xianlaifeng.act.entity.XLF_Activity;
import com.xianlaifeng.act.entity.XLF_Join_Act;
import com.xianlaifeng.join.dao.JoinDAO;
import com.xianlaifeng.join.entity.XLF_Join;
import com.xianlaifeng.sys.dao.CommonDAO;
import com.xianlaifeng.utils.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-redis.xml"})
public class ActivityTest {

    @Resource
    private JoinActDAO joinActDAO;

    @Resource
    private CommonDAO commonDAO;

    @Resource
    private ActivityDAO activityDAO;


    @Resource
    private JoinDAO joinDAO;


    @Test
    public void testInsert(){
        XLF_Activity activity = new XLF_Activity();
        activity.setActivityName("aaa");
        activity.setActivityStartTime(new Date());
        activity.setActivityCreateTime(new Date());
        System.out.println(CommonUtils.getClassValueObj(activity));
        System.out.println(CommonUtils.add(activity));
        //commonDAO.add(CommonUtils.add(activity));
    }

    @Test
    public void printInit(){
        XLF_Activity activity = new XLF_Activity();
        activity.setActivityName("");
        activity.setActivityStatus(1);
        activity.setActivityLatitude(23.0999);
        activity.setActivityLongitude(113.3851);
        System.out.println(activityDAO.getActivityShow(activity));
    }

    @Test
    public void testGetMyjoin(){
        XLF_Join join = new XLF_Join();
        join.setMethodId(1);
        join.setUserId(10010);
        System.out.println(joinDAO.getMyJoin(join));
    }




}
