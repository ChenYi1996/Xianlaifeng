package com.xianlaifeng.join.controller;


import com.github.pagehelper.PageInfo;
import com.xianlaifeng.join.entity.XLF_Join;
import com.xianlaifeng.join.service.JoinService;
import com.xianlaifeng.user.entity.XLF_Wechat;
import com.xianlaifeng.user.service.UserService;
import com.xianlaifeng.utils.AjaxJSON;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;


@Controller
@RequestMapping("/jct")
public class JoinController {


    @Resource
    private HttpServletRequest request;

    @Resource
    private UserService userService;

    @Resource
    private JoinService joinService;


    //增加报名记录接口
    @RequestMapping(value="/add.do",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json")
    @ResponseBody
    public AjaxJSON addJoin(@RequestParam Map<String,Object> params, @RequestBody AjaxJSON ajax){
        AjaxJSON res = new AjaxJSON();
        try{
            String openid =(String)request.getAttribute("openid");
            Map<String, Object> u_info = (Map<String, Object>)userService.getWechatUserInfo(new XLF_Wechat(openid));
            //用户信息检查
            if(u_info.get("user_phone")==null||u_info.get("user_name")==null||u_info.get("user_phone").equals("")||u_info.get("user_name").equals("")){
                res.setSuccess(false);
                res.setMsg("请完善用户信息再进行报名");
                return res;
            }
            JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd HH:mm:ss"}) );
            XLF_Join join = (XLF_Join) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XLF_Join.class);
            //System.out.println(join.getJoinTime());
            if((join.getJoinTime().compareTo(new Date()))!=1){
                res.setSuccess(false);
                res.setMsg("活动已结束报名");
                return res;
            }
            join.setJoinTime(null);
            join.setUserId((Integer) u_info.get("id"));
            String result = joinService.addJoin(join);
            res.setMsg(result);
            res.setSuccess(result.equals("success")?true:false);

        }
        catch (Exception e){
            res.setSuccess(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }


    //查看个人报名记录接口
    @RequestMapping(value="/getMyJoin.do",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json")
    @ResponseBody
    public AjaxJSON getMyJoin(@RequestParam Map<String,Object> params, @RequestBody AjaxJSON ajax){
        AjaxJSON res = new AjaxJSON();
        String pageNum = (String)params.get("pageNum");
        String pageSize = (String)params.get("pageSize");
        try{
            pageNum = pageNum == null?"0":pageNum;
            pageSize = pageSize == null?"0":pageSize;
            String openid =(String)request.getAttribute("openid");
            Map<String, Object> u_info = (Map<String, Object>)userService.getWechatUserInfo(new XLF_Wechat(openid));

            XLF_Join join = (XLF_Join) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XLF_Join.class);
            join.setUserId((Integer) u_info.get("id"));

            PageInfo<Map<String,Object>> pageInfo = joinService.getMyJoin(join,Integer.parseInt(pageNum),Integer.parseInt(pageSize));
            res.setObj(pageInfo.getList());
            res.setTotal(pageInfo.getTotal());
            res.setMsg("查询成功");
            res.setSuccess(true);

        }
        catch (Exception e){
            res.setSuccess(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }


    //查看报名用户接口
    @RequestMapping(value="/getJoinUser.do",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json")
    @ResponseBody
    public AjaxJSON getJoinUser(@RequestParam Map<String,Object> params, @RequestBody AjaxJSON ajax){
        AjaxJSON res = new AjaxJSON();
        String pageNum = (String)params.get("pageNum");
        String pageSize = (String)params.get("pageSize");
        try{
            pageNum = pageNum == null?"0":pageNum;
            pageSize = pageSize == null?"0":pageSize;
            XLF_Join join = (XLF_Join) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XLF_Join.class);

            PageInfo<Map<String,Object>> pageInfo = joinService.getJoinUser(join,Integer.parseInt(pageNum),Integer.parseInt(pageSize));
            res.setObj(pageInfo.getList());
            res.setTotal(pageInfo.getTotal());
            res.setMsg("查询成功");
            res.setSuccess(true);
        }
        catch (Exception e){
            res.setSuccess(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }


}
