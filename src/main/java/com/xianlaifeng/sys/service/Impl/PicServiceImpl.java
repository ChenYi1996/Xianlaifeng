package com.xianlaifeng.sys.service.Impl;

import com.xianlaifeng.sys.dao.PicDAO;
import com.xianlaifeng.sys.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
