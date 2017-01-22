package com.daimamiao.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xcc on 1/22/2017.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "home";
    }
}
