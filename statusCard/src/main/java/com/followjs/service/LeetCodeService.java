package com.followjs.service;

import com.followjs.entity.LeetCodeData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface LeetCodeService {
    public LeetCodeData getLeetCodeInfo(String username);


}
