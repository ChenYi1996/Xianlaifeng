package com.xianlaifeng.sys.service;

import com.xianlaifeng.sys.entity.XlfArea;

import java.util.List;
import java.util.Map;

public interface XlfAreaService {

   List<Map<String,Object>> selectDetails(XlfArea xlfArea);

   List<Map<String,Object>> selectByCityFirst();

   List<Map<String,Object>> selectHotCity();
}
