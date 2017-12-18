package com.xianlaifeng.user.service;

import com.github.pagehelper.PageInfo;
import com.xianlaifeng.join.entity.XLF_Join;
import com.xianlaifeng.user.entity.XLF_Collection;

import java.util.List;
import java.util.Map;

public interface CollectionService {

    public String addCollection(XLF_Collection collection);

    public int ifCollection(String trd_session ,int methodId,int actId);

    public String delCollection(XLF_Collection collection);

    public PageInfo<Map<String,Object>> getMyCollection(XLF_Collection collection, int pageNum, int pageSize);
}
