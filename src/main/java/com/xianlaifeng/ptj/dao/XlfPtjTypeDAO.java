package com.xianlaifeng.ptj.dao;

import com.xianlaifeng.ptj.entity.XlfPartTimeJob;
import com.xianlaifeng.ptj.entity.XlfPtjType;

import java.util.List;
import java.util.Map;


public interface XlfPtjTypeDAO {
    List<Map<String,Object>> selectAll();

    XlfPtjType select(XlfPtjType xlfPtjType);
}
