
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetUserIdTest {
    @Test
    public void getUserId() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://www.nowcoder.com/search/user?query=GoLeeX&type=user&searchType=%E9%A1%B6%E9%83%A8%E5%AF%BC%E8%88%AA%E6%A0%8F&subType=0"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // 获取HTML内容
        String html = response.body();

        // 定义正则表达式
        Pattern pattern = Pattern.compile("\"userId\":(\\d+),");


        // 创建Matcher对象
        Matcher matcher = pattern.matcher(html);

        // 查找匹配的字符串
        if (matcher.find()) {
            System.out.println("Matched text: " + matcher.group(1));// 匹配到的第一个分组
        } else {
            System.out.println("No match found.");
        }
    }
}