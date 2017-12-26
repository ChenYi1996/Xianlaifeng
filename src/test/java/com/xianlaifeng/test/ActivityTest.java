package com.xianlaifeng.test;


import com.xianlaifeng.act.dao.ActivityDAO;
import com.xianlaifeng.act.dao.JoinActDAO;
import com.xianlaifeng.act.entity.XLF_Activity;
import com.xianlaifeng.act.entity.XLF_Join_Act;
import com.xianlaifeng.join.dao.JoinDAO;
import com.xianlaifeng.join.entity.XLF_Join;
import com.xianlaifeng.sys.dao.CommonDAO;
import com.xianlaifeng.sys.service.PicService;
import com.xianlaifeng.utils.CommonUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    private PicService picService;


    @Resource
    private JoinDAO joinDAO;


    @Test
    public void testInsert(){
        List<Map<String,Object>> list = activityDAO.getActivityDetails(87);
        Map<String,Object> details = list.get(0);
        //System.out.println(details);
        String word = (String)details.get("activityDetails");
        System.out.println(word);
        System.out.println(word.length());
        //word.replace("https://www.xianlaifeng.com","");
        //System.out.println(word.replace("https://www.xianlaifeng.com",""));
        System.out.println(CommonUtils.parseHttp(word,"https://www.xianlaifeng.com"));
    }

    @Test
    public void printInit(){
        XLF_Activity activity = new XLF_Activity();
//        activity.setActivityName("");
//        activity.setActivityStatus(1);
//        activity.setActivityLatitude(23.0999);
//        activity.setActivityLongitude(113.3851);
        activity.setActivityCreateUser(10010);
        System.out.println(activityDAO.getActivityShow(activity));
    }

    @Test
    public void testGetMyjoin(){
        activityDAO.updateActivityStatusByTime(1,new Date());
    }


    @Test
    public void testGetPic(){
        System.out.println(picService.getActPic());
    }


}
