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
        Gson gson = new GsonBuilder().create();

        JsonTreatment respostaLivros = gson.fromJson(json, JsonTreatment.class);
        if (respostaLivros.getItems().length > 0) {
            JsonTreatment.VolumeInfo volumeInfo = respostaLivros.getItems()[0].getVolumeInfo();
            Livro livro = new Livro(volumeInfo.getTitle(), volumeInfo.getAuthors(), volumeInfo.getPublisher(), volumeInfo.getPublishedDate());
            System.out.println(livro);
        } else {
            System.out.println("Nenhum livro encontrado.");
        }
    }
}
