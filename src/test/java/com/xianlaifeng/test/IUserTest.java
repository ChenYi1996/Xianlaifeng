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
import com.xianlaifeng.utils.UUIDTool;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    private RedisTemplate redisTemplate;


    @Resource
    private ActivityService activityService;


    @Test
    public void getXLFUser() {

        String openid = "oVK4g0Z9EO8Tem1W5DEQJpv2Sqak";
        String session_key = "VRHUFLFpTkvSYb6snyxJdw==";
        String trd_sessionid = UUIDTool.getUUID(openid+session_key);
        Map<String,String> map = new HashMap<String, String>();
        map.put("openid",openid);
        map.put("session_key",session_key);
        redisTemplate.opsForHash().putAll("wechat:"+trd_sessionid,map);
        redisTemplate.expire(trd_sessionid,20, TimeUnit.DAYS);

    }


    @Test
    public void testinsert() {
        XLF_Activity activity = new XLF_Activity();
        System.out.println(CommonUtils.add(activity));

    }


    @Test
    public void testRedis() {
//        String trd_session  = "3a6645e0c170306fbdc2b247fa7dddc8";
//        String openid = trd_session == null?null:redisService.getOpenid(trd_session);
//        System.out.println(openid);
        //System.out.println(StringUtils.isEmpty(null));
        redisTemplate.opsForList().rightPush("keyList","d");
        System.out.println(redisTemplate.opsForList().range("keyList",0,-1));
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
        //redisService.insertHistory("bc574c35c27a3ea2b4aedfff4998eb0a","job","文员");
        redisService.clearSearch("bc574c35c27a3ea2b4aedfff4998eb0a","job");
    }

    @Test
    public void testList(){
        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("ee");
        list.add("abc");
        System.out.println(list);
        String item = "abc";
        System.out.println(list.contains(item));
        for (String s : list) {
            if (s.equals(item)) {
                list.remove(s);
                break;
            }
        }
        System.out.println(list);
    }





}