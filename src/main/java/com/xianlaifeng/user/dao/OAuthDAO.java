package com.xianlaifeng.user.dao;

import com.xianlaifeng.user.entity.XLF_OAuth;

import java.util.List;

public interface OAuthDAO {


    public void insertOAuth(XLF_OAuth xlf_oAuth);

    public List<XLF_OAuth> ifExist(XLF_OAuth xlf_oAuth);


}
