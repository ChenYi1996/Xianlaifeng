package com.xianlaifeng.ptj.dao;

import com.xianlaifeng.ptj.entity.XlfPartTimeJob;

import java.util.List;
import java.util.Map;


public interface XlfPartTimeJobDAO {
    public List<Map<String,Object>> findList(XlfPartTimeJob xlfPartTimeJob);
    
    public int add(XlfPartTimeJob xlfPartTimeJob);
}
