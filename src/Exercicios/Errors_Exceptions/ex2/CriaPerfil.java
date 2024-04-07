package Exercicios.Errors_Exceptions.ex2;

import Exercicios.Errors_Exceptions.ex1.DivisorIgualZeroException;

import java.util.Scanner;

public class CriaPerfil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Informe o nome de usuário: \n");
            String username = scanner.nextLine();
            System.out.println("Informe uma nova senha: ");
            String password = scanner.nextLine();
            verificaSenha(password);
            System.out.println("Usuário cadastrado com sucesso.");
        } catch (DivisorIgualZeroException e){
            System.out.println("Senha Inválida");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Operação encerrada");
        }
    }
    public static boolean verificaSenha(String password) throws SenhaInvalidaException{
        if (password.length() < 8){
            throw new SenhaInvalidaException("A senha contém menos de 8 digitos, por favor tente novamente.");
        } else return true;
    }
}
