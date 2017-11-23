package com.xianlaifeng.sys.service.Impl;

import com.xianlaifeng.sys.dao.XlfAreaDAO;
import com.xianlaifeng.sys.entity.XlfArea;
import com.xianlaifeng.sys.service.XlfAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("XlfAreaService")
public class XlfAreaServiceImpl implements XlfAreaService {

    @Resource
    private XlfAreaDAO xlfAreaDAO;

    public List<Map<String,Object>> selectDetails(XlfArea xlfArea) {
        return xlfAreaDAO.selectDetails(xlfArea);
    }

    public List<Map<String, Object>> selectByCityFirst() {
        return xlfAreaDAO.selectByCityFirst();
    }

    public List<Map<String, Object>> selectHotCity() {
        return xlfAreaDAO.selectHotCity();
    }
}