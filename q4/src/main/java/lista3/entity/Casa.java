package lista3.entity;

public class Casa extends Moradia{
    private int numero;
    private Boolean quintal;
    public Casa(String proprietario,String endereco,int numero,Boolean quintal){
        super(proprietario, endereco);
        this.numero = numero;
        this.quintal = quintal;
    }
    
    public Casa(String proprietario,String endereco,int numero,int quantidadeDeAndares,Boolean quintal){
        super(proprietario, endereco,quantidadeDeAndares);
        this.numero = numero;
        this.quintal = quintal;
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
}
