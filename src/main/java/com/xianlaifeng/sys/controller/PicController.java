package com.xianlaifeng.sys.controller;


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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pict")
public class PicController {

    public static final String BASE_PATH = "/usr//local//pic//xianlaifeng//";


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
                            p_list.add(fileName);
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

}
