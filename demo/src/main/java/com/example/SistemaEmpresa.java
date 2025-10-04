package com.example;

import java.util.ArrayList;
import java.util.List;

public class SistemaEmpresa {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    public List<Pedido> todosPedidos = new ArrayList<>();

    public Cliente cadastrarCliente(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Cliente já existe: " + nome);
                return c; 
            }
        }
        Cliente novo = new Cliente(nome);
        clientes.add(novo);
        System.out.println("Novo cliente cadastrado: " + nome);
        return novo;
    }

    public Funcionario cadastrarFuncionario(String nome){
        for(Funcionario f: funcionarios){
            if(f.getNome().equalsIgnoreCase(nome)){
                System.out.println("Funcionario já existe: "+ nome);
                return f;
            }
        }

        Funcionario novo = new Funcionario(nome, this);
        funcionarios.add(novo);
        System.out.println("Novo Funcionario cadastrado: " + nome);
        return novo;
    }

    public void addPedido(Pedido pedido){
        todosPedidos.add(pedido);
    }

    public void listarPedidos(){
        if(todosPedidos.isEmpty()){
            System.out.println("Nenhum Pedido Cadastrado. ");
        }
        else{
            for(Pedido p : todosPedidos){
                System.out.println("Nome: "+p.getNomeAssociado());
                System.out.println("Codigo:" +p.getCodPedido());
                System.out.println("Status:" +p.getStatus());
                System.out.println("Total: "+p.getTotalPedido());

                System.out.println("");
            }
        }
    }

    public Pedido listarEspecifico(int cod_pedido){
        for(Pedido p : todosPedidos){
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

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Pedido> getTodosPedidos() {
        return todosPedidos;
    }
}

