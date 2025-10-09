package principal;

public abstract class Clube implements Pontuacao{
    private String nome;

    Clube(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
