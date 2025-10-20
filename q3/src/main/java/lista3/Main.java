package lista3;

import lista3.service.*;
import lista3.util.FileHandler;;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        CreatePlayer createPlayer = new CreatePlayer();
        CreateGame game = new CreateGame(createPlayer,fileHandler);

        game.bemVindo();
    }
}