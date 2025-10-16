package lista3.entity;

import lista3.servicy.Empresa;
import lista3.servicy.PuxarDados;

public class Comercial extends Residencia implements Empresa,PuxarDados{
    private final double dolar = 6.5;
    private String nome;
    private String setor;
    private String cadastrarCnpj;
    private int vendas;
    private int estoque;
    private String localizacao;
    private String tipoVenda;
    private int abertura;
    private int fechamento;

    public Comercial(String nome,String cadastrarCnpj,String localizacao){
        this.cadastrarCnpj = cadastrarCnpj;
        this.nome = nome;
        this.localizacao = localizacao;
    }
    public Comercial(String nome,String setor,String cadastrarCnpj,String localizacao){
        this.nome = nome;
        this.setor = setor;
        this.cadastrarCnpj = cadastrarCnpj;
        this.localizacao = localizacao;
    }

    public void addVenda(int vendas){
        this.vendas += vendas;
    }

    public void addVenda(int vendas,String tipoVenda){
        this.vendas += vendas;
        System.out.println("Venda do tipo: "+tipoVenda);
    }

    @Override
    public float analiseDeMercado() {
        return (float)(vendas*dolar);
    }

    @Override
    public String AnaliseCnpj() {
        // TODO Auto-generated method stub
        if(vendas>= 1){
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

    public int getVendas() {
        return vendas;
    }

    public void setVendas(int vendas) {
        this.vendas = vendas;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    
}
