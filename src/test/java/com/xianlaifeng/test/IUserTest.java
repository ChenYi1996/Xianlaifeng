package com.xianlaifeng.test;


import com.xianlaifeng.user.dao.OAuthDAO;
import com.xianlaifeng.user.dao.UserDAO;
import com.xianlaifeng.user.entity.XLF_OAuth;
import com.xianlaifeng.user.entity.XLF_User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-redis.xml"})
public class IUserTest {

    @Resource
    private UserDAO userDAO;

    @Resource
    private OAuthDAO oAuthDAO;


    @Test
    public void testifExist(){
        List<XLF_OAuth> l = oAuthDAO.ifExist(new XLF_OAuth("WeChat","CCC"));
        System.out.println(l);
    }

    @Test
    public void insert(){
        oAuthDAO.insertOAuth(new XLF_OAuth("WeChat","CCC"));
    }

    @Test
    public void getXLFUser(){
        System.out.println(userDAO.getUser(new XLF_User(1)));
    }

}
