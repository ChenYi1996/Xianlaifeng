package com.xianlaifeng.act.service;

import com.github.pagehelper.PageInfo;
import com.xianlaifeng.act.entity.XLF_Join_Act;

import java.util.Map;

public interface JoinActService {

    //增加报名记录
    public String joinAct(XLF_Join_Act act);


    //查看个人报名记录
    public PageInfo<Map<String,Object>> joinActShow(XLF_Join_Act act, int pageNum, int pageSize);



}
