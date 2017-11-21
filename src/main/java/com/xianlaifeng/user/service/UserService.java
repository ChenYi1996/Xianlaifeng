package com.xianlaifeng.user.service;


import com.xianlaifeng.user.entity.XLF_User;
import com.xianlaifeng.user.entity.XLF_Wechat;

public interface UserService {


    public String WeChatLogin(String code);

    public Object getWechatUserInfo(XLF_Wechat we);

    public void updateWechatUserInfo(XLF_User user);

    public Object updateWechat(XLF_Wechat wechat);


}
