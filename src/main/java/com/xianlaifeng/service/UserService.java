package com.xianlaifeng.service;


import com.xianlaifeng.model.T_B_User;
import java.util.List;

public interface UserService {

    public List<T_B_User> findAllUser();

    public String WeChatLogin(String code);

    public String checkWeChatLogin(String trd_session);
}
