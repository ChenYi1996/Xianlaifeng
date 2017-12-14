package com.xianlaifeng.ptj.controller;

import com.github.pagehelper.PageInfo;

import com.xianlaifeng.ptj.entity.XlfPartTimeJob;
import com.xianlaifeng.ptj.service.Impl.XlfPartTimeJobServiceImpl;
import com.xianlaifeng.ptj.service.Impl.XlfPtjTypeServiceImpl;
import com.xianlaifeng.sys.service.Impl.XlfAreaServiceImpl;
import com.xianlaifeng.user.entity.XLF_Wechat;
import com.xianlaifeng.user.service.UserService;
import com.xianlaifeng.utils.AjaxJSON;
import com.xianlaifeng.utils.CommonUtils;
import com.xianlaifeng.utils.QueueList;
import com.xianlaifeng.utils.TimeUtil;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/ptj")
public class XlfPartTimeJobController {

    @Resource
    private XlfPartTimeJobServiceImpl xlfPartTimeJobServiceImpl;

    @Resource
    private HttpServletRequest request;

    @Resource
    private UserService userService;

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
        AjaxJSON json = new AjaxJSON();
        try{
            String openid =(String)request.getAttribute("openid");
            Map<String, Object> u_info = (Map<String, Object>)userService.getWechatUserInfo(new XLF_Wechat(openid));

            //用户信息检查
            if(u_info.get("user_phone")==null||u_info.get("user_name")==null||u_info.get("user_phone").equals("")||u_info.get("user_name").equals("")){
                json.setSuccess(false);
                json.setMsg("请完善用户信息");
                return json;
            }
            JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd HH:mm:ss"}) );
            XlfPartTimeJob xlfPartTimeJob = (XlfPartTimeJob) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XlfPartTimeJob.class);
//
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
    @RequestMapping(value="/findList.do",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json")
    @ResponseBody
    public AjaxJSON findList(@RequestParam Map<String, Object> param, @RequestBody AjaxJSON ajax) {
        AjaxJSON json =new AjaxJSON();
        try{

            JSONObject obj=JSONObject.fromObject(ajax.getObj());

            String pageNum = (String)param.get("pageNum");
            String pageSize = (String)param.get("pageSize");

            pageNum = pageNum == null?"0":pageNum;
            pageSize = pageSize == null?"0":pageSize;

            XlfPartTimeJob xlfPartTimeJob = (XlfPartTimeJob) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), XlfPartTimeJob.class);
            if(!StringUtils.isEmpty(xlfPartTimeJob.getWorkDistrict())){
                xlfPartTimeJob.setWorkDistricts(CommonUtils.setList(xlfPartTimeJob.getWorkDistrict()));
            }
            if(!StringUtils.isEmpty(xlfPartTimeJob.getJobTypeIds_String())){
                xlfPartTimeJob.setJobTypeIds(CommonUtils.setIntList(xlfPartTimeJob.getJobTypeIds_String()));
            }
            if(!StringUtils.isEmpty(xlfPartTimeJob.getTimeTypes_String())){
                xlfPartTimeJob.setTimeTypes(CommonUtils.setIntList(xlfPartTimeJob.getTimeTypes_String()));
            }

//            String workDistricts = (String)obj.get("workDistricts");
//            String jobTypeId = (String)obj.get("jobTypeId");
//            String timeType =(String)obj.get("timeType");
//            String jobName = (String)obj.get("jobName");
//            String latitude = StringUtils.isEmpty((String)obj.get("latitude"))?"0.0":(String)obj.get("latitude");
//            String longitude = StringUtils.isEmpty((String)obj.get("longitude"))?"0.0":(String)obj.get("longitude");
//            XlfPartTimeJob xlfPartTimeJob =new XlfPartTimeJob();
//            xlfPartTimeJob.setJobName(jobName);
//            xlfPartTimeJob.setLatitude(Double.parseDouble(latitude));
//            xlfPartTimeJob.setLongitude(Double.parseDouble(longitude));
//            if(StringUtils.isNotBlank(areaId)){ //区域多选
//                List<Integer> intAreaList = new ArrayList<Integer>();
//                for(int i=0; i<Arrays.asList(areaId.split(",")).size();i++){
//                    intAreaList.add(Integer.valueOf(Arrays.asList(areaId.split(",")).get(i)));
//                }
//                xlfPartTimeJob.setAreaIds(intAreaList);
//            }
//            if(StringUtils.isNotBlank(jobTypeId)){//兼职类型多选
//                List<Integer> intTypeList = new ArrayList<Integer>();
//                for(int i=0; i<Arrays.asList(jobTypeId.split(",")).size();i++){
//                    intTypeList.add(Integer.valueOf(Arrays.asList(jobTypeId.split(",")).get(i)));
//                }
//                xlfPartTimeJob.setJobTypeIds(intTypeList);
//            }
//            if(StringUtils.isNotBlank(timeType)){//时间类型多选
//                xlfPartTimeJob.setTimeTypes(Arrays.asList(timeType.split(",")));
//            }
            PageInfo<XlfPartTimeJob> pageInfos=xlfPartTimeJobServiceImpl.findList(xlfPartTimeJob,
                    Integer.valueOf(pageNum),Integer.valueOf(pageSize));
           json.setTotal(pageInfos.getTotal());
            json.setObj(pageInfos.getList());
            json.setSuccess(true);
            json.setObj(xlfPartTimeJob);
        }catch(Exception e){
            json.setSuccess(false);
            json.setMsg(e.getMessage());
        }
        return json;
    }

    /*
    兼职详情
     */
    @RequestMapping(value="/details.do",produces="application/json",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public AjaxJSON details(@RequestParam Map<String,Object>param,@RequestBody AjaxJSON ajax){
        AjaxJSON json=new AjaxJSON();
        try{
            String jobId =(String)param.get("jobId");
            List<XlfPartTimeJob> list=xlfPartTimeJobServiceImpl.selectDetails(jobId);
            if(!list.isEmpty()) {
                if (null != list.get(0).getStartWorkDate() && !"".equals(list.get(0).getStartWorkDate())
                        && null != list.get(0).getEndWorkDate() && !"".equals(list.get(0).getEndWorkDate())) {
                    int days = TimeUtil.differentDaysByMillisecond(list.get(0).getEndWorkDate(), list.get(0).getStartWorkDate());
                    list.get(0).setDays(days);
                }
                json.setObj(list.get(0));

            }else{
                json.setMsg("查询不到数据");
            }
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
