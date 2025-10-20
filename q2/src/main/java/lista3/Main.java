package lista3;

import lista3.util.*;

public class Main {
    public static void main(String[] args) {
        boolean passou = false;

        while(!passou){ //sem esse while se o usuario digitar algo errado +1x ele não da catch
            try {
                Movimentos movimento = new Movimentos();
                movimento.movimentos();
                passou = true;
            } catch (IndexOutOfBoundsException e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
        }
    }
}