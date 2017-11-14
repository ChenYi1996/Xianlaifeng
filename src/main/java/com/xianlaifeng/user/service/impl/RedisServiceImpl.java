package com.xianlaifeng.user.service.impl;

import com.xianlaifeng.user.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

public class RedisServiceImpl implements RedisService{

    @Resource
    private RedisTemplate redisTemplate;


    public String getOpenid(String trd_session) {
        return  (String) redisTemplate.opsForHash().get(trd_session,"openid");
    }

    public String checkWeChatLogin(String trd_session) {
        return redisTemplate.opsForHash().entries("wechat:"+trd_session).isEmpty()?"noLogin":"Logined";
    }
}
