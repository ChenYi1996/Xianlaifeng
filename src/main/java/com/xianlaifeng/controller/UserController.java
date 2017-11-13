package com.xianlaifeng.controller;

import com.xianlaifeng.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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



}
