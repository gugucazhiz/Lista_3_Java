package principal;


public class Vantagem implements Pontuacao{
    private double milhas;

    Vantagem(double milhas){
        this.milhas = milhas;
    }

    @Override
    public double CalcularPontos() {
        return milhas*1.5;
    }

    public double getMilhas() {
        return milhas;
    }

    public void setMilhas(double milhas) {
        this.milhas = milhas;
    }
}