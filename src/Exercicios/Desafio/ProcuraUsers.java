package Exercicios.Desafio;

import java.util.Scanner;

public class ProcuraUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String address = consulta(scanner);
        } catch (UserNotFoundException e) {
            System.out.println("Hmmm. Parece que este usuário não existe...");
            System.out.println(e.getMessage());
        }
    }
    public static String consulta(Scanner scanner){
        System.out.println("Informe o nome de usuário que você deseja encontrar: ");
        String username = scanner.nextLine();
        return "https://api.github.com/search?q=" + username + "type:user&access_token=****************************************"; //TODO: change the '*' to token
    }
}
