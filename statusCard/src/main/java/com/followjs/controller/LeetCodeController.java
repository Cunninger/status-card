package com.followjs.controller;

import com.followjs.entity.LeetCodeData;
import com.followjs.service.LeetCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class LeetCodeController {

    @Autowired
    private LeetCodeService leetCodeService;

    @GetMapping("/leetcode/info/{username}")
    public LeetCodeData getLeetCodeInfo(@PathVariable("username") String username) {
        System.out.println(username);
        LeetCodeData leetCodeData = leetCodeService.getLeetCodeInfo(username);
        return leetCodeData;
    }
}