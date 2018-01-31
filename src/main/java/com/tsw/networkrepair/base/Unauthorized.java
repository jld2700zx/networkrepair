package com.tsw.networkrepair.base;

import com.tsw.networkrepair.user.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Unauthorized {

    @Autowired
    LoginController login;

    public void unauthorized(HttpServletRequest request){
        if (request.getSession().getAttribute("username") == null){
            ModelMap map =new ModelMap();
            String message = "非法界面，请先登陆";
            map.put("message",message);
            login.login();
        }else {
            return;
        }
    }
}
