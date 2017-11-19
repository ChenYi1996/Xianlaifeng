package com.xianlaifeng.ptj.service.Impl;

import com.xianlaifeng.ptj.dao.XlfPartTimeJobDAO;
import com.xianlaifeng.ptj.entity.XlfPartTimeJob;
import com.xianlaifeng.ptj.service.XlfPartTimeJobService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public class XlfPartTimeJobServiceImpl implements XlfPartTimeJobService{


    @Resource
    private XlfPartTimeJobDAO xlfPartTimeJobDAO;

    public int add(XlfPartTimeJob xlfPartTimeJob) {
        if(xlfPartTimeJob == null){
            return 0;
        }
        return xlfPartTimeJobDAO.add(xlfPartTimeJob);
    }

    public List<Map<String, Object>> findList(XlfPartTimeJob xlfPartTimeJob) {
        return xlfPartTimeJobDAO.findList(xlfPartTimeJob);
    }

    public XlfPartTimeJob selectDetails(String jobId) {
        if(jobId == null){
            return null;
        }
        return xlfPartTimeJobDAO.selectDetails(jobId);
    }

}
