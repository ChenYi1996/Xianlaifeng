package com.xianlaifeng.sys.service.Impl;

import com.xianlaifeng.sys.dao.XlfAreaDAO;
import com.xianlaifeng.sys.entity.XlfArea;
import com.xianlaifeng.sys.service.XlfAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("XlfAreaService")
public class XlfAreaServiceImp implements XlfAreaService{

    @Resource
    private XlfAreaDAO xlfAreaDAO;
    
    public int add(XlfArea xlfArea) {
        if(xlfArea == null){
            return 0;
        }
        return  xlfAreaDAO.add(xlfArea);
    }

    public List<Map<String, Object>> findList(XlfArea xlfArea) {
        return xlfAreaDAO.findList(xlfArea);
    }
}
