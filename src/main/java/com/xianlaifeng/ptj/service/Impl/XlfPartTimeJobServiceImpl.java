package com.xianlaifeng.ptj.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xianlaifeng.ptj.dao.XlfPartTimeJobDAO;
import com.xianlaifeng.ptj.entity.XlfPartTimeJob;
import com.xianlaifeng.ptj.service.XlfPartTimeJobService;
import com.xianlaifeng.user.entity.XLF_School;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        return xlfPartTimeJobDAO.add(xlfPartTimeJob);
    }

    public PageInfo<XlfPartTimeJob> findList(XlfPartTimeJob xlfPartTimeJob, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<XlfPartTimeJob> p_list = new PageInfo<XlfPartTimeJob>(xlfPartTimeJobDAO.findList(xlfPartTimeJob));
        return p_list;

    }

    public List<Map<String,Object>> selectDetails(String jobId) {
        if(jobId == null){
            return null;
        }
        return xlfPartTimeJobDAO.selectDetails(jobId);
    }



}
