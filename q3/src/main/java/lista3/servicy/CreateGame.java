package lista3.servicy;

import java.util.Scanner;

public class CreateGame {
    static Scanner scan = new Scanner(System.in);
    static String validator = "1";
    static String nome;
    static boolean recebe_BOOL = true;
    static CreatePlayer create = new CreatePlayer();

    

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
        while (recebe_BOOL) {
            System.out.println("Digite nome: ");
            nome= scan.nextLine();
            if (!nome.equals("0")) {
                recebe_BOOL =create.criarJogador(nome);
            }
            else{
                recebe_BOOL=false;
            }
            
        }
        iniciarPartida();
    }

    public static void placar(){

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
        System.out.println("Iniciando Partida ");
        System.out.println("");
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
