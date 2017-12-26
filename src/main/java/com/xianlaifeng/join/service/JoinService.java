package com.xianlaifeng.join.service;

import com.github.pagehelper.PageInfo;
import com.xianlaifeng.join.entity.XLF_Join;

import java.util.Map;

public interface JoinService {

    public String addJoin(XLF_Join xlf_join);

    public PageInfo<Map<String,Object>> getMyJoin(XLF_Join xlf_join, int pageNum, int pageSize);

    public PageInfo<Map<String,Object>> getJoinUser(XLF_Join xlf_join, int pageNum, int pageSize);

}
