package lista3.entity;

import lista3.service.PuxarDados;

public class Apartamento extends Moradia implements PuxarDados{
    private int andar;
    private String motivo;
    
    public Apartamento(String proprietario,String endereco,int andar){
        super(proprietario, endereco);
        this.andar = andar;
    }

    public void mudarEndereco(int andar){
        this.andar = andar;
    }

    public void mudarEndereco(int andar,String motivo){
        this.andar = andar;
        this.motivo = motivo;
    }
    @Override
    public void funcionamento() {
        // TODO Auto-generated method stub
        System.out.println("Funcionamento da Portaria Do Apartamento: "+PuxarDados.abertura+
        " Ate "+PuxarDados.fechamento);
    }

    @Override
    public void alugar(String alugadoPara) {
        // TODO Auto-generated method stub
        super.alugar(alugadoPara);
    }

    @Override
    public void desocupar() {
        // TODO Auto-generated method stub
        super.desocupar();
    }

    @Override
    public void vender(String proprietario) {
        // TODO Auto-generated method stub
        super.vender(proprietario);
    }

    public int getAndar() {
        return andar;
    }

    public String getLocalizacao(){
        return super.localizacao();
    }

    @Override
    public String getAlugadoPara() {
        // TODO Auto-generated method stub
        return super.getAlugadoPara();
    }

    public String getMotivo() {
        return motivo;
    }
}
