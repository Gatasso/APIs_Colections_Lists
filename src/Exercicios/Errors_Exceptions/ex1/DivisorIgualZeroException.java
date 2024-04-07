package Exercicios.Errors_Exceptions.ex1;

public class DivisorIgualZeroException extends RuntimeException {
    public DivisorIgualZeroException(String message) {
        super(message);
    }
}
