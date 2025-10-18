package lista3.entity;

import java.util.ArrayList;
import java.util.List;

import lista3.service.Empresa;
import lista3.service.PuxarDados;

public class Comercial extends Residencia implements Empresa,PuxarDados{
    private final double dolar = 6.5;
    private float total =0;
    private String nome;
    private String setor;
    private String cadastrarCnpj;
    private List<Integer> vendas = new ArrayList<>();
    private List<String> tipoVenda = new ArrayList<>();
    private String localizacao;
    private int abertura;
    private int fechamento;
    private Boolean isUrbana;

    public Comercial(String nome,String cadastrarCnpj,String localizacao){
        this.cadastrarCnpj = cadastrarCnpj;
        this.nome = nome;
        this.localizacao = localizacao;
    }
    public Comercial(String nome,String cadastrarCnpj,String localizacao,Boolean isUrbana){
        this.cadastrarCnpj = cadastrarCnpj;
        this.nome = nome;
        this.localizacao = localizacao;
        this.isUrbana = isUrbana;
    }
    public Comercial(String nome,String setor,String cadastrarCnpj,String localizacao){
        this.nome = nome;
        this.setor = setor;
        this.cadastrarCnpj = cadastrarCnpj;
        this.localizacao = localizacao;
    }

    @Override
    public Boolean isUrbana() {
        // TODO Auto-generated method stub
        return isUrbana;
    }
    public void addVenda(int vendas){
        this.vendas.add(vendas);
        this.tipoVenda.add("Não Informado");
    }

    public void addVenda(int vendas,String tipoVenda){
        this.vendas.add(vendas);
        this.tipoVenda.add(tipoVenda);
        System.out.println("Venda do tipo: "+tipoVenda);
    }

    @Override
    public Float analiseDeMercado() {
        int i =0;
        System.out.println("-----------------Estoque-------------");
        for (Integer v1 : vendas) {
            System.out.println(i+")Venda, total de itens vendidos: "+v1);
            System.out.println("Venda do tipo: "+tipoVenda.get(i));
            this.total += v1;
            System.out.println();
            i++;
        };
        System.out.println("-----------------Estoque-------------");
        return  (float) (total*dolar);
    }

    @Override
    public String AnaliseCnpj() {
        // TODO Auto-generated method stub
        if(!vendas.isEmpty()){
            return "Cnpj de "+nome+" Esta Ativo";
        }
        return "Cnpj não possui transações realizadas";
    }
    @Override
    public String localizacao() {
        // TODO Auto-generated method stub
        return "Localizacao da empresa: "+localizacao;
        
    }
    @Override
    public void funcionamento() {
        // TODO Auto-generated method stub
        System.out.println("Funcionamento de Atendimento: "+PuxarDados.abertura+
        " Ate "+PuxarDados.fechamento);
    }

    public void funcionamento(int abertura,int fechamento) {
        // TODO Auto-generated method stub
        System.out.println("Funcionamento de Atendimento: "+abertura+
        " Ate "+fechamento);
    }

    public String getCadastrarCnpj() {
        return cadastrarCnpj;
    }

    public void setCadastrarCnpj(String cadastrarCnpj) {
        this.cadastrarCnpj = cadastrarCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public List<Integer> getVendas() {
        return vendas;
    }

    
}
