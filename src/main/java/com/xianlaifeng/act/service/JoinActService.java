package com.xianlaifeng.act.service;

import com.xianlaifeng.act.entity.XLF_Join_Act;

public interface JoinActService {

    public void joinAct(XLF_Join_Act act);

    public Object joinActShow(XLF_Join_Act act,int pageNum,int pageSize);

}
