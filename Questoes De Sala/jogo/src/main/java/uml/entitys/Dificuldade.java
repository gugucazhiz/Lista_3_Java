package uml.entitys;

public class Dificuldade {
    public enum dificuldade{
        EASY(0),
        MEDIUM(1),
        HARD(2);

        private final int valor;

        dificuldade(int valor){
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }
    }
}
