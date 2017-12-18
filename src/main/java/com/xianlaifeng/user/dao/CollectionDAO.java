package com.xianlaifeng.user.dao;


import com.xianlaifeng.user.entity.XLF_Collection;

import java.util.List;
import java.util.Map;

public interface CollectionDAO {

    public List<XLF_Collection> ifExist(XLF_Collection xlf_collection);

    public void delCollection(XLF_Collection xlf_collection);

    public List<Map<String,Object>> getUserCollection(XLF_Collection xlf_collection);

}
