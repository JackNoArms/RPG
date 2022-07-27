package Inimigos;
import java.security.SecureRandom;

public class Inimigo {
    private final String nome;
    private int vida;
    private final int mvida;
    private final int nivel;
    private final int xp;
    private final int atk;

    public Inimigo(String nome, int mvida, int atk, int nivel, int xp, int vida) {
        this.mvida = mvida;
        this.vida = mvida;
        this.atk = atk;
        this.nivel = nivel;
        this.xp = xp;
        this.nome = nome;

    }

    public int getAtk() {
        return this.atk;
    }
    //Calcula o dano recebido e deduz da vida atual
    public int danoRecebido(int atk) {
        this.vida = this.vida - atk;
        System.out.printf("%s recebeu %d de dano!%n", this.nome, atk);
        return this.vida;
    }

    //Cria e desenha uma barra de vida
    public String getBVida() {
        String Bvida = "";
        int vida1 = vida * 10 / mvida;
        for (int i = 0; i < vida1; i++) {
            Bvida = Bvida + "-";
        }
        return Bvida;
    }

    //Confere se está vivo
    public boolean isVivo() {
        return this.vida > 0;
    }

    //Ao morrer dá o xp para o jogador de acordo com o inimigo que foi achado
    public int getXp() {
        System.out.printf("%s morreu e deu %d de XP%n", this.nome, this.xp);
        return this.xp;
    }

    public void getStatus(){
        System.out.printf("%n%s%nNivel: %2d%nHP...: %2d / %2d (%-10s)%nAtk..: %2d%n",this.nome,this.nivel,this.vida,this.mvida,getBVida(),getAtk());
    }

    public String getNome(){
        return this.nome;
    }

}
