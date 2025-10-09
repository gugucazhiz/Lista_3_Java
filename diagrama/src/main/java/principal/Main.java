package principal;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.PointLight;

public class Main {
    public static void main(String[] args) {
        List<Pontuacao>  pontos = new ArrayList<>();

        pontos.add(new Futebol(1, 0, 0,"Milan"));
        pontos.add(new Vantagem(1));
        pontos.add(new CartaoProva(1, 0));
        
        for(Pontuacao i : pontos){
            System.out.println(i.CalcularPontos());
        }
    }
}