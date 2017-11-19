package com.xianlaifeng.ptj.service;

import com.xianlaifeng.ptj.entity.XlfPartTimeJob;

import java.util.List;
import java.util.Map;

public interface XlfPartTimeJobService {
    public int add(XlfPartTimeJob xlfPartTimeJob);

    public List<Map<String,Object>> findList(XlfPartTimeJob xlfPartTimeJob);

    XlfPartTimeJob selectDetails(String jobId);
}
