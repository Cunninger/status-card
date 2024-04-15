package com.followjs.service.Impl;

import com.followjs.entity.NowCoderData;
import com.followjs.service.NowCoderService;
import org.springframework.web.client.RestTemplate;

/**
 * 功能：
 * 日期：2024/4/15 上午8:42
 */
public class NowCoderServiceImpl implements NowCoderService {

    private RestTemplate restTemplate;
    @Override
    public NowCoderData getNowCoderInfo(String name) {
        // 根据name先得到userId
        // 再根据userId得到数据
         long userId = 0;


        String url  = "https://ac.nowcoder.com/acm/contest/profile/"+userId;

        return null;
    }

}