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


    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Pedido> getTodosPedidos() {
        return todosPedidos;
    }
}

