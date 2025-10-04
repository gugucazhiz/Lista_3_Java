package com.example;


public class Funcionario implements Empresa {
    private String nome;
    SistemaEmpresa sistemaEmpresa;
    public Funcionario(String nome,SistemaEmpresa sistemaEmpresa){
        this.nome = nome;
        this.sistemaEmpresa = sistemaEmpresa;
    }

    @Override
    public void consultar(){
        System.out.println("Pedidos Cadastrados Em Aberto");
        for(Pedido p : sistemaEmpresa.getTodosPedidos()){
            if(p.getStatus().equals("Aberto")){
                System.out.println("Nome: "+p.getNomeAssociado());
                System.out.println("Codigo:" +p.getCodPedido());
                System.out.println("Status:" +p.getStatus());
                System.out.println("Total: "+p.getTotalPedido());
                System.out.println("");
            }
        }
    }

    @Override
    public void consultarFechados(){
        System.out.println("Pedidos Cadastrados Concluidos");
        for(Pedido p : sistemaEmpresa.getTodosPedidos()){
            if(p.getStatus().equals("Concluido")){
                System.out.println("Nome: "+p.getNomeAssociado());
                System.out.println("Codigo:" +p.getCodPedido());
                System.out.println("Status:" +p.getStatus());
                System.out.println("Total: "+p.getTotalPedido());
                System.out.println("");
            }
        }
    }

        public void listarPedidos(){
        if(sistemaEmpresa.getTodosPedidos().isEmpty()){
            System.out.println("Nenhum Pedido Cadastrado. ");
        }
        else{
            for(Pedido p : sistemaEmpresa.getTodosPedidos()){
                System.out.println("Nome: "+p.getNomeAssociado());
                System.out.println("Codigo:" +p.getCodPedido());
                System.out.println("Status:" +p.getStatus());
                System.out.println("Total: "+p.getTotalPedido());
                System.out.println("");
            }
        }
    }

    public Pedido listarEspecifico(int cod_pedido){
        for(Pedido p : sistemaEmpresa.getTodosPedidos()){
            if(p.getCodPedido() == cod_pedido){
                System.out.println("Nome: "+p.getNomeAssociado());
                System.out.println("Codigo:" +p.getCodPedido());
                System.out.println("Status:" +p.getStatus());
                System.out.println("Total: "+p.getTotalPedido());
                return p;
            }
        }
        System.out.println("Esse pedido de codigo "+cod_pedido+" não existe.");
        return null;
        
    }


    public String getNome(){
        return this.nome;
    }
}
