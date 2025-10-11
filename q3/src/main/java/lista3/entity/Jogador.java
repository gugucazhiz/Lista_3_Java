package lista3.entity;

public class Jogador {
    public static int limite = 0;
    private int id;
    private String nome;
    private int pontuacao;

    public Jogador(String nome){
        if(limite >=4){
            throw new IllegalStateException("Limite De Jogadores Atingido. ");
        }
        this.nome = nome;
        limite++;
        id = limite;
    }


    // meus gets
    public int getPontuacao(){
        return pontuacao;
    }
    public String getNome() {
        return nome;
    }
    public int getId(){
        return id;
    }

    // meus sets
    public void setPontuacao(){
        this.pontuacao = pontuacao;
    }
    public void setNome(){
        this.nome = nome;
    }
}
