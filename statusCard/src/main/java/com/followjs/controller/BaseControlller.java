package com.followjs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 功能：
 * 日期：2024/4/18 上午10:28
 */
@Controller
@RequestMapping("/user")
public class BaseControlller {
    @GetMapping("/info")
    public ModelAndView getUserInfo() {
        System.out.println("hello");
        return new ModelAndView("base");
    }

}