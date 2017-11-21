package com.xianlaifeng.ptj.controller;

import com.github.pagehelper.PageInfo;
import com.xianlaifeng.ptj.entity.XlfPartTimeJob;
import com.xianlaifeng.ptj.service.Impl.XlfPartTimeJobServiceImpl;
import com.xianlaifeng.sys.entity.XlfArea;
import com.xianlaifeng.sys.service.Impl.XlfAreaServiceImpl;
import com.xianlaifeng.utils.AjaxJSON;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/ptj")
public class XlfPartTimeJobController {

    @Resource
    private XlfPartTimeJobServiceImpl xlfPartTimeJobServiceImpl;

    @Resource
    private XlfAreaServiceImpl xlfAreaServiceImpl;

    /**
     添加兼职信息
     lbk
     */
    @RequestMapping(value="add.do",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json")
    public AjaxJSON add(@RequestParam Map<String,Object> param,@RequestBody AjaxJSON ajax){
        AjaxJSON json=new AjaxJSON();
        try {
            XlfPartTimeJob xlfPartTimeJob = (XlfPartTimeJob) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XlfPartTimeJob.class);
            //查询areaId 添加到兼职信息
            XlfArea xlfArea = (XlfArea) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XlfArea.class);
//            xlfArea = xlfAreaService.selectDetails(xlfArea);
//            xlfPartTimeJob.setAreaId(xlfArea.getAreaId());
            //添加兼职信息
            int result = xlfPartTimeJobServiceImpl.add(xlfPartTimeJob);
            json.setSuccess(true);
            json.setMsg("添加成功");
            return json;

        }catch(Exception e) {
            json.setSuccess(false);
            json.setMsg("添加失败");
        }
        return  json;
    }

    /**
     * 兼职列表
     */
    @RequestMapping(value = "findList.do", produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public AjaxJSON findList(@RequestParam Map<String, Object> param, @RequestBody AjaxJSON ajax) {
        AjaxJSON json =new AjaxJSON();
        try{
            String pageNum = (String)param.get("pageNum");
            String pageSize = (String)param.get("pageSize");
            XlfPartTimeJob xlfPartTimeJob=(XlfPartTimeJob)JSONObject.toBean(JSONObject.fromObject(ajax.getObj()),XlfPartTimeJob.class);
            PageInfo<XlfPartTimeJob> pageInfos=xlfPartTimeJobServiceImpl.findList(xlfPartTimeJob,
                    Integer.valueOf(pageNum==null?"0":pageNum),Integer.valueOf(pageNum==null?"0":pageSize));
            json.setObj(pageInfos.getList());
            json.setSuccess(true);
        }catch(Exception e){
            json.setSuccess(false);
            json.setMsg("查询失败");
        }
        return json;
    }

    @RequestMapping(value="details.do",produces="application/json",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public AjaxJSON details(@RequestParam Map<String,Object>param,@RequestBody AjaxJSON ajax){
        AjaxJSON json=new AjaxJSON();
        try{
            XlfPartTimeJob xlfPartTimeJob=xlfPartTimeJobServiceImpl.selectDetails((String)param.get("jobId"));
            json.setObj(xlfPartTimeJob);
            json.setSuccess(true);
        }catch(Exception e){
            json.setSuccess(false);
            json.setMsg("查询失败");
        }
        return json;
    }

}
