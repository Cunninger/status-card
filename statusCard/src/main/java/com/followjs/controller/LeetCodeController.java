package com.followjs.controller;

import com.followjs.entity.LeetCodeData;
import com.followjs.service.LeetCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api")
public class LeetCodeController {

    @Autowired
    private LeetCodeService leetCodeService;

    @GetMapping("/leetcode")
    public ModelAndView showForm() {
        return new ModelAndView("form");
    }
//@PathVariable @RequestParam
    @GetMapping("/leetcode/info")
    public ModelAndView getLeetCodeInfo(@RequestParam String username) {
        LeetCodeData leetCodeData = leetCodeService.getLeetCodeInfo(username);
        if (leetCodeData == null) {
            leetCodeData = new LeetCodeData(); // 创建一个新的对象，避免 null
        }
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("leetCodeData", leetCodeData);
        return mav;
    }
}