package com.xianlaifeng.act.service.impl;

import com.github.pagehelper.PageHelper;
import com.xianlaifeng.act.entity.XLF_Join_Act;
import com.xianlaifeng.act.service.JoinActService;
import com.xianlaifeng.sys.dao.CommonDAO;
import com.xianlaifeng.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("joinActService")
public class JoinActServiceImpl implements JoinActService{

    @Autowired
    private CommonDAO commonDAO;


    public void joinAct(XLF_Join_Act act) {
        commonDAO.add(CommonUtils.add(act));
    }

    public Object joinActShow(XLF_Join_Act act, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return null;
    }
}
