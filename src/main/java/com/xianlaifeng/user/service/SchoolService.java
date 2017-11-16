package com.xianlaifeng.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xianlaifeng.user.entity.XLF_School;

public interface SchoolService {

    public PageInfo<XLF_School> getSchool(XLF_School school, int pageNum, int pageSize);

}
