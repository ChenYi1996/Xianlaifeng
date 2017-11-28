package com.xianlaifeng.act.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xianlaifeng.act.dao.ActivityDAO;
import com.xianlaifeng.act.entity.XLF_Activity;
import com.xianlaifeng.act.service.ActivityService;
import com.xianlaifeng.sys.dao.CommonDAO;
import com.xianlaifeng.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("activityService")
public class ActivityServiceImpl implements ActivityService {


    @Autowired
    private ActivityDAO activityDAO;


    @Autowired
    private CommonDAO commonDAO;

    public Map<String, Object> getActivityDetails(int id) {
        List<Map<String,Object>> resultList = activityDAO.getActivityDetails(id);
        if(resultList.size()!=0){
            Map<String,Object> resultMap = resultList.get(0);

            //留空，为后面的报名人数和评论插入Map做铺垫

            return resultMap;
        }
        else {
            return null;
        }
    }

    public PageInfo<XLF_Activity> getActivityShow(XLF_Activity activity, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<XLF_Activity> p_list = new PageInfo<XLF_Activity>(activityDAO.getActivityShow(activity));
        return p_list;
    }

    public void insertActivity(XLF_Activity activity) {
        commonDAO.add(CommonUtils.add(activity));
    }

    public void updateActivity(XLF_Activity activity) {
        activityDAO.updateActivity(activity);
    }
}
