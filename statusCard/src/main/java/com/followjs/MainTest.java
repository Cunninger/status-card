package com.followjs;

/**
 * 功能：
 * 日期：2024/4/14 下午4:19
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MainTest {
    public static void main(String[] args) throws Exception {
        // 1. Fetch the HTML code
        Document doc = Jsoup.connect("https://leetcode.cn/u/profsnail/").get();

        // 2. Parse the HTML to extract elements
        Element element = doc.selectFirst("div.text-[24px].font-medium.text-label-1.dark:text-dark-label-1");

        // 3. Extract data from the elements
        String text = element.text();

        System.out.println(text);
    }
}
