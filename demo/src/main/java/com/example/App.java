package com.example;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static String endereco;
    public static int quantidade;
    static Scanner scanner = new Scanner(System.in);
    static String input = "";
    static LocalDate diaAtual = LocalDate.now();
    static LocalTime horaAtual = LocalTime.now();
    public static void main( String[] args )
    {

        // Teste
        //Rua Doutor Marquemburgue 
        //2
        menu1();
        input = scanner.nextLine();
        cliente();

    }


    public static void menu1(){
            System.out.println( "----Menu------------" );
            System.out.println( "" );
            System.out.println( "" );
            System.out.println( "-1)Fazer Pedido" );
            System.out.println( "-00)Sair" );
            System.out.println( "" );
            System.out.println( "-------------------" );
    }

    public static void endereco(){
            System.out.println( "----Pedido----------" );
            System.out.println( "" );
            System.out.println( "" );
            System.out.println( "-)Endereço:" );
            System.out.println( "-00)Sair" );
            System.out.println( "" );
            System.out.println( "-------------------" );
    }

    public static void quantidade(){
            System.out.println( "----Pedido----------" );
            System.out.println( "" );
            System.out.println( "" );
            System.out.println( "-)Quantidade:" );
            System.out.println( "-00)Sair" );
            System.out.println( "" );
            System.out.println( "-------------------" );
    }
    public static void confirmar(){
            System.out.println( "----Pedido----------" );
            System.out.println( "" );
            System.out.println( "" );
            System.out.println( "--)Endereço Informado: "+endereco);
            System.out.println( "--)Quantidade Informada: "+quantidade);
            System.out.println( "-1)Confirmar");
            System.out.println( "-2)Alterar Endereco");
            System.out.println( "-00)Sair" );
            System.out.println( "" );
            System.out.println( "-------------------" );
    }

    public static void cliente(){
        while(!input.equals("00")){
            endereco();
            input = scanner.nextLine();
            endereco = !input.equals("00") ? endereco = input : endereco;
            quantidade();
            input = scanner.nextLine();
            quantidade = !input.equals("00") ? quantidade = Integer.parseInt(input) : quantidade;
            confirmar();
            input = scanner.nextLine();
            if(input.equals("2")){
                while(!input.equals("1") && !input.equals("00")){
                    endereco();
                    input=scanner.nextLine();
                    endereco = !input.equals("00") ? endereco = input : endereco;
                    confirmar();
                    input = scanner.nextLine();
                }
            }
            System.out.println("----------------");
            System.out.println("");
            if (input.equals("1")) {
                Pedido pedido1 = new Pedido(diaAtual, horaAtual, endereco, quantidade);
                System.out.println(pedido1.toString());
                input = "00";
            }
        }
    }
}
