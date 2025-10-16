package lista3;

import lista3.entity.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        //APARTAMENTO ============================================
        Moradia ap = new Apartamento("Pedro", "Rua dos Palmares", 2);
        ap.alugar("Pietro");
        System.out.println("\nO dono do apartamento é: "+ap.getProprietario()+
                            "\nO Apartamento esta Alugado para: "+ap.getAlugadoPara());
        ap.desocupar();
        System.out.println(ap.getAlugadoPara());
        
        //APARTAMENTO ============================================
    }
}