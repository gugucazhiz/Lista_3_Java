package uml.servicy;
import uml.entitys.*;


public class Jogavel extends Personagem implements Controle{
    private int nivel;

    public Jogavel(int nivel,String nome,int vitalidade,Jogo jogo){
        super(nome,vitalidade,jogo);
        if((nivel > 5) || (nivel < 0)){
            throw new IndexOutOfBoundsException("Nivel Não Permitido");
        }
        this.nivel = nivel;
        Jogo.addP(this);
    }

    @Override
    public void aplicarGolpeEspecial(Personagem adversario){
        adversario.setVitalidade(adversario.getVitalidade()-(getNivel()*10));
    }

    @Override
    public void botaoA(Personagem personagem) {
        // TODO Auto-generated method stub
        aplicarGolpeNormal(personagem);
    }

    @Override
    public void botaoB(Personagem personagem) {
        // TODO Auto-generated method stub
        aplicarGolpeEspecial(personagem);
    }
    @Override
    public Jogo getJogo() {
        // TODO Auto-generated method stub
        return super.getJogo();
    }
    @Override
    public String getNome() {
        // TODO Auto-generated method stub
        return super.getNome();
    }
    @Override
    public int getVitalidade() {
        // TODO Auto-generated method stub
        return super.getVitalidade();
    }
    public int getNivel() {
        return nivel;
    }

    @Override
    public void setJogo(Jogo jogo) {
        // TODO Auto-generated method stub
        super.setJogo(jogo);
    }
    @Override
    public void setNome(String nome) {
        // TODO Auto-generated method stub
        super.setNome(nome);
    }

    @Override
    public void setVitalidade(int vitalidade) {
        // TODO Auto-generated method stub
        super.setVitalidade(vitalidade);
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
