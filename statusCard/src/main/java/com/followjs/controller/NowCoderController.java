package com.followjs.controller;

import com.followjs.entity.NowCoderData;
import com.followjs.service.NowCoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class NowCoderController {

    @Autowired
    private NowCoderService nowCoderService;


    @GetMapping("/nowcoder/info/{username}")
    public NowCoderData getNewCoderInfo(@PathVariable("username") String username) throws Exception {
        NowCoderData nowCoderData = nowCoderService.getNowCoderInfo(username);
        return nowCoderData;
    }
}