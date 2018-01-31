package com.tsw.networkrepair.user.service;

import org.springframework.web.bind.annotation.RequestMapping;

public class ShowController {

    @RequestMapping("userindex")
    public String userindex(){
        return "userindex";
    }
}
