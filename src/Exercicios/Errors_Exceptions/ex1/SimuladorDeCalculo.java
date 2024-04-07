package Exercicios.Errors_Exceptions.ex1;

import java.util.Scanner;

public class SimuladorDeCalculo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Informe o numerador: \n");
            int numerador = scanner.nextInt();
            System.out.println("Informe o divisor: ");
            int divisor = scanner.nextInt();
            double resultado =calculador(numerador, divisor);
            System.out.println(resultado);
        }catch (DivisorIgualZeroException e){
            System.out.println("Erro ao informar o numerador");
            System.out.println(e.getMessage());
        }

    }
    public static double calculador(int numerador, int divisor) throws DivisorIgualZeroException{
        if (divisor == 0){
            throw new DivisorIgualZeroException("O divisor não pode ser 0, por favor informe um número válido");
        }  else return (double) numerador / divisor;
    }
}
