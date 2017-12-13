package com.xianlaifeng.sys.controller;


import com.xianlaifeng.sys.service.PicService;
import com.xianlaifeng.utils.AjaxJSON;
import com.xianlaifeng.utils.CommonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/pict")

/**
 * 负责处理图片相关的接口
 */
public class PicController {

    public static final String BASE_PATH = "/usr//local//pic//xianlaifeng//";
    public static final String BASE_HTTP_PATH = "https://www.xianlaifeng.com/img/xianlaifeng/";

    @Resource
    private PicService picService;


    //用户上传图片接口，method表示上传到哪个文件夹
    @RequestMapping(value="/uploadImg.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object uploadImg(HttpServletRequest request, HttpServletResponse response,@RequestParam Map<String,Object> params) throws IllegalStateException, IOException {
        AjaxJSON aj = new AjaxJSON();
        List<String> p_list = new ArrayList<String>();
        String method = (String)params.get("method");
        try {

            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if (multipartResolver.isMultipart(request)) {
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                Iterator<String> iter = multiRequest.getFileNames();
                while (iter.hasNext()) {
                    int time = (int) System.currentTimeMillis();
                    MultipartFile file = multiRequest.getFile(iter.next());
                    if (file != null) {
                        String myFileName = file.getOriginalFilename();
                        if (myFileName.trim() != "") {

                            //重命名上传后的文件名
                            String fileName = method +"_"+ String.valueOf(time) + CommonUtils.getRandomString(4)+"_"+file.getOriginalFilename();
                            //定义上传路径
                            String path = BASE_PATH  + method + "//" + fileName;

                            File localFile = new File(path);
                            file.transferTo(localFile);
                            p_list.add(BASE_HTTP_PATH + method + "/"+fileName);
                        }
                    }
                }
            }
            aj.setObj(StringUtils.strip(p_list.toString(),"[]"));
            aj.setSuccess(true);
            aj.setTotal((long)p_list.size());
        }catch (Exception e){
            aj.setMsg(e.getMessage());
            aj.setSuccess(false);
            return aj;
        }
        return aj;
    }

    //删除多余图片文件
    @RequestMapping(value="/delPic.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object delImg(@RequestParam Map<String,Object> params){
        AjaxJSON ajax = new AjaxJSON();
        try {
            String method = (String)params.get("method");
            List<String> pic_List_DB = method.equals("user")?picService.getUserPicList():picService.getActPicList();
            pic_List_DB.removeAll(Collections.singleton(null));

            File file = new File(BASE_PATH + method + "/");
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                if (fileList[i].isFile()) {
                    String fileName = fileList[i].getName();
                    if (!pic_List_DB.contains(fileList[i].getName())){
                        fileList[i].delete();
                    }
                }
            }
            ajax.setObj(file.listFiles());
        }catch (Exception e){
            ajax.setSuccess(false);
            ajax.setMsg(e.getMessage());
        }
        return ajax;
    }

}
