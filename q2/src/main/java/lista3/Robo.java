package lista3;

public class Robo {
    private int[] linha = new int[13];
    private int[] coluna = new int[23];
    private float passo;
    private int y;
    private int x;

    public Robo(int y,int x){
        this.y = y;
        this.x = x;
    }
    //posicoes proibidas linha = 0, coluna =0 || linha =8, coluna 18;
    public void desenharMapa(){
        for(int i = 0; i < linha.length; i++){
            for(int j=0; j < coluna.length; j++){
                if(i==0 || i == linha.length-1){
                    System.out.print("-");
                }
                else if(j==0 || j==coluna.length-1){
                    System.out.print("|");
                }
                else{
                    if(this.y == i && this.x ==j){
                        System.out.print("1");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("");
        }
    }

    public void mostrarPosAtual(){
        System.out.println("\nPos y:" +(this.y -1) +" \nPos x:"+(this.x -1)+"\nDigite um numero para continuar."); 
    }

    public void andarFrente(float passo){
        this.passo = passo;
        this.y +=passo;
       if(!verificar()){
            this.y -=passo;
        }
    }

    public void andartras(float passo){
        this.passo = passo;
        this.y -=passo;
        if(!verificar()){
            this.y +=passo;
        }
    }

    public void andarEsquerda(float passo){
        this.passo = passo;
        this.x -= passo;
        if(!verificar()){
            this.x +=passo;
        }
    }

    public void andarDireita(float passo){
        this.passo = passo;
        this.x += passo;
        if(!verificar()){
            this.x -=passo;
        }
    }

    public boolean verificar(){
        if(this.y <= 0 || this.y > 11){
            System.out.println("Valor Invalido");
            return false;
        }
        if(this.x <= 0 || this.x > 21){
            System.out.println("Valor Invalido");
            return false;
        }
        else{
            return true;
        }
    }

    public void menu(){
        desenharMapa();
        System.out.println("1)Andar Para Frente");
        System.out.println("2)Andar Para Tras");
        System.out.println("3)Andar Para Esquerda");
        System.out.println("4)Andar Para Direita");
        System.out.println("5)Mostrar Posicao Atual");
        System.out.println("");
        System.out.println("Digite: ");
    }
}
