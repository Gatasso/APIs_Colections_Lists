package Exercicios.Desafio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ProcuraUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String accessToken = "****************************************";
        try {
            String address = consulta(scanner, accessToken);
            String json = buildHttpRequest(address,accessToken);
            Gson gson = new GsonBuilder().create();
            User.GitHubUser gitHubUser = gson.fromJson(json, User.GitHubUser.class);
            User user = new User(gitHubUser);
            System.out.println(user);
        } catch (UserNotFoundException e) {
            System.out.println("Hmmm. Parece que este usuário não existe...");
            System.out.println(e.getMessage());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static String consulta(Scanner scanner, String token){
        System.out.println("Informe o nome de usuário que você deseja encontrar: ");
        String username = scanner.nextLine();
        return "https://api.github.com/users/" + username;
    }
    public static String buildHttpRequest(String address, String token) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .header("Accept", "application/vnd.github.v3+json")
                .build();
        HttpResponse <String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 404){
            throw new UserNotFoundException("O usuário procurado não existe. Tente novamente");
        } else return response.body();
    }
}
