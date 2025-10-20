package uml.entitys;

import java.io.IOException;

import uml.entitys.Dificuldade.dificuldade;

public abstract class Personagem {
    private String nome;
    private int vitalidade;
    private Jogo jogo;


    public Personagem(String nome,int vitalidade,Jogo jogo){
        if((vitalidade < 0) || (vitalidade > 100)){
                throw new IndexOutOfBoundsException("Vitalidade Deve Ser Entre 0 e 100"+"\nError: "+nome);
        }
        this.vitalidade=vitalidade;
        this.nome =nome;
        this.jogo = jogo;    
    }

    public void aplicarGolpeNormal(Personagem adversario) {
            adversario.setVitalidade(adversario.getVitalidade()-10);
        }

    public abstract void aplicarGolpeEspecial(Personagem adversario);


        public Jogo getJogo() {
            return jogo;
        }

        public String getNome() {
            return nome;
        }

        public int getVitalidade() {
            return vitalidade;
        }

        public void setJogo(Jogo jogo) {
            this.jogo = jogo;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setVitalidade(int vitalidade) {
            this.vitalidade = vitalidade;
        }
    }
