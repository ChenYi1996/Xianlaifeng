package com.xianlaifeng.ptj.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.xianlaifeng.ptj.dao.XlfPartTimeJobDAO;
import com.xianlaifeng.ptj.entity.XlfPartTimeJob;
import com.xianlaifeng.ptj.service.XlfPartTimeJobService;
import com.xianlaifeng.user.entity.XLF_School;
import com.xianlaifeng.utils.TimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("XlfPartTimeJobService")
public class XlfPartTimeJobServiceImpl implements XlfPartTimeJobService{


    @Resource
    private XlfPartTimeJobDAO xlfPartTimeJobDAO;

    public int add(XlfPartTimeJob xlfPartTimeJob) {
        if(xlfPartTimeJob == null){
            return 0;
        }
        if(null != xlfPartTimeJob.getStartWorkDate() &&  null != xlfPartTimeJob.getEndWorkDate()){
            //获取两个日期的相差时间，包含最后一天
           int days = TimeUtil.differentDaysByMillisecond(xlfPartTimeJob.getEndWorkDate(),xlfPartTimeJob.getStartWorkDate());
           if(days < 5){
               xlfPartTimeJob.setTimeType("1");
               Calendar calendar=Calendar.getInstance();
               calendar.setTime(xlfPartTimeJob.getStartWorkDate());
               Date date= xlfPartTimeJob.getStartWorkDate();
               int result=0;
               for(int i=0;i<days;i++){
                   try {
                       result=TimeUtil.dayForWeek(date);
                       if(result == 7 || result == 6){
                           xlfPartTimeJob.setTimeType("2");
                           break;
                       }
                      calendar.add(Calendar.DAY_OF_MONTH,1);
                       date=calendar.getTime();

                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }


            }else{//大于五天，表示存在周末
               if(days <15){
                    xlfPartTimeJob.setTimeType("2");//小于15天大于5天，表示短期包含周末
               }else{
                    xlfPartTimeJob.setTimeType("3");//长期，大于15天
               }
           }

        }
        xlfPartTimeJob.setReleaseTime(new Date());
        return xlfPartTimeJobDAO.add(xlfPartTimeJob);
    }

    public PageInfo<XlfPartTimeJob> findList(XlfPartTimeJob xlfPartTimeJob, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<XlfPartTimeJob> p_list = new PageInfo<XlfPartTimeJob>(xlfPartTimeJobDAO.findList(xlfPartTimeJob));
        return p_list;

    }

    public List<XlfPartTimeJob> selectDetails(String jobId) {
        if(jobId == null){
            return null;
        }
        return xlfPartTimeJobDAO.selectDetails(jobId);
    }



}
