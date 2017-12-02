package com.xianlaifeng.act.dao;

import com.xianlaifeng.act.entity.XLF_Join_Act;

import java.util.List;
import java.util.Map;

public interface JoinActDAO {

    public List<Map<String,Object>> getJoinUser(int act_id);

    public List<Map<String,Object>> getMyJoin(XLF_Join_Act join_act);

    public List<XLF_Join_Act> ifExist(XLF_Join_Act join_act);

}
