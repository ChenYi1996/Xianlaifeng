package com.xianlaifeng.act.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xianlaifeng.act.dao.JoinActDAO;
import com.xianlaifeng.act.entity.XLF_Activity;
import com.xianlaifeng.act.entity.XLF_Join_Act;
import com.xianlaifeng.act.service.JoinActService;
import com.xianlaifeng.sys.dao.CommonDAO;
import com.xianlaifeng.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("joinActService")
public class JoinActServiceImpl implements JoinActService{

    @Autowired
    private CommonDAO commonDAO;

    @Autowired
    private JoinActDAO joinActDAO;


    public String joinAct(XLF_Join_Act act) {
        if (joinActDAO.ifExist(act).size()==0){
            commonDAO.add(CommonUtils.add(act));
            return "success";
        }else {
            return "已经报名";
        }
    }

    public PageInfo<Map<String,Object>> joinActShow(XLF_Join_Act act, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Map<String,Object>> p_list = new PageInfo<Map<String,Object>>(joinActDAO.getJoinUser(act.getActId()));
        return p_list;
    }
}
