package com.xianlaifeng.join.dao;



import com.xianlaifeng.join.entity.XLF_Join;

import java.util.List;

public interface JoinDAO {


    public List<XLF_Join> ifExist(XLF_Join xlf_join);


}
