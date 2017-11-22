package com.xianlaifeng.ptj.service;

import com.github.pagehelper.PageInfo;
import com.xianlaifeng.ptj.entity.XlfPartTimeJob;
import com.xianlaifeng.user.entity.XLF_School;

import java.util.List;
import java.util.Map;

public interface XlfPartTimeJobService {
    public int add(XlfPartTimeJob xlfPartTimeJob);

    public PageInfo<XlfPartTimeJob> findList(XlfPartTimeJob xlfPartTimeJob,int pageNum,int pageSize);

    List<Map<String,Object>> selectDetails(String jobId);
}
