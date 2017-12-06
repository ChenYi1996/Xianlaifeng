package com.xianlaifeng.ptj.controller;

import com.github.pagehelper.PageInfo;
import com.xianlaifeng.ptj.entity.XlfPartTimeJob;
import com.xianlaifeng.ptj.entity.XlfPtjType;
import com.xianlaifeng.ptj.service.Impl.XlfPartTimeJobServiceImpl;
import com.xianlaifeng.ptj.service.Impl.XlfPtjTypeServiceImpl;
import com.xianlaifeng.sys.entity.XlfArea;
import com.xianlaifeng.sys.service.Impl.XlfAreaServiceImpl;
import com.xianlaifeng.utils.AjaxJSON;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ptj")
public class XlfPartTimeJobController {

    @Resource
    private XlfPartTimeJobServiceImpl xlfPartTimeJobServiceImpl;

    @Resource
    private XlfAreaServiceImpl xlfAreaServiceImpl;

    @Resource
    private XlfPtjTypeServiceImpl xlfPtjTypeServiceImpl;

    /**
     添加兼职信息
     lbk
     */
    @RequestMapping(value="/add.do",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json")
    @ResponseBody
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
    @RequestMapping(value = "/findList.do", produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public AjaxJSON findList(@RequestParam Map<String, Object> param, @RequestBody AjaxJSON ajax) {
        AjaxJSON json =new AjaxJSON();
        try{
            String pageNum = (String)param.get("pageNum");
            String pageSize = (String)param.get("pageSize");
            String areaId = (String) param.get("areaId");
            String jobTypeId = (String)param.get("jobTypeId");
            String timeType =(String)param.get("timeType");
            XlfPartTimeJob xlfPartTimeJob =new XlfPartTimeJob();
            if(null != areaId ){ //区域多选
                List<Integer> intAreaList = new ArrayList<Integer>();
                for(int i=0; i<Arrays.asList(areaId.split(",")).size();i++){
                    intAreaList.add(Integer.valueOf(Arrays.asList(areaId.split(",")).get(i)));
                }

                xlfPartTimeJob.setAreaIds(intAreaList);
            }
            if(null != jobTypeId){//兼职类型多选
               xlfPartTimeJob.setJobTypeIds(Arrays.asList(jobTypeId.split(",")));
            }
            if(null != timeType){//时间类型多选
                xlfPartTimeJob.setTimeTypes(Arrays.asList(timeType.split(",")));
            }
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

    @RequestMapping(value="/details.do",produces="application/json",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public AjaxJSON details(@RequestParam Map<String,Object>param,@RequestBody AjaxJSON ajax){
        AjaxJSON json=new AjaxJSON();
        try{
            List<Map<String,Object>> list=xlfPartTimeJobServiceImpl.selectDetails((String)param.get("jobId"));
            json.setObj(list.get(0));
            json.setSuccess(true);
        }catch(Exception e){
            json.setSuccess(false);
            json.setMsg("查询失败");
        }
        return json;
    }

    @RequestMapping(value="/getALLPtjType.do",produces="application/json",method= RequestMethod.GET)
    @ResponseBody
    public AjaxJSON getAllPtjType(@RequestParam Map<String,Object>param){
        AjaxJSON json=new AjaxJSON();
        try{
          List<Map<String,Object>> typeList=xlfPtjTypeServiceImpl.selectAll();
          json.setObj(typeList);
          json.setSuccess(true);
        }catch(Exception e){
            json.setSuccess(false);
            json.setMsg("查询失败");
        }
        return json;
    }

}
