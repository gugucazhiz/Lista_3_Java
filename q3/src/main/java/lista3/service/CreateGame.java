package lista3.service;

import java.util.Scanner;

import lista3.entity.Dado;
import lista3.entity.Jogador;
import lista3.entity.Robo;
import lista3.util.*;
public class CreateGame {
    private static Scanner scan = new Scanner(System.in);
    private int apostaAtual;
    private String validator = "1";
    private String nome;
    private String numeroJogado;
    private boolean recebe_BOOL = true;
    private CreatePlayer create;
    private final Robo robo;
    private int soma1;
    private int soma2;
    private int somaTotal;
    private int ganhadores;
    private int posicao_Atual;
    private final FileHandler fileHandler;
    private final Dado[] dados;
    private float premio;
    private Boolean passou = false;
    private Boolean passouAposta = false;
    //
    //
    public CreateGame(CreatePlayer create,FileHandler fileHandler){
        this.create = create;
        this.fileHandler = fileHandler;
        this.robo = new Robo();
        this.dados = new Dado[]{new Dado(),new Dado()};
    }
    public void bemVindo(){
        System.out.println("--------Carregando--------");
        this.create = fileHandler.carregar();
        System.out.println("--------Carregando--------");

        System.out.println();
        System.out.println("1) Iniciar Jogo");
        System.out.println("2) Placar");
        System.out.println("3) Zerar Jogos");
        System.out.println("0) Sair");
        System.out.println();
        
        validator =scan.nextLine();
        escolhido();
    }
    public void loading(){
        if(create.getJogadores().isEmpty() || create.getJogadores().size() < 1){
            System.out.println("Vai Criar");
            newGame();
        }
        System.out.println("Passou direto");
        iniciarPartida();
    }
    public void newGame(){
            while (recebe_BOOL) {
                System.out.println("Digite nome ou digite 0 para sair: ");
                nome= scan.nextLine();
                if (!nome.equals("0")) {
                    recebe_BOOL =create.criarJogador(nome);
                }
                else{
                    recebe_BOOL=false;
                }
                
            }
            recebe_BOOL=true;
        iniciarPartida();
    }

    public  boolean placar(){
        create.ordenarJogadores();
        System.out.println("--------Placar--------");
        System.out.println();
        for (Jogador j : create.getJogadores()) {
            System.out.println();
            System.out.println("Jogador: "+j.getNome());
            posicao_Atual = create.getJogadores().indexOf(j)+1;
            System.out.println("Posicao No Rank: "+posicao_Atual);
            System.out.println("Id: "+j.getId());
            System.out.println("Partidas Ganhas: "+j.getPontuacao());
            System.out.println("Saldo: "+j.getSaldo());
            System.out.println();
        }
        System.out.println("--------Placar--------");
        System.out.println();
        System.out.println("--------Voltar--------");
        System.out.println();
        System.out.println("Deseja Voltar Para Menu Principal");
        System.out.println("Digite '1' Para Sim");
        System.out.println("Digite '2' Para Sair Do Jogo");
        System.out.println();
        System.out.println("--------Voltar--------");

        validator = scan.nextLine();
        if(validator.equals("1")){
            bemVindo();
            return false;
        }
        fileHandler.salvar(create);
        return false;
    }

    public  void zerarJogos(){
        fileHandler.apagar();
        bemVindo();
    }

    public static void sair(){
        System.out.println("");
        System.out.println("Saindo...");
        System.out.println("");
    }

    public void iniciarPartida(){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        if(create.getJogadores().size() == 0){
            bemVindo();
        }
        System.out.println("Iniciando Partida ");
        System.out.println("");
        System.out.println("");
        for (Jogador j : create.getJogadores()) {
            System.out.println("----------------------------------");
            System.out.println();
            System.out.println("Digite um Numero De 1 a 12 A Ser Jogado Pelo Jogador:");
            System.out.println(j.getNome());
            System.out.println();
            while(!passou){
                try {
                    numeroJogado = scan.nextLine();
                    j.setNumeroJogado(Integer.parseInt(numeroJogado));
                    passou = true;
                } catch (IndexOutOfBoundsException e) {
                    // TODO: handle exception
                    System.out.println(e.getMessage());

                }
            }
            System.out.println("Digite um Numero De 1 a 12 A Ser Apostado Pelo Jogador");
            System.out.println(j.getNome());
            System.out.println("Saldo: ");
            System.out.println(j.getSaldo());
            while(!passouAposta){
                try {
                    apostaAtual=Integer.parseInt(scan.nextLine());
                    j.setNumeroAposta(apostaAtual);
                    premio += apostaAtual;
                    passouAposta = true;
                } catch (IndexOutOfBoundsException e) {
                    // TODO: handle exception
                    System.out.println(e.getMessage());
                }
                
            }
            
            System.out.println("----------------------------------");
            passou = false;
            passouAposta = false;
        }
        robo.jogar();
        for(Jogador j : create.getJogadores()){
            System.out.println();
            System.out.println("Jogador: "+j.getNome());
            System.out.println("Palpite: "+j.getNumeroJogado());
            System.out.println();
        }
        System.out.println("Numero Jogado Pela Maquina: "+robo.getNumero_Jogado());
        System.out.println("Pressione Alguma Tecla Para Continuar: ");
        scan.nextLine();
        resultado();
    }

    public boolean resultado(){
        Dado.Lado resultado1 = dados[0].jogar();
        Dado.Lado resultado2 = dados[1].jogar();

        System.out.println();
        System.out.println("--------Resultado--------");
        System.out.println();
        System.out.println("Dado Numero 1: "+resultado1);
        soma1 = resultado1.ordinal()+1;
        System.out.println("Dado Numero 2: "+resultado2);
        soma2 = resultado2.ordinal()+1;
        somaTotal = soma1 + soma2;
        System.out.println(soma1+" + "+soma2+" = "+somaTotal);
        System.out.println("--------Resultado--------");
        System.out.println();
        for (Jogador j : create.getJogadores()){
            if(j.getNumeroJogado() == somaTotal){
                System.out.println("Jogador: "+j.getNome() + " Ganhou!");
                j.setPontuacao(1);
                ganhadores++;
            }
        }
        if(robo.getNumero_Jogado() == somaTotal){
            System.out.println("Maquina Ganhou!");
            ganhadores++;
        }
        if(ganhadores > 0){
            System.out.println();
            System.out.println("----------------------");
            System.out.println("Total De Ganhadores: "+ganhadores);
            System.out.println("Premio De "+premio+" Sera Dividido Igualmente: "+"R$ "+premio/ganhadores);
            System.out.println("----------------------");
            for (Jogador j : create.getJogadores()) {
                if(j.getNumeroJogado() == somaTotal){
                    j.setSaldo((premio/ganhadores));
                }
            }
        }
        else{
            System.out.println("Ninguem Ganhou Valores Seram Devolvidos");
            for (Jogador j : create.getJogadores()){
                if(j.getNumeroJogado() >= 1){
                    j.seguroDePercas();
            }
        }
        } 
        premio = 0;
        ganhadores =0;
        System.out.println("Digite Uma Tecla Para Nova Partida ou '0' Para Sair E Ver Placar");
        validator=scan.nextLine();
        if (!validator.equals("0")) {
            iniciarPartida();
            return false;
        }
        placar();
        return false;
    }

    public void escolhido(){
        switch (validator) {
            case "1":
                loading();
                break;
            case "2":
                placar();
                break;
            case "3":
                zerarJogos();
                break;
            default:
                sair();
                break;
        }
    }
}
