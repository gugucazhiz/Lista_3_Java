package lista3.entity;

import java.time.LocalDate;

public class Moradia extends Residencia{
    private String proprietario;
    private String endereco;
    private String alugadoPara;
    private int quantidadeDeAndares;
    private Boolean isUrbana;
    private LocalDate diaUltimaReforma;
    
    public Moradia(String proprietario,String endereco){
        this.proprietario = proprietario;
        this.endereco = endereco;
    }
    public Moradia(String proprietario,String endereco,boolean isUrbana){
        this.proprietario = proprietario;
        this.endereco = endereco;
        this.isUrbana = isUrbana;
    }
    public Moradia(String proprietario,String endereco,int quantidadeDeAndares){
        this.proprietario = proprietario;
        this.endereco = endereco;
        this.quantidadeDeAndares = quantidadeDeAndares;
    }
    @Override
    public String localizacao() {
        // TODO Auto-generated method stub
        return "Endereço: "+endereco;
    }
    
    @Override
    public Boolean isUrbana() {
        // TODO Auto-generated method stub
        return this.isUrbana;
    }
    public void reformar(){
        this.diaUltimaReforma = LocalDate.now();
    }
    public LocalDate getUltimaReforma(){
        return this.diaUltimaReforma;
    }

    public void alugar(String alugadoPara){
        this.alugadoPara = alugadoPara;
    }

    public void desocupar(){
        this.alugadoPara = "Desocupado";
    }

    public void vender(String proprietario){
        this.proprietario = proprietario;
    }

    public String getAlugadoPara() {
        return this.alugadoPara;
    }

    public String getProprietario() {
        return proprietario;
    }
    public int getQuantidadeDeAndares() {
        return quantidadeDeAndares;
    }
}
