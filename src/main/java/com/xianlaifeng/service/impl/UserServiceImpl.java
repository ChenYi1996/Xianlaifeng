package com.xianlaifeng.service.impl;

import com.xianlaifeng.DAO.OAuthDAO;
import com.xianlaifeng.DAO.UserDAO;
import com.xianlaifeng.model.T_B_User;
import com.xianlaifeng.model.XLF_OAuth;
import com.xianlaifeng.service.UserService;
import com.xianlaifeng.utils.DesUtil;
import com.xianlaifeng.utils.RequestUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service("userService")
public class UserServiceImpl implements UserService{


    private static final String appid = "wxfd21b79973f49459";
    private static final String app_se= "094ca7963f55405b23af1dafd702e012";
    private static final String url="https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private OAuthDAO oAuthDAO;


    @Resource
    private RedisTemplate redisTemplate;

    public List<T_B_User> findAllUser() {
        return userDAO.getAllUser();
    }


    public String checkWeChatLogin(String trd_session) {

        return redisTemplate.opsForHash().entries("wechat:"+trd_session).isEmpty()?"noLogin":"Logined";

    }

    public String WeChatLogin(String code) {
        String app_url = url.replace("APPID",appid).replace("SECRET",app_se).replace("JSCODE",code);
        JSONObject resultJSON = JSONObject.fromObject(RequestUtils.httpRequest(app_url));
        if(resultJSON.containsKey("errcode")){
            return "error";
        }
        else {
            String openid = resultJSON.getString("openid");
            String session_key = resultJSON.getString("session_key");
            String trd_sessionid = DesUtil.encrypt(openid+session_key);
            Map<String,String> map = new HashMap<String, String>();
            map.put("openid",openid);
            map.put("session_key",session_key);
            if(oAuthDAO.ifExist(new XLF_OAuth("wechat",openid)) == null){
                oAuthDAO.insertOAuth(new XLF_OAuth("wechat",openid));
            }
            redisTemplate.opsForHash().putAll("wechat:"+trd_sessionid,map);
            redisTemplate.expire(trd_sessionid,20, TimeUnit.DAYS);
            return trd_sessionid;
        }
    }
}
