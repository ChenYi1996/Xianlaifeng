package com.xianlaifeng.test;


import com.xianlaifeng.DAO.UserDAO;
import com.xianlaifeng.model.T_B_User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-redis.xml"})
public class IUserTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testFindAll(){
        List<T_B_User> userList = userDAO.getAllUser();
        for(T_B_User u:userList){
            System.out.print(u);
        }
    }

}
