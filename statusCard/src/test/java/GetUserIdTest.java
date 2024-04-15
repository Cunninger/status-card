
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetUserIdTest {
    @Test
    public void getUserId() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://www.nowcoder.com/search/user?query=EnofTaiPeople&type=user&searchType=%E9%A1%B6%E9%83%A8%E5%AF%BC%E8%88%AA%E6%A0%8F&subType=0"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONArray json = new JSONArray(response.body());
        System.out.println(json);
//        JSONObject app = json.getJSONObject("app");
//        JSONObject app240 = app.getJSONObject("240");
//        JSONArray pageList = app240.getJSONArray("pageList");
//        JSONObject pageList1 = pageList.getJSONObject(1);
//        JSONArray list = pageList1.getJSONArray("list");
//        JSONObject list0 = list.getJSONObject(0);
//        long userId = list0.getLong("userId");
//        System.out.println("User ID: " + userId);
    }
}