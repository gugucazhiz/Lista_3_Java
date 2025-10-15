package lista3.util;

import java.util.Scanner;

import lista3.entity.Robo;

public class Movimentos {
    public void movimentos(){
        Robo robo = new Robo(1, 1);
        Scanner scanner = new Scanner(System.in);
        int input =0;

        while (input !=90) {

            System.out.println("");
            robo.menu();

            input = scanner.nextInt();

            switch (input) {
                case 1:
                    System.out.println(digiteValor()+ "para frente: "); 
                    input = scanner.nextInt();
                    robo.andarFrente(input);
                    break;

                case 2:
                    System.out.println(digiteValor()+ "para tras: "); 
                    input = scanner.nextInt();
                    robo.andartras(input);
                    break;

                case 3:
                    System.out.println(digiteValor()+ "para esquerda: "); 
                    input = scanner.nextInt();
                    robo.andarEsquerda(input);
                    break;

                case 4:
                    System.out.println(digiteValor()+ "para direita: "); 
                    input = scanner.nextInt();
                    robo.andarDireita(input);
                    break;

                case 5:
                    robo.mostrarPosAtual();
                    input = scanner.nextInt();
                    break;
            
                default:
                    System.out.println("\nSaindo");
                    input = 90;
                    break;
            }

        }
        
    }

    public static String digiteValor(){
        return "\nDigite Valor a ser andado ";
    }
}
