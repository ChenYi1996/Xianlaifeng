package com.xianlaifeng.user.dao;

import com.xianlaifeng.user.entity.XLF_User;
import org.apache.ibatis.annotations.Param;

import javax.xml.registry.infomodel.User;
import java.util.List;
import java.util.Map;

public interface UserDAO {


    public List<Map<String, Object>> getUser(XLF_User u);

    public int insertAndGetId(XLF_User u);

    public void updateUserInfo(XLF_User u);

    public List<Map<String,Object>> getMyPub(@Param("userId")int userId,@Param("methodId")int methodId);

}
