package com.xianlaifeng.controller;

import com.xianlaifeng.model.AjaxJSON;
import com.xianlaifeng.service.UserService;
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


    @RequestMapping(value="/getAllUser.do" ,produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public Object getAllUser(@RequestParam Map<String,Object> params){
        System.out.println(userService.findAllUser());
        return userService.findAllUser();
    }


    @RequestMapping(value="/WeChatlogin.do",produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public AjaxJSON WeChatlogin(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        AjaxJSON res = new AjaxJSON();
        try{
            if(trd_session != null){
                String result = userService.checkWeChatLogin(trd_session);
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


}
