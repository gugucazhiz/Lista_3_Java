package com.example;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;


public class Pedido {
    final static float valor_botijao = 80.00f;
    static int contador =0;
    private int cod_pedido;
    private LocalDate Data;
    private LocalTime hora;
    private String endereco;
    private int qtn_botijoes;
    private String status_do_pedido ="Não Concluido";
    private String cartao;

    public Pedido(LocalDate Data,LocalTime hora,String endereco,int qtn_botijoes){
        this.qtn_botijoes = qtn_botijoes;
        this.Data = Data;
        this.endereco = endereco;
        this.hora = hora;
        contador += 1;
        this.cod_pedido=contador;
    }

    public static String  totalPedido(int qtn_botijoes){
        return qtn_botijoes>=1? Float.toString(valor_botijao * qtn_botijoes) : "No Minimo 1 Botijao";
    }

    public void efetuarPagamento(String cartao){
        this.cartao = cartao;
        status_do_pedido = "Aberto";
    }
    @Override
    public String toString() {
        return "Endereço: "+this.endereco+"\n"+
               "Data: "+this.Data+"\n"+
               "Hora: "+this.hora+"\n"+
               "Quantidade: "+this.qtn_botijoes+"\n"+
               "Total: "+totalPedido(qtn_botijoes)+"\n"+
               "Previsão De Entrega: "+this.hora.plusHours(2);
    }


    public String getStatus(){
        return this.status_do_pedido;
    }

    public int getCodPedido(){
        return this.cod_pedido;
    }

    public Float getTotalPedido(){
        return (valor_botijao * qtn_botijoes);
    }
}
