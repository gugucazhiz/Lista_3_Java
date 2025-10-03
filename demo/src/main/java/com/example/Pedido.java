package com.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private SimpleDateFormat Data;
    private String hora_compra;
    private String endereco;
    private int qtn_botijoes;

    public Pedido(SimpleDateFormat Data,String hora_compra,String endereco,List<Integer> qtn_botijoes){
        this.qtn_botijoes = qtn_botijoes;
        this.Data = Data;
        this.hora_compra = hora_compra;
        this.endereco = endereco;
    }

    
}
