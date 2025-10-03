package com.example;

public class Funcionario implements Empresa {
    private String nome;
    
    public Funcionario(String nome){
        this.nome = nome;
    }

    @Override
    public void consultar(){
    }

    @Override
    public void consultarFechados(){

    }


    public String getNome(){
        return this.nome;
    }
}
