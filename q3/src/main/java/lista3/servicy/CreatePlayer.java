package lista3.servicy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lista3.entity.*;

public class CreatePlayer {
    private List<Jogador> jogadores = new ArrayList<>();
    

    public Boolean criarJogador(String nome){
        try {
            Boolean notExiste = true;
            for (Jogador jogador : jogadores) {
                if(jogador.getNome().toLowerCase().equals(nome.toLowerCase())){
                    notExiste = false;
                    System.out.println("Ja Existe Um Jogador Com Este Nome: "+nome);
                    System.out.println();
                    break;
                }
            }
            if(notExiste){
                jogadores.add(new Jogador(nome));
                System.out.println("");
                System.out.println("Jogador De Nome: "+nome);
                System.out.println("Adicionado A partida.");
                System.out.println("Total De jogadores: "+jogadores.size());
                System.out.println("");
            }
        } catch (IllegalStateException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void ordenarJogadores(){
        Collections.sort(jogadores , new Comparator<Jogador>() {
            @Override
            public int compare(Jogador j1,Jogador j2){
                return Integer.compare(j2.getPontuacao(), j1.getPontuacao());
            }
        });
    }

    public List<Jogador> getJogadores(){
        return jogadores;
    }
}
