package ua.goit.httpUtils;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import ua.goit.model.Order;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StoreHttpUtil {

    private static final Gson GSON = new Gson();
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    private static final String URL = "https://petstore.swagger.io/v2/";

    @SneakyThrows
    public static void createOrder(Order order) {
        String requestBody = GSON.toJson(order);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", URL, "store/order")))
                .header("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    @SneakyThrows
    public static void getOrderById(long id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s%d", URL, "store/order/", id)))
                .header("Content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    @SneakyThrows
    public static void deleteOrderById(long id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s%d", URL, "store/order/", id)))
                .header("Content-type", "application/json")
                .DELETE()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
