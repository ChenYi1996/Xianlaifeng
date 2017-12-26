package com.xianlaifeng.sys.service.Impl;

import com.xianlaifeng.sys.dao.PicDAO;
import com.xianlaifeng.sys.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("picService")
public class PicServiceImpl implements PicService {


    @Resource
    private PicDAO picDAO;

    public List<String> getActPicList() {
        return picDAO.getActPicList();
    }

    public List<String> getUserPicList() {
        return picDAO.getUserPicList();
    }


    public List<Map<String, Object>> getActPic() {
        List<String> types = picDAO.getActPicType();
        List<Map<String,Object>> pics = picDAO.getActPic();
        List<Map<String,Object>> return_list = new ArrayList<Map<String,Object>>();
        for(String type:types)
        {
            Map<String,Object> type_list_map = new HashMap<String,Object>();
            List<Map<String,Object>> pic_list = new ArrayList<Map<String,Object>>();
            for (Map<String,Object> m:pics){
                if(m.get("typeName").equals(type)){
                    Map<String,Object> map = new HashMap<String,Object>();
                    map.put("pic",m.get("picName"));
                    pic_list.add(map);
                }
            }
            type_list_map.put("picType",""+type);
            if(pic_list.size()!=0){
                type_list_map.put("picList",pic_list);
            }
            return_list.add(type_list_map);
        }
        return return_list;
    }
}
