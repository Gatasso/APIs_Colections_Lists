package Exercicios.Desafio;

public class User {
    private String username, id;

    public User(GitHubUser user) {
        this.username = user.login();
        this.id = String.valueOf(user.id());
    }

    @Override
    public String toString() {
        return "Nome: " + username +
                ", id= " + id;
    }

    public static record GitHubUser(String login, int id){
    }
}
