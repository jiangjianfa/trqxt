package com.lsnu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Api(tags = "sljkr")
public class UserController {

    @GetMapping(value = "/index")
    public String index(){
        System.out.println("==============");
        return "user/index";
    }

    @PostMapping(value = "userinfo")
    public String  userInfo(){
        return "user_info";
    }
}
