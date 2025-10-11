package lista3.entity;

import java.util.Random;

public class Robo {
    private int pontuacao;
    private int numero_Jogado;

    public int jogar(){ 
        int jogado = new Random().nextInt(12);
        setNumero_Jogado(jogado);
        return jogado;
       }


    //meus getters
    public int getNumero_Jogado() {
        return numero_Jogado;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    //meus setters
    public void setNumero_Jogado(int numero_Jogado) {
        this.numero_Jogado = numero_Jogado;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
