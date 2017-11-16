package com.xianlaifeng.user.dao;

import com.xianlaifeng.user.entity.XLF_Wechat;

import java.util.List;

public interface WechatDAO {

    public List<XLF_Wechat> ifExist(XLF_Wechat xlf_wechat);

    public void updateWechat(XLF_Wechat xlf_wechat);



}
