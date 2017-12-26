package com.xianlaifeng.join.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xianlaifeng.act.entity.XLF_Activity;
import com.xianlaifeng.join.dao.JoinDAO;
import com.xianlaifeng.join.entity.XLF_Join;
import com.xianlaifeng.join.service.JoinService;
import com.xianlaifeng.sys.dao.CommonDAO;
import com.xianlaifeng.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("joinServie")
public class JoinServiceImpl implements JoinService{

    @Autowired
    private CommonDAO commonDAO;

    @Autowired
    private JoinDAO joinDAO;


    public String addJoin(XLF_Join xlf_join) {
        if (joinDAO.ifExist(xlf_join).size()==0){
            commonDAO.add(CommonUtils.add(xlf_join));
            return "success";
        }else {
            return "已经报名";
        }
    }

    public PageInfo<Map<String,Object>> getMyJoin(XLF_Join xlf_join, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Map<String,Object>> p_list = new PageInfo<Map<String,Object>>(joinDAO.getMyJoin(xlf_join));
        return p_list;
    }

    public PageInfo<Map<String, Object>> getJoinUser(XLF_Join xlf_join, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Map<String,Object>> p_list = new PageInfo<Map<String,Object>>(joinDAO.getJoinUser(xlf_join));
        return p_list;

    }
}
