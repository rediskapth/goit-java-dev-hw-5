package ua.goit.httpUtils;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import ua.goit.model.Pet;
import ua.goit.model.PetStatus;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PetHttpUtil {

    private static final Gson GSON = new Gson();
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    private static final String URL = "https://petstore.swagger.io/v2/";

    @SneakyThrows
    private static void createPet(Pet pet) {
        String requestBody = GSON.toJson(pet);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", URL, "pet")))
                .header("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    @SneakyThrows
    public static void updatePet(Pet pet) {
        String requestBody = GSON.toJson(pet);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", URL, "pet")))
                .header("Content-type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    @SneakyThrows
    public static void getPetByStatus(PetStatus status) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", URL, "pet/findByStatus?status" + status.toString().toLowerCase())))
                .header("Content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    @SneakyThrows
    public static void getPetById(long id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s%d", URL, "pet/", id)))
                .header("Content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    @SneakyThrows
    public static void deletePetById(long id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s%d", URL, "pet/", id)))
                .header("Content-type", "application/json")
                .DELETE()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
