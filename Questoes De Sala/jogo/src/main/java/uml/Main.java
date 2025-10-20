package uml;

import uml.entitys.*;
import uml.servicy.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Dificuldade.dificuldade dificu = Dificuldade.dificuldade.MEDIUM;
        Jogo jogo = new Jogo(dificu);

        try{
            Personagem p1 = new Jogavel(3,"Paulo",100,jogo);
            Personagem p2 = new NaoJogavel(false,"Luisa,",100,jogo);
            p1.aplicarGolpeNormal(p2);
            p1.aplicarGolpeNormal(p2);
            p1.aplicarGolpeEspecial(p2);
            System.out.println(p2.getVitalidade());

            /*
            for (Personagem jog : Jogo.getPersonagens()) {
                System.out.println(jog.getNome());
            }
            */
        }
        catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }


        try{
            Personagem p1 = new Jogavel(3, "Paulo", 100, jogo);
            Personagem p2 = new NaoJogavel(false, "Luisa", 100, jogo);

            p2.aplicarGolpeEspecial(p1);
            p2.aplicarGolpeNormal(p1);
            System.out.println(p1.getVitalidade());
        }
        catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}