package com.xianlaifeng.service.impl;

import com.xianlaifeng.DAO.UserDAO;
import com.xianlaifeng.model.T_B_User;
import com.xianlaifeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;


    public List<T_B_User> findAllUser() {
        return userDAO.getAllUser();
    }
}
