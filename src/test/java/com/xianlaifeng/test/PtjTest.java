package com.xianlaifeng.test;


import com.xianlaifeng.ptj.dao.XlfPartTimeJobDAO;
import com.xianlaifeng.ptj.entity.XlfPartTimeJob;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-redis.xml"})
public class PtjTest {

    @Resource
    private XlfPartTimeJobDAO xlfPartTimeJobDAO;

    @Test
    public void  addTest(){
//        XlfPartTimeJob xlfPartTimeJob =new XlfPartTimeJob();
//        xlfPartTimeJob.setAreaId(1);
//        xlfPartTimeJob.setUserId(1);
//        xlfPartTimeJob.setAuditStatus("1");
//        xlfPartTimeJob.setJobContent("xxx");
//        xlfPartTimeJob.setReleaseTime(new Date());
//        xlfPartTimeJob.setWorkStreet("1街");
//        xlfPartTimeJob.setCalculateMoneyDate("2017.12.12");
//        xlfPartTimeJob.setCalculateMoneyType("2");
//        xlfPartTimeJob.setWage(new BigDecimal(100));
//        xlfPartTimeJob.setJobType("dasao");
//        xlfPartTimeJob.setJobName("qingjiegong");
//        xlfPartTimeJob.setLimitNumber(10);
//        xlfPartTimeJob.setSexDemand("3");
//        xlfPartTimeJob.setStartWorkDate(new Date());
//        xlfPartTimeJob.setEndWorkDate(new Date());
//        xlfPartTimeJob.setWageType("元/天");
//        xlfPartTimeJob.setTimeType("2");
//
//        int result=xlfPartTimeJobDAO.add(xlfPartTimeJob);
        System.out.println("--------------------"+result);
    }

}
