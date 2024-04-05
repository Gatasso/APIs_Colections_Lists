package Exercicios.GSON.ex1.question1;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PesquisaLivros {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome do resposta que você deseja buscar:");
        var resposta = scanner.nextLine();

        String API_KEY = "AIzaSyBIyQ0oHW1DFUVx-ySFnMYiAP35FledZHE";
        String adress = "https://www.googleapis.com/books/v1/volumes?q=" + resposta + "&fields=items&key=" + API_KEY;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(adress))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        Livro livro = gson.fromJson(json, Livro.class);
        System.out.println(livro);
    }
}
