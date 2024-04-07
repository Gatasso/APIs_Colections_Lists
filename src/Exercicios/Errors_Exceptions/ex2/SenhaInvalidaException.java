package Exercicios.Errors_Exceptions.ex2;

public class SenhaInvalidaException extends RuntimeException{
    public SenhaInvalidaException(String message) {
        super(message);
    }
}
