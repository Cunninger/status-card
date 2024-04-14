package com.followjs.controller;

import com.followjs.entity.LeetCodeData;
import com.followjs.service.LeetCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;

/**
 * 功能：
 * 日期：2024/4/14 下午3:43
 */
@Controller
@RequestMapping("/leetcode")
public class LeetCodeController {

    @Autowired
    private LeetCodeService leetCodeService;
    @GetMapping("/info/{username}")
    public ModelAndView getLeetCodeInfo(@PathVariable String username) {

        LeetCodeData leetCodeData = leetCodeService.getLeetCodeInfo(username);
        // 返回一个index,html显示leetcodeDate的信息

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("data", leetCodeData);
        return mav;



    }

}