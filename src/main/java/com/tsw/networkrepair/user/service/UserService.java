package com.tsw.networkrepair.user.service;

import com.github.pagehelper.PageHelper;
import com.tsw.networkrepair.base.Unauthorized;
import com.tsw.networkrepair.user.Model.UserModel;
import com.tsw.networkrepair.user.dao.UserDao;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserService extends Unauthorized {
    @Autowired
    UserDao userDao;
    @Autowired
    PageHelper pageHelper;
    @Autowired
    HttpServletRequest request;

    public List<UserModel> selectAll(UserModel userModel){
        this.unauthorized(request);
        pageHelper.startPage(1,10);
        return userDao.selectAll(userModel);
    }

    public void insertInfo(UserModel userModel){
        this.unauthorized(request);
        Assert.notNull(userModel.getUsername(),"用户名不能为空");
        Assert.notNull(userModel.getPassword(),"密码不能为空");
        Assert.notNull(userModel.getName(),"真实姓名不能为空");
        Assert.notNull(userModel.getLevel(),"等级权限不能为空");
        Assert.isNull(userDao.selectUsername(userModel.getUsername()),"此用户名已经拥有");
        userDao.insertInfo(userModel);
    }


    public void upDateInfo(UserModel userModel){
        this.unauthorized(request);
        Assert.notNull(userModel.getUsername(),"用户名不能为空");
        Assert.notNull(userModel.getPassword(),"密码不能为空");
        Assert.notNull(userModel.getName(),"真实姓名不能为空");
        Assert.notNull(userModel.getLevel(),"等级权限不能为空");
        Assert.isNull(userDao.selectUsername(userModel.getUsername()),"此用户名已经拥有");
        userDao.upDateInfo(userModel);

    }
    public void deleteInfo(int id){
        this.unauthorized(request);
        Assert.notNull(id,"id不能为空");
        userDao.deleteInfo(id);
    }

    public List<UserModel> selectUserByName(String name)  {
        this.unauthorized(request);
        Assert.notNull(name,"名字不能为空");
        return userDao.selectUserByName(name);
    }

   public UserModel selectById(int id){
        return userDao.selectById(id);
   }
}
