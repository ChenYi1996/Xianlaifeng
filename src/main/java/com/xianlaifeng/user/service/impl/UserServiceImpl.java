package com.xianlaifeng.user.service.impl;


import com.xianlaifeng.sys.dao.CommonDAO;
import com.xianlaifeng.user.dao.SchoolDAO;
import com.xianlaifeng.user.dao.WechatDAO;
import com.xianlaifeng.user.entity.XLF_Wechat;
import com.xianlaifeng.user.service.UserService;
import com.xianlaifeng.user.dao.UserDAO;
import com.xianlaifeng.user.entity.XLF_User;
import com.xianlaifeng.utils.CommonUtils;
import com.xianlaifeng.utils.RequestUtils;
import com.xianlaifeng.utils.UUIDTool;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service("userService")
public class UserServiceImpl implements UserService{

    private static final int SESSION_TIME = 20;
    private static final int INIT_SCHOOL = 2567;
    private static final String appid = "wxa40025bf8ead1e26";
    private static final String app_se= "3d18bab9a9c55408c573200113139f6f";
    private static final String url="https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private WechatDAO wechatDAO;

    @Autowired
    private CommonDAO commonDAO;



    @Resource
    private RedisTemplate redisTemplate;


    public String WeChatLogin(String code) {
        String app_url = url.replace("APPID",appid).replace("SECRET",app_se).replace("JSCODE",code);
        JSONObject resultJSON = JSONObject.fromObject(RequestUtils.httpRequest(app_url));
        if(resultJSON.containsKey("errcode")){
            return "error";
        }
        else {
            String openid = resultJSON.getString("openid");
            String session_key = resultJSON.getString("session_key");
            String trd_sessionid = UUIDTool.getUUID(openid+session_key);
            Map<String,String> map = new HashMap<String, String>();
            map.put("openid",openid);
            map.put("session_key",session_key);
            if(wechatDAO.ifExist(new XLF_Wechat(openid)).size() == 0){
                //新建用户信息表
                XLF_User xu = new XLF_User();
                xu.setUser_school_id(INIT_SCHOOL);
                xu.setUser_role(1);
                xu.setUser_sex(1);
                userDAO.insertAndGetId(xu);
                //插入微信登录表
                XLF_Wechat we = new XLF_Wechat();
                we.setOpenid(openid);
                we.setUser_id(xu.getId());
                commonDAO.add(CommonUtils.add(we));
            }
            redisTemplate.opsForHash().putAll("wechat:"+trd_sessionid,map);
            redisTemplate.expire(trd_sessionid,SESSION_TIME, TimeUnit.DAYS);
            return trd_sessionid;
        }
    }


//    public String WeChatLogin(String code) {
//        String app_url = url.replace("APPID",appid).replace("SECRET",app_se).replace("JSCODE",code);
//        JSONObject resultJSON = JSONObject.fromObject(RequestUtils.httpRequest(app_url));
//        if(resultJSON.containsKey("errcode")){
//            return "error";
//        }
//        else {
//            String openid = resultJSON.getString("openid");
//            String session_key = resultJSON.getString("session_key");
//            String trd_sessionid = UUIDTool.getUUID(openid+session_key);
//            Map<String,String> map = new HashMap<String, String>();
//            map.put("openid",openid);
//            map.put("session_key",session_key);
//            if(wechatDAO.ifExist(new XLF_Wechat(openid)).size() == 0){
//                commonDAO.add(CommonUtils.add(new XLF_Wechat(openid)));
//                XLF_User xu = new XLF_User();
//                xu.setUser_school_id(2567);
//                xu.setUser_role(1);
//                xu.setUser_sex(1);
//                userDAO.insertAndGetId(xu);
//                wechatDAO.updateWechat(new XLF_Wechat(0,null,null,null,0,null,null,null,xu.getId()));
//            }
//            redisTemplate.opsForHash().putAll("wechat:"+trd_sessionid,map);
//            redisTemplate.expire(trd_sessionid,SESSION_TIME, TimeUnit.DAYS);
//            return trd_sessionid;
//        }
//    }


    public Object getWechatUserInfo(XLF_Wechat we) {
        XLF_Wechat xw = wechatDAO.ifExist(we).get(0);
        Map<String, Object> u_info  = userDAO.getUser(new XLF_User(xw.getUser_id())).get(0);
        return u_info;
    }

//    public Object getWechatUserInfo(XLF_Wechat we) {
//        XLF_Wechat xw = wechatDAO.ifExist(we).get(0);
//        Map<String, Object> u_info  = null;
//        //如果该微信账号已经存在用户简介信息，直接返回
//        if (xw.getUser_id() != 0){
//            u_info = userDAO.getUser(new XLF_User(xw.getUser_id())).get(0);
//        }else {
//            //若不存在，即为首次用微信登录，创建用户信息并返回
//            XLF_User xu = new XLF_User();
//            xu.setUser_school_id(2567);
//            xu.setUser_role(1);
//            xu.setUser_sex(1);
//            userDAO.insertAndGetId(xu);
//            wechatDAO.updateWechat(new XLF_Wechat(xw.getId(),null,null,null,0,null,null,null,xu.getId()));
//            u_info = CommonUtils.objectToMap(xu);
//            u_info.put("school_name","------");
//        }
//        return u_info;
//    }


    public void updateWechatUserInfo(XLF_User user) {
        userDAO.updateUserInfo(user);
    }

    public Object updateWechat(XLF_Wechat wechat) {
        wechatDAO.updateWechat(wechat);
        return null;
    }
}
