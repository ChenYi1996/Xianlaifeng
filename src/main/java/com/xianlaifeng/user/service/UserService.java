package com.xianlaifeng.user.service;


import com.xianlaifeng.user.entity.XLF_OAuth;

public interface UserService {


    public String WeChatLogin(String code);

    public Object getUserInfo(XLF_OAuth oau);

}
