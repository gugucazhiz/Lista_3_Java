package lista3.entity;

public class Jogador {
    public static int limite = 0;
    private int id;
    private String nome;
    private int pontuacao = 0;
    private int numero_Jogado;

    public Jogador(String nome){
        if(limite >=12){
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
    public int getNumeroJogado(){
        return numero_Jogado;
    }

    // meus sets
    public void setPontuacao(int pontuacao){
        this.pontuacao += pontuacao;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setNumeroJogado(int numero_Jogado){
        this.numero_Jogado = numero_Jogado;
    }

    public void setId(int id) {
        this.id = id;
    }

}
