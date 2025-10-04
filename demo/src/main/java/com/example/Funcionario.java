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
                System.out.println("Codigo:" +p.getCodPedido());
                System.out.println("Status:" +p.getStatus());
                System.out.println("Total: "+p.getTotalPedido());
            }
        }
    }

    @Override
    public void consultarFechados(){
        System.out.println("Pedidos Cadastrados Concluidos");
        for(Pedido p : sistemaEmpresa.getTodosPedidos()){
            if(p.getStatus().equals("Concluido")){
                System.out.println("Codigo:" +p.getCodPedido());
                System.out.println("Status:" +p.getStatus());
                System.out.println("Total: "+p.getTotalPedido());
            }
        }
    }


    public String getNome(){
        return this.nome;
    }
}
