package com.followjs.controller;

import com.followjs.entity.NowCoderData;
import com.followjs.service.NowCoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 功能：
 * 日期：2024/4/15 上午8:19
 */
@Controller
@RequestMapping("/nowcoder")
public class NowCoderController {

    @Autowired
    private NowCoderService nowCoderService;
    @GetMapping("/info/{username}")
    public ModelAndView getNewCoderInfo(@PathVariable String username) throws Exception {

//        NowCoderData leetCodeData = NowCoderService.get;
        // 返回一个index,html显示leetcodeDate的信息
        NowCoderData nowCoderData = nowCoderService.getNowCoderInfo(username);
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("data1", nowCoderData);
        return mav;

    }

}