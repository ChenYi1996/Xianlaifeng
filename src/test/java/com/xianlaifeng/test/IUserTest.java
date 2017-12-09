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
import com.xianlaifeng.user.service.UserService;
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
    private UserService userService;

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
        String openid = "oVK4g0Z9EO8Tem1W5DEQJpv2Sqak";
        XLF_Wechat xw = wechatDAO.ifExist(new XLF_Wechat(openid)).get(0);
        System.out.println(xw);
        Map<String, Object> u_info = (Map<String, Object>)userService.getWechatUserInfo(new XLF_Wechat(openid));
        System.out.println(u_info);
    }


    @Test
    public void testinsert() {

    }


    @Test
    public void testRedis() {
        String trd_session  = "3a6645e0c170306fbdc2b247fa7dddc8";
        String openid = trd_session == null?null:redisService.getOpenid(trd_session);
        System.out.println(openid);
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

    @Test
    public void ecHTTP(){
        String url = "https://www.westorehere.shop/img/xianlaifeng/user/user_924905714ufPD_444.png";
        String null_url = null;
        System.out.println(CommonUtils.getFileNameFromHttp(null_url));
    }


}