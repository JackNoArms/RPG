import Player.Jogador;

public class Mapa {
    public static int step;
    public static int x,y;
    public static int[][] mapa = new int[10][10];


    public Mapa(){

    }
    //Controla o jogador no mapa
    public void controle(String mover) {

            if ("a".equalsIgnoreCase(mover)) {
                    mover(-1, 0);
            } else if ("d".equalsIgnoreCase(mover)) {
                    mover(1, 0);
            } else if ("w".equalsIgnoreCase(mover)) {
                    mover(0, -1);
            } else if ("s".equalsIgnoreCase(mover)) {
                    mover(0, 1);
            }
        }
    //Desenha o mapa
    public void getMapa(){
        System.out.printf("%n%n%n%n%n%n%n%n%n________________________________________________%n");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if(j == x && i == y){
                        System.out.print("# ");
                    } else{
                        System.out.print(mapa[j][i] + " ");
                    }
                }
                System.out.println();
            }
        System.out.printf("%n________________________________________________%n");
    }
    //Faz o calculo para a movimentacao
    public void mover(int xSpd, int ySpd){
        int moveX = x + xSpd;
        int moveY = y + ySpd;
        if(moveX >= 0 && moveX < 10 && moveY >= 0 && moveY < 10 && mapa[moveX][moveY] == 0){
            x = moveX;
            y = moveY;

        }
    }
    //Conta os passos do jogador
    public void checkStep(){
        step++;
        if(step > 3){
            step = 0;
        }
    }
}