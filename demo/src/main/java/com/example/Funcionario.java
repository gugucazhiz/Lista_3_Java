package com.example;

public class Funcionario implements Empresa {
    private String nome;
    private SistemaEmpresa sistemaEmpresa = new SistemaEmpresa();
    
    public Funcionario(String nome){
        this.nome = nome;
    }

    @Override
    public void consultar(){
        for(Pedido p : sistemaEmpresa.todosPedidos){
            if(p.getStatus().equals("Aberto")){
                System.out.println("Nome: "+p.getNomeAssociado());
                System.out.println("Codigo:" +p.getCodPedido());
                System.out.println("Status:" +p.getStatus());
                System.out.println("Total: "+p.getTotalPedido());
            }
        }
    }

    @Override
    public void consultarFechados(){
        for(Pedido p : sistemaEmpresa.todosPedidos){
            if(p.getStatus().equals("Concluido")){
                System.out.println("Nome: "+p.getNomeAssociado());
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
