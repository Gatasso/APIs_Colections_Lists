package Exercicios.GSON.ex2.question1_2;

public record Pessoa(String nome, int idade, String cidade, String time) {

    @Override
    public String toString() {
        return  "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cidade='" + cidade +
                "', time=" + time;
    }
}
