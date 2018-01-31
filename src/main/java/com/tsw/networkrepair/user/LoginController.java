package com.tsw.networkrepair.user;

import com.tsw.networkrepair.user.Model.UserModel;
import com.tsw.networkrepair.user.service.LoginService;
import com.tsw.networkrepair.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.security.auth.Subject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    //登陆
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public  String login(@RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "password",required = false)String password,
                         ModelMap map) {
        UserModel result = loginService.login(username, password);
        if (result != null) {
            map.put("username", result.getUsername());
            map.put("level", result.getLevel());
            return "index";
        } else {
            return "login";
        }
    }

    //显示登陆界面
    @RequestMapping(value = "/showlogin",method = RequestMethod.POST)
    public String login(){
        return "login";
    }

    //登出
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "login";
    }

}
