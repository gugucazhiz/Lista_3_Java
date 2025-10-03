package com.example;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements Empresa{
    private List<Pedido> pedidos = new ArrayList<>();
    private String nome;

    public Cliente(String nome){
        this.nome = nome;
    }

    public void addPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public  void consultar(){
        System.out.println(this.nome+" tem Esses Pedidos Cadastrados em aberto");
        for(Pedido p : pedidos){
            if(p.getStatus().equals("Aberto")){
                System.out.println("Codigo:" +p.getCodPedido());
                System.out.println("Status:" +p.getStatus());
                System.out.println("Total: "+p.getTotalPedido());
            }
            System.out.println("");
        }
    }

    public  void consultarFechados(){
        System.out.println(this.nome+" tem Esses Pedidos Cadastrados Concluidos");
        for(Pedido p : pedidos){
            if(p.getStatus().equals("Fechado")){
                System.out.println("Codigo:" +p.getCodPedido());
                System.out.println("Status:" +p.getStatus());
            }
        }
    }


    public String getNome(){
        return this.nome;
    }
}
