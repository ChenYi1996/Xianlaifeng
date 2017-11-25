package com.xianlaifeng.test;


import com.xianlaifeng.act.dao.ActivityDAO;
import com.xianlaifeng.act.entity.XLF_Activity;
import com.xianlaifeng.act.service.ActivityService;
import com.xianlaifeng.sys.dao.CommonDAO;
import com.xianlaifeng.user.dao.SchoolDAO;
import com.xianlaifeng.user.dao.UserDAO;
import com.xianlaifeng.user.dao.WechatDAO;
import com.xianlaifeng.user.entity.XLF_School;
import com.xianlaifeng.user.entity.XLF_User;
import com.xianlaifeng.user.entity.XLF_Wechat;
import com.xianlaifeng.user.service.RedisService;
import com.xianlaifeng.utils.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-redis.xml"})
public class IUserTest {

    @Resource
    private UserDAO userDAO;


    @Resource
    private WechatDAO wechatDAO;

    @Resource
    private CommonDAO commonDAO;

    @Resource
    private SchoolDAO schoolDAO;

    @Resource
    private ActivityDAO activityDAO;

    @Resource
    private RedisService redisService;

    @Resource
    private ActivityService activityService;


    @Test
    public void getXLFUser() {
        XLF_User u = new XLF_User();
        u.setUser_phone("6488");
        System.out.println(userDAO.getUser(u));
    }


    @Test
    public void testinsert() {
        XLF_User u = new XLF_User("", 1, 1, null, 0, 0, 2576, null, null);
        System.out.println(u.checkMessage());
    }


    @Test
    public void testRedis() {
        System.out.println(redisService.getOpenid("iiii"));
    }

    @Test
    public void testChange() {
        XLF_User xu = new XLF_User();
        xu.setUser_school_id(2567);
        xu.setUser_role(1);
        xu.setUser_sex(1);
        Map<String, Object> u_info = CommonUtils.objectToMap(xu);
        System.out.println(u_info);
    }

    @Test
    public void getSchool() {
        XLF_School xlf_school = new XLF_School();
        xlf_school.setSchool_name("药");
        xlf_school.setSchool_place("广东");
        System.out.println(schoolDAO.getSchool(xlf_school));
    }

    @Test
    public void printSQL() {
        String areas = "云城区、新兴县、郁南县、云安县、罗定市";
        areas.split("、");
        String city ="云浮市";
        for(String area:areas.split("、")){
            System.out.println("insert into xlf_area (province,city,district) values("+"'广东省','"+city+"','"+area+"');");
        }
        System.out.println("insert into xlf_area (province,city,district) values("+"'广东省','"+city+"','其他区');");
    }

    @Test
    public void getActivity(){
        System.out.println(activityService.getActivityDetails(1));
    }


}