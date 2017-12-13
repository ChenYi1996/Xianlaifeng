package com.xianlaifeng.user.controller;

import com.xianlaifeng.user.service.RedisService;
import com.xianlaifeng.utils.AjaxJSON;
import com.xianlaifeng.utils.QueueList;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/shc")
public class SearchHistoryController {

    @Resource
    private RedisService redisService;

    @RequestMapping(value = "/getSearch.do" ,produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public Object getUserSerach(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        String method = (String)params.get("method");
        AjaxJSON aj = new AjaxJSON();
        try {
            String search = redisService.getSearch(trd_session,method);
            QueueList q = new QueueList();
            if(!StringUtils.isEmpty(search)) {
                q.setList(search);
            }
            aj.setObj(StringUtils.strip(q.getList().toString(),"[]"));
            aj.setSuccess(true);
            aj.setMsg("查询搜索记录成功");
        }catch (Exception e){
            aj.setSuccess(false);
            aj.setMsg(e.getMessage());
            return aj;
        }
        return aj;
    }



}
