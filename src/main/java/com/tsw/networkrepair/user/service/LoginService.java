package com.tsw.networkrepair.user.service;

import com.tsw.networkrepair.user.Model.UserModel;
import com.tsw.networkrepair.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
@Service
public class LoginService {

    @Autowired
    UserDao userDao;

    public UserModel login(String username, String password){
        Assert.notNull(username,"用户名不能为空");
        Assert.notNull(password,"密码不能为空");
        return userDao.login(username,password);

    }
}
