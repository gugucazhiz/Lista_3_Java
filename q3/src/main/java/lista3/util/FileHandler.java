package lista3.util;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lista3.entity.Jogador;
import lista3.service.*;

public class FileHandler {
    
    public void salvar(CreatePlayer player){
        String output = "save.csv";
        try(FileWriter writer = new FileWriter(output)) {

            writer.append("nome,id,pontuacao,saldo\n");

            for (Jogador j : player.getJogadores()) {
                writer.append(j.getNome())
                .append(",")
                .append(String.valueOf(j.getId()))
                .append(",")
                .append(String.valueOf(j.getPontuacao()))
                .append(",")
                .append(String.valueOf(j.getSaldo()))
                .append("\n");
            }
        }
        catch (IOException e) {
                System.out.println(e.getMessage());
        }
    }

    public CreatePlayer carregar(){
        String input = "save.csv";
        CreatePlayer carregando = new CreatePlayer();
        int i =0;
        try(Stream<String> linhas =Files.lines(Paths.get(input))){
            List<List<String>> dados = linhas
            .map(linha -> Arrays.asList(linha.split(",")))
            .collect(Collectors.toList());
        

            if(!dados.isEmpty() && dados.size() > 1){
                dados.remove(0);
                    System.out.println("Carregando os Dados de: ");
                    System.out.println();
                for (List<String> linha : dados) {
                    System.out.println(linha.get(0));
                    carregando.criarJogador(linha.get(0));
                    carregando.getJogadores().get(i).setId(Integer.parseInt(linha.get(1)));
                    carregando.getJogadores().get(i).setPontuacao(Integer.parseInt(linha.get(2)));
                    carregando.getJogadores().get(i).loadSaldo(Float.parseFloat(linha.get(3)));
                    i++;
                }
                return carregando;
/* ler os jogadores adicionados /// para TESTE
                for (Jogador j : carregando.getJogadores()) {
                    System.out.println();
                    System.out.println("Jogador: "+j.getNome());
                    System.out.println("Id: "+j.getId());
                    System.out.println("Partidas Ganhas: "+j.getPontuacao());
                    System.out.println();
        }
*/
            }
            else{
                apagar();
            }
        }
        catch (IOException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return carregando;
    }

    public void apagar(){
        String output = "save.csv";

        try(FileWriter write = new FileWriter(output)) {
            Jogador.limite = 0; //estava dando erro, a base de jogadores era apagada, mas limite continuava
            //incrementando de onde parou
            write.append("");          
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}
