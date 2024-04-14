package com.followjs.service.Impl;

import com.followjs.service.LeetCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能：
 * 日期：2024/4/14 下午3:44
 */
@RestController
@RequestMapping ("/leetcode")
public class leetCodeServiceImpl implements leetCodeService {
    @Autowired
    private leetCodeService leetCodeService;

    @GetMapping
    public ResponseEntity<?> getLeetCodeInfo(@RequestParam String username, @RequestParam(required = false) String cn,
                                             @RequestParam(required = false) String theme, @RequestParam(required = false) String cn_username,
                                             @RequestParam(required = false) String lang, @RequestParam(required = false) String raw) {
        leetCodeData data = leetCodeService.getLeetCodeInfo(username, cn, theme, cn_username, lang, raw);
        if (raw != null) {
            return ResponseEntity.ok(data);
        }
        // set headers and return SVG image
    }
}