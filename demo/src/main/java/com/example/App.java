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
    static SistemaEmpresa sistema = new SistemaEmpresa();
    static Cliente c1;
    static Funcionario f1;
    public static void main( String[] args )
    {

        // Teste
        //Rua Doutor Marquemburgue 
        //2
        while(!input.equals("00")){
            menuPrincipal();
            input = scanner.nextLine();
        }

    }

    public static void menuPrincipal(){
            System.out.println( "----Menu Principal--" );
            System.out.println( "" );
            System.out.println( "" );
            System.out.println( "-1)Cliente" );
            System.out.println( "-2)Funcionario" );
            System.out.println( "-00)Sair" );
            System.out.println( "" );
            System.out.println( "-------------------" );
            
            input = scanner.nextLine();
            if(input.equals("1")){
                cliente();
            }
            if(input.equals("2")){
                funcionario();
            }
    }

    public static void menu1(){
            System.out.println( "----Menu------------" );
            System.out.println( "" );
            System.out.println( "" );
            System.out.println( "-1)Fazer Pedido" );
            System.out.println( "-2)Consultar Pedidos" );
            System.out.println( "-00)Sair" );
            System.out.println( "" );
            System.out.println( "-------------------" );
    }

    public static void menu2(){
            System.out.println( "----Menu-2----------" );
            System.out.println( "" );
            System.out.println( "" );
            System.out.println( "-1)Verificar Todos Pedidos" );
            System.out.println( "-2)Consultar Pedido Especifico" );
            System.out.println( "-3)Pedidos Em Aberto" );
            System.out.println( "-4)Pedidos Fechados" );
            System.out.println( "-5)Voltar Para Menu Principal" );
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

    public static void abertoOuFechados(){
            System.out.println( "----Menu------------" );
            System.out.println( "" );
            System.out.println( "" );
            System.out.println( "-1)Pedidos Em Aberto" );
            System.out.println( "-2)Pedidos Fechados" );
            System.out.println( "-00)Sair" );
            System.out.println( "" );
            System.out.println( "-------------------" );
    }


    public static void cliente(){
        String nome;
        System.out.println("Digite Seu Nome: ");
        nome = scanner.nextLine();
        c1 =sistema.cadastrarCliente(nome);
        System.out.println("");
        input = scanner.nextLine();
        menu1();
        input = scanner.nextLine();
        if(input.equals("1")){
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

                    System.out.println("Pressione Uma Tecla Para Continuar");
                    input = scanner.nextLine();

                    System.out.println("Digite Seu Cartão Para Concluir O pagamento: ");
                    input = scanner.nextLine();
                    pedido1.efetuarPagamento(input);
                    System.out.println("");
                    System.out.println("Confirmado");
                    System.out.println("Codigo do pedido: "+pedido1.getCodPedido());
                    c1.addPedido(pedido1);
                    sistema.addPedido(pedido1);
                    input = "00";
                }
            }
        }
        else{
            abertoOuFechados();
            input = scanner.nextLine();
            if(input.equals("1")){
                c1.consultar();
            }
            else{
                c1.consultarFechados();
            }
            
        }
    }

    public static void funcionario(){
        String nome;
        System.out.println("Digite Seu Nome: ");
        nome = scanner.nextLine();
        f1 = sistema.cadastrarFuncionario(nome);
        System.out.println("");
        while(!input.equals("00")){
            menu2();
            input = scanner.nextLine();
            if(input.equals("1")){
                sistema.listarPedidos();
                System.out.println("Digite uma tecla para continuar. ou 00 para sair ");
                input = scanner.nextLine();
            }
            else if(input.equals("2")){
                System.out.println("");
                System.out.println("Digite codigo do pedido: ");
                int cod_pedido;
                cod_pedido = scanner.nextInt();
                input = scanner.nextLine();
                Pedido seletor =sistema.listarEspecifico(cod_pedido);

                System.out.println("");
                System.out.println("Deseja Concluir esse pedido?: 1=sim || 2=nao ");
                input = scanner.nextLine();
                if(input.equals("1")){
                    seletor.setStatus("Concluido");
                    System.out.println("Status Alterado");
                }
            }
            else if(input.equals("3")){
                f1.consultar();
                input = scanner.nextLine();
            }

            else if(input.equals("4")){
                f1.consultarFechados();
                input = scanner.nextLine();
            }
            else if(input.equals("5")){
                menuPrincipal();
            }
        }
    }
}
