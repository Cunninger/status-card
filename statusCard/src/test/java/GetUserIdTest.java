
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

/**
 *  <div class="state-num rate-score6">2796</div>
 *  <div class="state-num"> group1
 *  <div class="state-num"> group3
 *  https://ac.nowcoder.com/acm/contest/profile/497256985/practice-coding
 *  <div class="state-num"> group （2）
 * @throws Exception
 */
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

    @Test
    public void getRating() throws Exception {
        String userId = "497256985";
        String url  = "https://ac.nowcoder.com/acm/contest/profile/"+userId;
        System.out.println(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // 获取HTML内容
        String html = response.body();

        // 定义正则表达式
        Pattern pattern = Pattern.compile("<div class=\"state-num rate-score6\">(\\d+)");


        // 创建Matcher对象
        Matcher matcher = pattern.matcher(html);
        // 查找匹配的字符串
        if (matcher.find()) {
            System.out.println("Matched text: " + matcher.group(1));
//            return matcher.group(1);


        } else {
            System.out.println("No match found.");
//            return null;
        }

    }



    @Test
    public void getRatingRank() throws Exception {
        String userId = "497256985";
        String url  = "https://ac.nowcoder.com/acm/contest/profile/"+userId;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // 获取HTML内容
        String html = response.body();

        // 定义正则表达式
        Pattern pattern = Pattern.compile("<div class=\"state-num\">(\\d+)");


        // 创建Matcher对象
        Matcher matcher = pattern.matcher(html);
        // 查找匹配的字符串
        if (matcher.find()) {
            System.out.println("Matched text: " + matcher.group(1));
        } else {
            System.out.println("No match found.");
        }

    }





    @Test
    public void getCompetitionCount() throws Exception {
        String userId = "497256985";
        String url  = "https://ac.nowcoder.com/acm/contest/profile/"+userId;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // 获取HTML内容
        String html = response.body();

        // 定义正则表达式
        Pattern pattern = Pattern.compile("<div class=\"state-num\">(\\d+)");


        // 创建Matcher对象
        Matcher matcher = pattern.matcher(html);
        // 如果你想获取第三次匹配的数据，你需要循环调用matcher.find()方法三次来找到第三个匹配
        int count = 0;
        while (matcher.find()) {
            count++;
            if (count == 3) {
                System.out.println("Matched text: " + matcher.group(1));
            }
        } if (count < 3) {
            System.out.println("No match found.");
        }

    }



@Test
    public void gethasPassedProblem() throws Exception {
        String userId = "497256985";
        String url  = "https://ac.nowcoder.com/acm/contest/profile/"+userId+"/practice-coding";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // 获取HTML内容
        String html = response.body();

        // 定义正则表达式
        Pattern pattern = Pattern.compile("<div class=\"state-num\">(\\d+)");


        // 创建Matcher对象
        Matcher matcher = pattern.matcher(html);
        // 如果你想获取第三次匹配的数据，你需要循环调用matcher.find()方法三次来找到第三个匹配
        int count = 0;
        while (matcher.find()) {
            count++;
            if (count == 2) {
                System.out.println("Matched text: " + matcher.group(1));
            }
        } if (count <2) {
            System.out.println("No match found.");
        }

    }

}