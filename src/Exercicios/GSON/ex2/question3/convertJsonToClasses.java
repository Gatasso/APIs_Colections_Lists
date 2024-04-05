package Exercicios.GSON.ex2.question3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class convertJsonToClasses {
    public static void main(String[] args) {
        String json = "{\"titulo\":\"Aventuras do Java\",\"autor\":\"Akemi\",\"editora\":{\"nome\":\"TechBooks\",\"cidade\":\"São Paulo\"}}";

        Gson gson = new Gson();

        gson.fromJson(json, Livro.class);
        Livro livro = gson.fromJson(json, Livro.class);
        System.out.println(livro);
    }
}
