package com.xianlaifeng.DAO;

import com.xianlaifeng.model.XLF_OAuth;

public interface OAuthDAO {


    public void insertOAuth(XLF_OAuth xlf_oAuth);

    public String ifExist(XLF_OAuth xlf_oAuth);


}
