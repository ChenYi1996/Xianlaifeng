package com.xianlaifeng.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xianlaifeng.user.dao.SchoolDAO;
import com.xianlaifeng.user.entity.XLF_School;
import com.xianlaifeng.user.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class SchoolServiceImpl implements SchoolService {


    @Autowired
    private SchoolDAO schoolDAO;


    public PageInfo<XLF_School> getSchool(XLF_School school, String pageNum, String pageSize) {
        PageHelper.startPage(Integer.parseInt(pageNum),Integer.parseInt(pageSize));
        PageInfo<XLF_School> p_list = new PageInfo<XLF_School>(schoolDAO.getSchool(school));
        return p_list;
    }
}
