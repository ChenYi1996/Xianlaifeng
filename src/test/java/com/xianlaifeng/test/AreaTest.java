package com.xianlaifeng.test;

import com.xianlaifeng.sys.dao.XlfAreaDAO;
import com.xianlaifeng.sys.entity.XlfArea;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-redis.xml"})
public class AreaTest {

    @Resource
    private XlfAreaDAO xlfAreaDAO;

    @Test
    public void selectDetailsTest(){
        XlfArea xlfArea=new XlfArea();
        xlfArea.setCity("广州市");
        List<Map<String,Object>> list=xlfAreaDAO.selectDetails(xlfArea);

    }

    @Test
    public void selectCityTest(){
        List<Map<String,Object>> list=xlfAreaDAO.selectHotCity();
        List<Map<String,Object>> list1 = xlfAreaDAO.selectByCityFirst();
        System.out.println();
    }
}
