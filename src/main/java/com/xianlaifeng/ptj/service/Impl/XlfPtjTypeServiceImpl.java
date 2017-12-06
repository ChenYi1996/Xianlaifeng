package com.xianlaifeng.ptj.service.Impl;

import com.xianlaifeng.ptj.dao.XlfPtjTypeDAO;
import com.xianlaifeng.ptj.entity.XlfPtjType;
import com.xianlaifeng.ptj.service.XlfPtjTypeService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("XLfPtjTypeService")
public class XlfPtjTypeServiceImpl implements XlfPtjTypeService{

    @Resource
    private XlfPtjTypeDAO xlfPtjTypeDAO;

    @Override
    public List<Map<String,Object>> selectAll(){
        return xlfPtjTypeDAO.selectAll();
    }

    @Override
    public XlfPtjType select (XlfPtjType xlfPtjType){
        if(xlfPtjType == null){
            return null;
        }
        return xlfPtjTypeDAO.select(xlfPtjType);
    }
}
