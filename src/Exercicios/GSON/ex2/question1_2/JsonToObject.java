package Exercicios.GSON.ex2.question1_2;

import Exercicios.GSON.ex2.question1_2.Pessoa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonToObject {
    public static void main(String[] args) {

//        String json = "{\"nome\":\"Matheus Galasso\",\"idade\":22,\"cidade\":\"Bragança\",\"time\":\"São Paulo\"}";
        String json = "{\"nome\":\"Matheus Galasso\",\"idade\":22,\"cidade\":\"Bragança\"}";
//        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        Gson gson = new GsonBuilder().setLenient().create();
        Pessoa pessoa = gson.fromJson(json, Pessoa.class);
        System.out.println(pessoa);
    }
}
