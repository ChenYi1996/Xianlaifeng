package com.xianlaifeng.act.service;

import com.github.pagehelper.PageInfo;
import com.xianlaifeng.act.entity.XLF_Join_Act;

import java.util.Map;

public interface JoinActService {

    public String joinAct(XLF_Join_Act act);

    public PageInfo<Map<String,Object>> joinActShow(XLF_Join_Act act, int pageNum, int pageSize);



}
