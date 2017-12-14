package com.xianlaifeng.join.dao;



import com.xianlaifeng.join.entity.XLF_Join;

import java.util.List;
import java.util.Map;

public interface JoinDAO {


    public List<XLF_Join> ifExist(XLF_Join xlf_join);

    //查看个人报名记录
    public List<Map<String,Object>> getMyJoin(XLF_Join xlf_join);


}
