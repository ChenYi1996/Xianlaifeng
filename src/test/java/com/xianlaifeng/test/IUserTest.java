package com.xianlaifeng.test;


import com.xianlaifeng.DAO.OAuthDAO;
import com.xianlaifeng.DAO.UserDAO;
import com.xianlaifeng.model.T_B_User;
import com.xianlaifeng.model.XLF_OAuth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void testFindAll(){
        List<T_B_User> userList = userDAO.getAllUser();
        for(T_B_User u:userList){
            System.out.print(u);
        }
    }

    @Test
    public void testifExist(){
        System.out.println(oAuthDAO.ifExist(new XLF_OAuth("WeChat","CCC")));
    }

    @Test
    public void insert(){
        oAuthDAO.insertOAuth(new XLF_OAuth("WeChat","CCC"));
    }

}
