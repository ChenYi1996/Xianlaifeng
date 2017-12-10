package com.xianlaifeng.test;


import com.xianlaifeng.ptj.dao.XlfPartTimeJobDAO;
import com.xianlaifeng.ptj.entity.XlfPartTimeJob;

import com.xianlaifeng.utils.TimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
//        System.out.println("--------------------"+result);
    }

    @Test
    public void selectDetailsTest(){
//        List<Map<String,Object>> list =xlfPartTimeJobDAO.selectDetails("3");
        System.out.println();
    }

    @Test
    public void findListTest(){
        XlfPartTimeJob xlfPartTimeJob = new XlfPartTimeJob();
        String string ="1,2";
        String jobType="打扫";
        String timeType="1,2";
        List<Integer> in = new ArrayList<Integer>();
        for(int i=0; i<Arrays.asList(string.split(",")).size();i++){
            in.add(Integer.valueOf(Arrays.asList(string.split(",")).get(i)));
        }
        xlfPartTimeJob.setAreaIds(in);
        System.out.println();
    }


    @Test
    public void timeTest() throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1=simpleDateFormat.parse("2017-11-30 23:53:54");
        Date date2=simpleDateFormat.parse("2017-12-05 23:09:36");
        TimeUtil.differentDaysByMillisecond(date2,date1);


    }
}
