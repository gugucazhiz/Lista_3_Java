package lista3.servicy;

import java.util.Scanner;

import lista3.entity.Dado;
import lista3.entity.Jogador;
import lista3.entity.Robo;
import lista3.servicy.*;

public class CreateGame {
    static Scanner scan = new Scanner(System.in);
    static String validator = "1";
    static String nome;
    static String numeroJogado;
    static boolean recebe_BOOL = true;
    static CreatePlayer create = new CreatePlayer();
    static Robo robo = new Robo();
    static int soma1;
    static int soma2;
    static int somaTotal;
    static int ganhadores;
    static int posicao_Atual;
    //
    static Dado dado1 = new Dado();
    static Dado dado2 = new Dado();
    //

    public static void bemVindo(){
        System.out.println();
        System.out.println("1) Iniciar Jogo");
        System.out.println("2) Placar");
        System.out.println("3) Zerar Jogos");
        System.out.println("0) Sair");
        System.out.println();
        validator =scan.nextLine();
        escolhido();
    }

    public static void newGame(){
        if(create.getJogadores().isEmpty()){
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
        }
        iniciarPartida();
    }

    public static boolean placar(){
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
            System.out.println();
        }
        System.out.println("--------Placar--------");
        System.out.println();
        System.out.println("Deseja Voltar Para Menu Principal");
        System.out.println("Digite '1' Para Sim");
        System.out.println("Digite '2' Para Nao e Sair");
        validator = scan.nextLine();
        if(validator.equals("1")){
            bemVindo();
            return false;
        }
        return false;
    }

    public static void zerarJogos(){

    }

    public static void sair(){
        System.out.println("");
        System.out.println("Saindo...");
        System.out.println("");
    }

    public static void iniciarPartida(){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Iniciando Partida ");
        System.out.println("");
        System.out.println("");
        for (Jogador j : create.getJogadores()) {
            System.out.println();
            System.out.println("Digite um Numero De 1 a 12 A Ser Jogado Pelo Jogador:");
            System.out.println(j.getNome());
            System.out.println();
            numeroJogado = scan.nextLine();
            j.setNumeroJogado(Integer.parseInt(numeroJogado));
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

    public static boolean resultado(){
        Dado.Lado resultado1 = dado1.jogar();
        Dado.Lado resultado2 = dado2.jogar();

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
            System.out.println("Total De Ganhadores: "+ganhadores);
            System.out.println("Premio De "+" Sera Dividido Igualmente: "+"R$ ");
        }
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

    public static void escolhido(){
        switch (validator) {
            case "1":
                newGame();
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
