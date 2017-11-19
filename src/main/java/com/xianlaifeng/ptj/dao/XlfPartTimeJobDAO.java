package com.xianlaifeng.ptj.dao;

import com.xianlaifeng.ptj.entity.XlfPartTimeJob;

import java.util.List;
import java.util.Map;


public interface XlfPartTimeJobDAO {
    List<Map<String, Object>> findList(XlfPartTimeJob xlfPartTimeJob);
    
    int add(XlfPartTimeJob xlfPartTimeJob);

    XlfPartTimeJob selectDetails(String jobId);
}
