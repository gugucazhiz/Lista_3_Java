package com.example;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements Empresa{
    private List<Pedido> pedidos = new ArrayList<>();

    public void consultar(){
        for(Pedido p : pedidos){
            System.out.println(p.cod_pedido);
        }
    }
}
