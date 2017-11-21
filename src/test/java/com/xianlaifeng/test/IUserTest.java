package com.xianlaifeng.test;


import com.xianlaifeng.sys.dao.CommonDAO;
import com.xianlaifeng.user.dao.UserDAO;
import com.xianlaifeng.user.dao.WechatDAO;
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

//    @Resource
//    private OAuthDAO oAuthDAO;

    @Resource
    private WechatDAO wechatDAO;

    @Resource
    private CommonDAO commonDAO;

    @Resource
    private RedisService redisService;


<<<<<<< HEAD
//    @Test
//    public void testifExist(){
//        List<XLF_OAuth> l = oAuthDAO.ifExist(new XLF_OAuth("WeChat","CCC"));
//        System.out.println(l);
//    }

//    @Test
//    public void insert(){
//        oAuthDAO.insertOAuth(new XLF_OAuth("WeChat","CCC"));
//    }

//    @Test
//    public void getXLFUser(){
//        System.out.println(userDAO.getUser(new XLF_User(10002)));
//    }
=======
    @Test
    public void getXLFUser() {
        XLF_User u = new XLF_User();
        u.setUser_phone("6488");
        System.out.println(userDAO.getUser(u));
    }
>>>>>>> f0f6b5368531c4d2245db48155e8d7c8c64e77e6


    @Test
    public void testinsert() {
        XLF_User u = new XLF_User(null, 1, 1, null, 0, 0, 2576, null, null);
        userDAO.insertAndGetId(u);
        System.out.println(u);
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

<<<<<<< HEAD
}
=======
    @Test
    public void getSchool() {
        XLF_School xlf_school = new XLF_School();
        xlf_school.setSchool_name("药");
        xlf_school.setSchool_place("广东");
        System.out.println(schoolDAO.getSchool(xlf_school));
    }

}
>>>>>>> f0f6b5368531c4d2245db48155e8d7c8c64e77e6
