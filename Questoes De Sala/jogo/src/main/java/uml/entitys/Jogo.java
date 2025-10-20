package uml.entitys;
import java.util.ArrayList;
import java.util.List;


public class Jogo {
    static private  Dificuldade.dificuldade dificuldade;
    static private List<Personagem> personagens = new ArrayList<>();

    public Jogo(Dificuldade.dificuldade dificuldade){
        this.dificuldade = dificuldade;
    }
    static public Dificuldade.dificuldade getDificuldade() {
        return dificuldade;
    }

    static public void removeP(Personagem personagem){
        personagens.remove(personagem);
    }

    static public void addP(Personagem personagem){
        personagens.add(personagem);
    }

    public static List<Personagem> getPersonagens() {
        return personagens;
    }
}
