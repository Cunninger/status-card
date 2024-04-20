package com.followjs.controller;

import com.followjs.entity.LeetCodeData;
import com.followjs.entity.NowCoderData;
import com.followjs.service.LeetCodeService;
import com.followjs.service.NowCoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 功能：
 * 日期：2024/4/18 上午10:28
 */
@Controller
@RequestMapping("/user")
public class BaseControlller {

    @Autowired
    private LeetCodeService leetCodeService;
    @Autowired
    private NowCoderService nowCoderService;

    @PostMapping("/info")
    public ModelAndView getInfo(@RequestParam String username) throws Exception {
        System.out.println("hello");
        LeetCodeData leetCodeData = leetCodeService.getLeetCodeInfo(username);
        NowCoderData nowCoderData = nowCoderService.getNowCoderInfo(username);

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("LeetCodeData", leetCodeData);
        mav.addObject("NowCodeData", nowCoderData);
        return mav;
    }



}