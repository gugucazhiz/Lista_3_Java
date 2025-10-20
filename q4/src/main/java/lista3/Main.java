package lista3;

import lista3.entity.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //Moradia ===============================================
        Moradia m1 = new Moradia("Rafael", "Rua Das Limeiras",true);
        System.out.println(m1.isUrbana());
        System.out.println(m1.localizacao());
        m1.reformar();
        System.out.println("Ultima Reforma:"+m1.getUltimaReforma()+"\n");
        //Moradia ===============================================
        System.out.println("//Moradia ===============================================");

        System.out.println("//APARTAMENTO ============================================");
        //APARTAMENTO ============================================
        Apartamento ap = new Apartamento("Pedro", "Rua dos Palmares", 2);
        ap.alugar("Pietro");
        System.out.println("\nO dono do apartamento é: "+ap.getProprietario()+
                            "\nO Apartamento esta Alugado para: "+ap.getAlugadoPara());
        ap.desocupar();
        System.out.println("O Ap Agora esta: "+ap.getAlugadoPara());
        ap.funcionamento();
        ap.mudarEndereco(3);
        System.out.println(ap.getAndar());
        System.out.println(ap.getLocalizacao());
       
        //APARTAMENTO ============================================
        System.out.println("//APARTAMENTO ============================================\n");

        System.out.println("//Casa ============================================");
        //Casa ============================================

        Casa c1 = new Casa("Edgar", "Rua dos Tororos", 580, true);
        System.out.println(c1.varrerQuintal());
        c1.alugar("Samira");
        c1.desocupar();
        System.out.println("a Casa Agora esta: "+c1.getAlugadoPara());
        Casa c2 = new Casa("Edgar2", "Rua dos Tororos", 453, false);
        System.out.println(c2.varrerQuintal());

        //Casa ============================================
        System.out.println("//Casa ============================================\n");


        //Casa ============================================
        System.out.println("//Comercial ============================================");
        Comercial co1 = new Comercial("Guilherme", "555666777000", "Rua Baixada Santista");
        System.out.println(co1.AnaliseCnpj());
        co1.addVenda(2);
        co1.addVenda(3,"óleo diesel");
        co1.funcionamento();
        co1.funcionamento(6,5);
        System.out.println(co1.AnaliseCnpj());
        System.out.println(co1.localizacao());
        System.out.println("Movimentação total em dolar: "+co1.analiseDeMercado());
    }


}