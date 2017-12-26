package com.xianlaifeng.user.controller;


import com.github.pagehelper.PageInfo;
import com.xianlaifeng.join.entity.XLF_Join;
import com.xianlaifeng.user.entity.XLF_Collection;
import com.xianlaifeng.user.entity.XLF_Wechat;
import com.xianlaifeng.user.service.CollectionService;
import com.xianlaifeng.user.service.RedisService;
import com.xianlaifeng.user.service.UserService;
import com.xianlaifeng.utils.AjaxJSON;
import com.xianlaifeng.utils.QueueList;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cc")
public class CollectionController {

    @Resource
    private CollectionService collectionService;

    @Resource
    private RedisService redisService;

    @Resource
    private HttpServletRequest request;

    @Resource
    private UserService userService;


    @RequestMapping(value = "/getCollection.do" ,produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public Object getUserCollection(@RequestParam Map<String,Object> params){
        String method = (String)params.get("method");
        AjaxJSON aj = new AjaxJSON();
        try {
            String openid =(String)request.getAttribute("openid");
            aj.setSuccess(true);
            aj.setMsg("查询收藏记录成功");
        }catch (Exception e){
            aj.setSuccess(false);
            aj.setMsg(e.getMessage());
            return aj;
        }
        return aj;
    }


    @RequestMapping(value = "/addCollection.do" ,produces="application/json" ,method ={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object addUserCollection(@RequestParam Map<String,Object> params, @RequestBody AjaxJSON ajax){
        AjaxJSON aj = new AjaxJSON();
        try {
            String openid =(String)request.getAttribute("openid");
            Map<String, Object> u_info = (Map<String, Object>)userService.getWechatUserInfo(new XLF_Wechat(openid));
            XLF_Collection collection = (XLF_Collection) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XLF_Collection.class);
            collection.setUserId((Integer) u_info.get("id"));
            String result = collectionService.addCollection(collection);
            aj.setMsg(result.equals("success")?"收藏成功":result);
            aj.setSuccess(result.equals("success")?true:false);
        }catch (Exception e){
            aj.setSuccess(false);
            aj.setMsg(e.getMessage());
            return aj;
        }
        return aj;
    }


    //取消个人收藏
    @RequestMapping(value = "/delCollection.do" ,produces="application/json" ,method ={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object delCollection(@RequestParam Map<String,Object> params, @RequestBody AjaxJSON ajax){
        AjaxJSON aj = new AjaxJSON();
        String get = (String)params.get("get");
        try {
            String openid =(String)request.getAttribute("openid");
            Map<String, Object> u_info = (Map<String, Object>)userService.getWechatUserInfo(new XLF_Wechat(openid));
            XLF_Collection collection = (XLF_Collection) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XLF_Collection.class);
            collection.setUserId((Integer) u_info.get("id"));
            String result = collectionService.delCollection(collection);
            if(!StringUtils.isEmpty(get)&&get.equals("1")){
                PageInfo<Map<String,Object>> p_list = collectionService.getMyCollection(collection,Integer.parseInt("0"),Integer.parseInt("0"));
                aj.setObj(p_list.getList());
                aj.setTotal(p_list.getTotal());
            }
            aj.setMsg(result.equals("success")?"删除成功":"删除失败");
            aj.setSuccess(result.equals("success")?true:false);
        }catch (Exception e){
            aj.setSuccess(false);
            aj.setMsg(e.getMessage());
            return aj;
        }
        return aj;
    }

    //用户获取个人收藏列表接口
    @RequestMapping(value = "/getMyCollection.do" ,produces="application/json" ,method ={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object getMyCollection(@RequestParam Map<String,Object> params, @RequestBody AjaxJSON ajax){
        AjaxJSON aj = new AjaxJSON();
        String pageNum = (String)params.get("pageNum");
        String pageSize = (String)params.get("pageSize");
        try {
            pageNum = pageNum == null?"0":pageNum;
            pageSize = pageSize == null?"0":pageSize;
            String openid =(String)request.getAttribute("openid");
            Map<String, Object> u_info = (Map<String, Object>)userService.getWechatUserInfo(new XLF_Wechat(openid));
            XLF_Collection collection = (XLF_Collection) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XLF_Collection.class);
            collection.setUserId((Integer) u_info.get("id"));
            PageInfo<Map<String,Object>> p_list = collectionService.getMyCollection(collection,Integer.parseInt(pageNum),Integer.parseInt(pageSize));
            aj.setObj(p_list.getList());
            aj.setTotal(p_list.getTotal());
        }catch (Exception e){
            aj.setSuccess(false);
            aj.setMsg(e.getMessage());
            return aj;
        }
        return aj;
    }
}
