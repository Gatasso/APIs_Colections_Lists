package Exercicios.GSON.ex1.question2;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CheckCriptoCurrency {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a criptomoeda para checar sua cotação:");
        var resposta = scanner.nextLine();

        final String API_KEY = "CG-VkMnrADHsS5tUVoFqAP7Pkkx";
        final String apiAddress = "https://api.coingecko.com/api/v3/simple/price?ids="+ resposta + "&vs_currencies=usd&precision=2&key:" + API_KEY;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiAddress))
                .build();
        HttpResponse <String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();


    }
}
