package com.xianlaifeng.act.controller;


import com.github.pagehelper.PageInfo;
import com.xianlaifeng.act.entity.XLF_Activity;
import com.xianlaifeng.act.entity.XLF_Join_Act;
import com.xianlaifeng.act.service.ActivityService;
import com.xianlaifeng.act.service.JoinActService;
import com.xianlaifeng.user.entity.XLF_User;
import com.xianlaifeng.user.entity.XLF_Wechat;
import com.xianlaifeng.user.service.UserService;
import com.xianlaifeng.utils.AjaxJSON;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/atc")
public class ActivityController {

    @Resource
    private HttpServletRequest request;

    @Resource
    private ActivityService activityService;

    @Resource
    private UserService userService;

    @Resource
    private JoinActService joinActService;



    //显示活动具体信息接口
    @RequestMapping(value="/getActDetails.do",produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public AjaxJSON getActDetails(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        String id = (String)params.get("id");
        AjaxJSON res = new AjaxJSON();
        try {
            Map<String,Object> resultMap = activityService.getActivityDetails(id==null?0:Integer.parseInt(id));
            //用户查看过的信息收集
            if(trd_session!=null){

            }
            res.setObj(resultMap);
            res.setSuccess(resultMap==null?false:true);
        }catch (Exception e){
            res.setSuccess(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }


    //显示活动列表接口
    @RequestMapping(value="/getActShow.do",produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public AjaxJSON getActShow(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax){
        String trd_session = (String)params.get("trd_session");
        String pageNum = (String)params.get("pageNum");
        String pageSize = (String)params.get("pageSize");
        AjaxJSON res = new AjaxJSON();
        try {
            pageNum = pageNum == null?"0":pageNum;
            pageSize = pageSize == null?"0":pageSize;
            XLF_Activity activity = (XLF_Activity) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XLF_Activity.class);
            //用户查看过的信息收集
            if(trd_session!=null){

            }
            PageInfo<XLF_Activity> p_list = activityService.getActivityShow(activity,Integer.parseInt(pageNum),Integer.parseInt(pageSize));
            res.setObj(p_list.getList());
            res.setTotal(p_list.getTotal());
            res.setSuccess(true);
        }catch (Exception e){
            res.setSuccess(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }


    //用户微信端发布活动接口
    @RequestMapping(value="/insertActWechat.do",produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public AjaxJSON insertActWechat(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax){
        AjaxJSON res = new AjaxJSON();
        try {
            String openid =(String)request.getAttribute("openid");
            Map<String, Object> u_info = (Map<String, Object>)userService.getWechatUserInfo(new XLF_Wechat(openid));

            //用户信息检查
            if(u_info.get("user_phone")==null||u_info.get("user_name")==null||u_info.get("user_phone").equals("")||u_info.get("user_name").equals("")){
                res.setSuccess(false);
                res.setMsg("请完善用户信息");
            }
            else {
                XLF_Activity activity = (XLF_Activity) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XLF_Activity.class);
                activity.setActivityCreateUser((Integer) u_info.get("id"));
                activity.setActivityCreateTime(new Date());
                activityService.insertActivity(activity);
            }
        }catch (Exception e){
            res.setSuccess(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }


    //修改活动接口
    @RequestMapping(value="/updateActWechat.do",produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public AjaxJSON updateActWechat(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax){
        AjaxJSON res = new AjaxJSON();
        try {
            XLF_Activity activity = (XLF_Activity) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XLF_Activity.class);
            activityService.updateActivity(activity);
            res.setObj(activityService.getActivityDetails(activity.getId()));
            res.setSuccess(true);
        }catch (Exception e){
            res.setSuccess(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }






}
