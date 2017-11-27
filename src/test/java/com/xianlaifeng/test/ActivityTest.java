package com.xianlaifeng.test;


import com.xianlaifeng.act.entity.XLF_Activity;
import com.xianlaifeng.sys.dao.CommonDAO;
import com.xianlaifeng.utils.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-redis.xml"})
public class ActivityTest {


    @Resource
    private CommonDAO commonDAO;


    @Test
    public void testInsert(){
        XLF_Activity activity = new XLF_Activity();
        activity.setActivityName("aaa");
        activity.setActivityStartTime(new Date());
        activity.setActivityCreateTime(new Date());
        System.out.println(CommonUtils.add(activity));
        commonDAO.add(CommonUtils.add(activity));
    }

    @Test
    public void printInit(){
        XLF_Activity activity = new XLF_Activity();
        System.out.println(activity);
    }




}
