package lista3.entity;

public class Moradia extends Residencia{
    private String proprietario;
    private String endereco;
    private String alugadoPara;
    private int quantidadeDeAndares;

    public Moradia(String proprietario,String endereco){
        this.proprietario = proprietario;
        this.endereco = endereco;
    }
    public Moradia(String proprietario,String endereco,int quantidadeDeAndares){
        this.proprietario = proprietario;
        this.endereco = endereco;
        this.quantidadeDeAndares = quantidadeDeAndares;
    }
    @Override
    public String localizacao() {
        // TODO Auto-generated method stub
        return "Endereço: "+endereco+" do proprietario: "+proprietario;
    }
    
    public void alugar(String alugadoPara){
        this.alugadoPara = alugadoPara;
    }

    public void desocupar(){
        this.alugadoPara = "";
    }

    public void vender(String proprietario){
        this.proprietario = proprietario;
    }

    public String getAlugadoPara() {
        return alugadoPara;
    }

    public String getProprietario() {
        return proprietario;
    }

}
