package lista3.entity;

public class Jogador {
    public static int limite = 0;
    private int id;
    private String nome;
    private int pontuacao = 0;
    private int numero_Jogado;
    private float numero_Aposta;
    private float saldo=20; // valor fixo inicial de 20;
    private float seguroDePercas;

    public Jogador(String nome){
        if(limite >=12){
            throw new IllegalStateException("Limite De Jogadores Atingido. ");
        }
        this.nome = nome;
        limite++;
        id = limite;
    }
    public void seguroDePercas(){
        this.saldo += seguroDePercas;
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
    
    public float getSaldo() {
        return saldo;
    }

    // meus sets
    public void setPontuacao(int pontuacao){
        this.pontuacao += pontuacao;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setNumeroJogado(int numero_Jogado){
        if((numero_Jogado<1 || numero_Jogado >12)){
            throw new IndexOutOfBoundsException("Digite um numero valido entre 1 e 12");
        }
        this.numero_Jogado = numero_Jogado;
    }

    public void setNumeroAposta(float numero_Aposta){
        if((numero_Aposta<0 || numero_Aposta>12)){
            throw new IndexOutOfBoundsException("Digite uma Aposta valida entre 1 e 12");
        }
        if(numero_Aposta>saldo){
            throw new IndexOutOfBoundsException("Valor maior que saldo atual do Jogador");
        }
        this.saldo -= numero_Aposta;
        this.seguroDePercas = numero_Aposta;
        this.numero_Aposta=numero_Aposta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSaldo(float saldo) {
        this.saldo += saldo;
    }

    public void loadSaldo(float saldo){
        this.saldo = saldo;
    }
}
