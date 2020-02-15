package com.lsnu.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Api(value = "srs")
public class tableController {
    @RequestMapping(value = "table")
    public String toTable(ModelAndView model){
        return "index";
    }
}
