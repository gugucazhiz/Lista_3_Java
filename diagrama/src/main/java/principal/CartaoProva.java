package principal;

public class CartaoProva implements Pontuacao{
    private int acertos;
    private int erros;

    CartaoProva(int acertos, int erros){
        this.acertos = acertos;
        this.erros = erros;
    }

    @Override
    public double CalcularPontos() {
        return acertos*2 - erros;
    }
}
