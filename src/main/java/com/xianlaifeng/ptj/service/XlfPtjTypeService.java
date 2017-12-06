package com.xianlaifeng.ptj.service;

import com.xianlaifeng.ptj.entity.XlfPtjType;

import java.util.List;
import java.util.Map;

public interface XlfPtjTypeService {

    List<Map<String,Object>> selectAll();

    XlfPtjType select(XlfPtjType xlfPtjType);
}
