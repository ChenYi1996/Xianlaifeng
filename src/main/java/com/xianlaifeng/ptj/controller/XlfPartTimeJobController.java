package com.xianlaifeng.ptj.controller;

import com.xianlaifeng.ptj.entity.XlfPartTimeJob;
import com.xianlaifeng.ptj.service.XlfPartTimeJobService;
import com.xianlaifeng.sys.entity.XlfArea;
import com.xianlaifeng.utils.AjaxJSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/ptj")
public class XlfPartTimeJobController {

    @Resource
    private XlfPartTimeJobService xlfPartTimeJobService;

    /*
        添加接口
        lbk
     */
    @RequestMapping(value="add.do",method = RequestMethod.GET,produces = "application/json")
    public AjaxJSON add(@RequestParam Map<String,Object> param){
        AjaxJSON json=new AjaxJSON();
        XlfPartTimeJob xlfPartTimeJob=(XlfPartTimeJob) param.get("XlfPartTimeJob");
        if(xlfPartTimeJob == null){
            json.setSuccess(false);
            json.setMsg("兼职信息为空");
            return json;
        }
        xlfPartTimeJobService.add(xlfPartTimeJob);
        return  json;
    }
}
