package com.xianlaifeng.user.controller;


import com.xianlaifeng.user.entity.XLF_School;
import com.xianlaifeng.user.entity.XLF_User;
import com.xianlaifeng.user.entity.XLF_Wechat;
import com.xianlaifeng.user.service.RedisService;
import com.xianlaifeng.user.service.UserService;
import com.xianlaifeng.utils.AjaxJSON;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/usc")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RedisService redisService;

    @Resource
    private HttpServletRequest request;


    @RequestMapping(value="/WeChatlogin.do",produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public AjaxJSON WeChatlogin(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        AjaxJSON res = new AjaxJSON();
        try{
            if(trd_session != null){
                String result = redisService.checkWeChatLogin(trd_session);
                res.setMsg(result.equals("Logined")?"Login":"noLogin");
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
            String openid =(String)request.getAttribute("openid");
            Map<String, Object> u_info = (Map<String, Object>)userService.getWechatUserInfo(new XLF_Wechat(openid));
            res.setObj(u_info);
            res.setSuccess(u_info==null?false:true);
        }catch (Exception e){
            res.setSuccess(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }


    //更新用户信息
    @RequestMapping(value="/updateWeChatUserInfo.do",produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public AjaxJSON updateWeChatUserInfo(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax){
        AjaxJSON res = new AjaxJSON();
        try {
            XLF_User user = (XLF_User) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XLF_User.class);
            userService.updateWechatUserInfo(user);
            res.setSuccess(true);
        }catch (Exception e){
            res.setSuccess(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }


    //更新微信信息
    @RequestMapping(value="/updateWeChat.do",produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public AjaxJSON updateWeChat(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax){
        AjaxJSON res = new AjaxJSON();
        try {
            String openid =(String)request.getAttribute("openid");
            XLF_Wechat wechat = (XLF_Wechat) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XLF_Wechat.class);
            wechat.setOpenid(openid);
            userService.updateWechat(wechat);
            res.setSuccess(true);
        }catch (Exception e){
            res.setSuccess(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }


}
