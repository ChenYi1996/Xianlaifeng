package com.xianlaifeng.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xianlaifeng.sys.dao.CommonDAO;
import com.xianlaifeng.user.dao.CollectionDAO;
import com.xianlaifeng.user.dao.UserDAO;
import com.xianlaifeng.user.entity.XLF_Collection;
import com.xianlaifeng.user.entity.XLF_School;
import com.xianlaifeng.user.entity.XLF_Wechat;
import com.xianlaifeng.user.service.CollectionService;
import com.xianlaifeng.user.service.RedisService;
import com.xianlaifeng.user.service.UserService;
import com.xianlaifeng.utils.CommonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("collectionService")
public class CollectionServiceImpl implements CollectionService {


    @Autowired
    private CommonDAO commonDAO;

    @Autowired
    private CollectionDAO collectionDAO;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    public String addCollection(XLF_Collection collection) {
        if (collectionDAO.ifExist(collection).size()==0){
            commonDAO.add(CommonUtils.add(collection));
            return "success";
        }else {
            return "已经收藏";
        }
    }

    public int ifCollection(String trd_session ,int methodId,int actId) {
        String openid = redisService.getOpenid(trd_session);
        int collect = 0;
        if(!StringUtils.isEmpty(openid)){
            Map<String, Object> u_info = (Map<String, Object>)userService.getWechatUserInfo(new XLF_Wechat(openid));
            XLF_Collection collection = new XLF_Collection(methodId,actId,(Integer) u_info.get("id"));
            collect = collectionDAO.ifExist(collection).size();
        }
        return collect;
    }

    public String delCollection(XLF_Collection collection) {
        collectionDAO.delCollection(collection);
        return "success";
    }

    public PageInfo<Map<String, Object>> getMyCollection(XLF_Collection collection, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Map<String, Object>> p_list = new PageInfo<Map<String, Object>>(collectionDAO.getUserCollection(collection));
        return p_list;
    }
}
