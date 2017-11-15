package com.xianlaifeng.user.service.impl;

import com.xianlaifeng.user.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("redisService")
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
