package com.followjs.service.Impl;

import com.followjs.entity.NowCoderData;
import com.followjs.service.NowCoderService;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String userId = null;
        try {
            userId = getUserId(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (userId == null) {
            System.out.println("No match found.");
        } else {
            String url  = "https://ac.nowcoder.com/acm/contest/profile/"+userId;



            System.out.println("Matched text: " + userId);
        }
        return null;



    }


    public static String getUserId(String name) throws Exception {
        // 发送HTTP请求
        String html = sendRequest("https://www.nowcoder.com/search/user?query=" + name + "&type=user&searchType=%E9%A1%B6%E9%83%A8%E5%AF%BC%E8%88%AA%E6%A0%8F&subType=0");

        // 匹配正则表达式
        return matchRegex("\"userId\":(\\d+),", html);
    }

    public static String sendRequest(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String matchRegex(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }


}