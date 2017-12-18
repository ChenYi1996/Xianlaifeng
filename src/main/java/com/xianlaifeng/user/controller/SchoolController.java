package com.xianlaifeng.user.controller;


import com.github.pagehelper.PageInfo;
import com.xianlaifeng.user.entity.XLF_School;
import com.xianlaifeng.user.service.SchoolService;
import com.xianlaifeng.utils.AjaxJSON;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sc")
public class SchoolController {

    @Resource
    private SchoolService schoolService;



    @RequestMapping(value="/getSchool.do",produces="application/json" ,method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public AjaxJSON getSchool(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax){
        AjaxJSON res = new AjaxJSON();
        String pageNum = (String)params.get("pageNum");
        String pageSize = (String)params.get("pageSize");
        try{
            XLF_School school = (XLF_School) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XLF_School.class);
            school.setSchool_name(school.getSchool_name().replace(" ",""));
            pageNum = pageNum == null?"0":pageNum;
            pageSize = pageSize == null?"0":pageSize;
            List<String> name_list = new ArrayList<String>();
            if(!StringUtils.isEmpty(school.getSchool_name())){
                String[] ss = school.getSchool_name().split("");
                for(String str:ss){
                    if(str != null && !str.equals("")){
                        name_list.add(str);
                    }
                }
            }
            school.setSchool_string(name_list);
            PageInfo<XLF_School> schoolPageInfo = schoolService.getSchool(school,Integer.parseInt(pageNum),Integer.parseInt(pageSize));
            res.setObj(schoolPageInfo.getList());
            res.setTotal(schoolPageInfo.getTotal());
            res.setSuccess(true);
        }catch (Exception e){
            res.setSuccess(false);
            res.setMsg(e.getMessage());
        }
        return res;
    }
}
