package com.xianlaifeng.sys.controller;

import com.github.pagehelper.StringUtil;
import com.xianlaifeng.sys.entity.XlfArea;
import com.xianlaifeng.sys.service.Impl.XlfAreaServiceImpl;
import com.xianlaifeng.utils.AjaxJSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/area")
public class XlfAreaController {

    @Resource
    private XlfAreaServiceImpl xlfAreaServiceImpl;

    @RequestMapping(value="/selectArea.do",produces = "application/json",method = RequestMethod.GET)
    @ResponseBody
    public AjaxJSON selectArea(@RequestParam Map<String,Object> param){
        AjaxJSON json=new AjaxJSON();
        String city=(String)param.get("city");
        if(StringUtil.isEmpty(city)){
            json.setSuccess(false);
            json.setMsg("city字段为空");
            return json;
        }
        XlfArea xlfArea=new XlfArea();
        xlfArea.setCity(city);
        xlfAreaServiceImpl.selectDetails(xlfArea);

        return json;
    }

    @RequestMapping(value="/selectByCity.do" ,produces = "application/json",method = RequestMethod.GET)
    @ResponseBody
    public AjaxJSON selectCity(@RequestParam Map<String,Object> param){
        AjaxJSON json = new AjaxJSON();
        try{

        String type = (String)param.get("type"); //1:查排序好的所有区  2：查热门城市
        List<Map<String,Object>> list= new ArrayList<Map<String,Object>>();
        if("1".equals(type)){
           list = xlfAreaServiceImpl.selectByCityFirst();
        }
        if("2".equals(type)){
            list = xlfAreaServiceImpl.selectHotCity();
        }
        json.setSuccess(true);
        json.setObj(list);

        }catch (Exception e){
            json.setSuccess(false);
            json.setMsg("查询失败");
        }
        return  json;
    }
}
