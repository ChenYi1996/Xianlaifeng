package com.xianlaifeng.user.controller;


import com.xianlaifeng.user.entity.XLF_OAuth;
import com.xianlaifeng.user.entity.XLF_User;
import com.xianlaifeng.user.service.RedisService;
import com.xianlaifeng.user.service.UserService;
import com.xianlaifeng.utils.AjaxJSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/usc")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RedisService redisService;

    @RequestMapping(value="/testUrl.do" ,produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public Object getAllUser(@RequestParam Map<String,Object> params){
        System.out.println("test success!");
        return "test success!";
    }


    @RequestMapping(value="/WeChatlogin.do",produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public AjaxJSON WeChatlogin(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        AjaxJSON res = new AjaxJSON();
        try{
            if(trd_session != null){
                String result = redisService.checkWeChatLogin(trd_session);
                res.setMsg(result.equals("Logined")?"Login":"no Login");
                res.setSuccess(result.equals("Logined")?true:false);
            }
            else{
                String code = (String)params.get("code");
                String result = userService.WeChatLogin(code);
                Map<String,Object> map = new HashMap<String, Object>();
                res.setSuccess(result.equals("error")?false:true);
                map.put("trd_session",result.equals("error")?null:result);
                res.setObj(map);
            }

        }catch (Exception e){
            res.setSuccess(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }


    @RequestMapping(value="/getWeChatUserInfo.do",produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public AjaxJSON getWeChatUserInfo(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        AjaxJSON res = new AjaxJSON();
        try {
            String openid = redisService.getOpenid(trd_session);
            XLF_User u = (XLF_User)userService.getUserInfo(new XLF_OAuth("wechat",openid));
            res.setObj(u);
            res.setSuccess(u==null?false:true);
            res.setMsg(u==null?"用户首次登陆微信端":"success");
        }catch (Exception e){
            res.setSuccess(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }


}
