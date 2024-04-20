package com.followjs.controller;

import com.followjs.entity.NowCoderData;
import com.followjs.service.NowCoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api")
public class NowCoderController {

    @Autowired
    private NowCoderService nowCoderService;

    @GetMapping
    public ModelAndView showForm() {
        return new ModelAndView("form");
    }



    @PostMapping("/nowcoder/info")
    public ModelAndView getNewCoderInfo(@RequestParam String username) throws Exception {
        NowCoderData nowCoderData = nowCoderService.getNowCoderInfo(username);
        if (nowCoderData == null) {
            nowCoderData = new NowCoderData(); // 创建一个新的对象，避免 null
        }
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("NowCodeData", nowCoderData);
        return mav;
    }
}