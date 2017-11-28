package com.xianlaifeng.act.controller;

import com.xianlaifeng.act.entity.XLF_Activity;
import com.xianlaifeng.act.entity.XLF_Join_Act;
import com.xianlaifeng.act.service.ActivityService;
import com.xianlaifeng.act.service.JoinActService;
import com.xianlaifeng.user.entity.XLF_Wechat;
import com.xianlaifeng.user.service.UserService;
import com.xianlaifeng.utils.AjaxJSON;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
@RequestMapping("/jac")
public class JoinActController {


    @Resource
    private HttpServletRequest request;

    @Resource
    private ActivityService activityService;

    @Resource
    private UserService userService;

    @Resource
    private JoinActService joinActService;


    //用户报名接口
    @RequestMapping(value="/joinAct.do",produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public AjaxJSON joinActivity(@RequestParam Map<String,Object> params){
        AjaxJSON res = new AjaxJSON();
        try {
            String openid =(String)request.getAttribute("openid");
            String actId =(String)params.get("actId");
            Map<String, Object> u_info = (Map<String, Object>)userService.getWechatUserInfo(new XLF_Wechat(openid));

            //用户信息检查
            if(u_info.get("user_phone")==null||u_info.get("user_name")==null||u_info.get("user_phone").equals("")||u_info.get("user_name").equals("")){
                res.setSuccess(false);
                res.setMsg("请完善用户信息");
            }
            else {
                XLF_Join_Act join_act = new XLF_Join_Act();
                join_act.setUserId((Integer) u_info.get("id"));
                join_act.setActId(Integer.parseInt(actId));
                joinActService.joinAct(join_act);
                res.setSuccess(true);
            }
        }catch (Exception e){
            res.setSuccess(false);
            res.setMsg(e.toString());
        }
        return res;
    }


    //查看用户报名接口
    @RequestMapping(value="/joinActShow.do",produces="application/json" ,method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public AjaxJSON joinActivityShow(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax){
        AjaxJSON res = new AjaxJSON();
        String pageNum = (String)params.get("pageNum");
        String pageSize = (String)params.get("pageSize");
        try {
            XLF_Join_Act join_act = (XLF_Join_Act) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XLF_Join_Act.class);
            pageNum = pageNum == null?"0":pageNum;
            pageSize = pageSize == null?"0":pageSize;

        }catch (Exception e){
            res.setSuccess(false);
            res.setMsg(e.toString());
        }
        return res;
    }

}
