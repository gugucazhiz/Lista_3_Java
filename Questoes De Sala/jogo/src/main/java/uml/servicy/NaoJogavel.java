package uml.servicy;
import uml.entitys.*;


public class NaoJogavel extends Personagem{
    private boolean aliado;

    public NaoJogavel(boolean aliado,String nome,int vitalidade,Jogo jogo){
        super(nome,vitalidade,jogo);
        this.aliado = aliado;
        Jogo.addP(this);
    }

    @Override
    public void aplicarGolpeEspecial(Personagem adversario){
        switch (Jogo.getDificuldade()) {
            case EASY:
                adversario.setVitalidade(getVitalidade()-20);
                break;
            case MEDIUM:
                adversario.setVitalidade(getVitalidade()-30);
                break;
            case HARD:
                adversario.setVitalidade(getVitalidade()-40);
                break;
            default:
                break;
        }
    }

    public boolean isAliado() {
        return aliado;
    }

    public void setAliado(boolean aliado) {
        this.aliado = aliado;
    }
}
