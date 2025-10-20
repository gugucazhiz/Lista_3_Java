package principal;

public class Futebol extends Clube {
    private int vitorias;
    private int empates;
    private int derrotas;
    private String nome;

    Futebol(int vitorias, int empates, int derrotas, String nome){
        super(nome);
        this.vitorias = vitorias;
        this.empates = empates;
        this.derrotas = derrotas;
    }

    @Override
    public double CalcularPontos() {
        return (vitorias*3+empates);
    }



    public int getVitorias() {
        return vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public int getDerrotas() {
        return derrotas;
    }
    @Override
    public String getNome() {
        return super.getNome();
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }
}
