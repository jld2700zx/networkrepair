package com.tsw.networkrepair.user;

import com.tsw.networkrepair.base.Unauthorized;
import com.tsw.networkrepair.user.Model.UserModel;
import com.tsw.networkrepair.user.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.net.util.IPAddressUtil;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends Unauthorized {
    private int level;
    @Autowired
    UserService userService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/insert")
    @ResponseBody
    public String insertInfo(@RequestBody UserModel userModel,ModelMap map){
        int level = (int) request.getSession().getAttribute("level");
        if (level == 1){
            String  authmessage = "你没有权限";
            map.put("authmessage",authmessage);
            return "index";
        }else {
            userModel.setIp(request.getRemoteAddr());
            userModel.setCreate_dt(new Date());
            userModel.setLast_dt(new Date());
            userService.insertInfo(userModel);
            return "success";
        }
    }

    @RequestMapping("/selectall")
    public List<UserModel> selectAll(@RequestBody UserModel userModel){
      List<UserModel> a =  userService.selectAll(userModel);
      return a;
    }

    @RequestMapping("/update")
    @ResponseBody
    public String upDateInfo(@RequestBody UserModel userModel,ModelMap map){
        int level = (int) request.getSession().getAttribute("level");
        if (level == 1){
            String  authmessage = "你没有权限";
            map.put("authmessage",authmessage);
            return "index";
        }else {
          UserModel userModel1 =  this.selectById(userModel.getId());
            map.put("username",userModel1.getUsername());
            map.put("password",userModel1.getPassword());
            map.put("level",userModel1.getLevel());
            userModel.setIp(request.getRemoteAddr());
            userModel.setCreate_dt(new Date());
            userModel.setLast_dt(new Date());
            userService.upDateInfo(userModel);
            return "success";
        }
    }

    @RequestMapping("/userdelete/{id]")
    @ResponseBody
    public String deleteInfo(@PathVariable Integer id, ModelMap map){
        int level = (int) request.getSession().getAttribute("level");
        if (level == 1) {
            String authmessage = "你没有权限";
            map.put("authmessage", authmessage);
            return "index";
        }
        try {
            userService.deleteInfo(id);
            return "success";
        }catch (Exception e){
            map.put("message",e.getMessage());
        }
            return "index";
    }

    @RequestMapping(value ="/selectbyname/{name}", method=RequestMethod.POST)
    public List<UserModel> selectUserByName(@PathVariable String name,ModelMap map) throws Exception {
       List<UserModel> allname = userService.selectUserByName(name);
       return allname;
    }

    @RequestMapping(value = "/selectbyid/{id}")
    public UserModel selectById(@PathVariable int id){
       return userService.selectById(id);
    }

}
