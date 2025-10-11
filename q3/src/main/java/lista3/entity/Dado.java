package lista3.entity;

//Modelo Servicos Utilitarios M S U  Model/entity services utils

import java.util.Random;

public class Dado {
    public enum Lado{
        UM(1),
        DOIS(2),
        TRES(3),
        QUATRO(4),
        CINCO(5),
        SEIS(6);

        private final int valor;

        Lado(int valor){
            this.valor = valor;
        }

        int getLado(){
            return this.valor;
        }

        public static Lado sortear(){
            int sorteado = new Random().nextInt(6);
            return Lado.values()[sorteado];
        }
    }

    public Lado jogar(){
        return Lado.sortear();
    }
}
