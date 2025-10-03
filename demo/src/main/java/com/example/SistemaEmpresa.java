package com.example;

import java.util.ArrayList;
import java.util.List;

public class SistemaEmpresa {
    private List<Cliente> clientes = new ArrayList<>();

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

    public List<Cliente> getClientes() {
        return clientes;
    }
}

