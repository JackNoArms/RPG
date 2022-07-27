package Player;

public class Jogador {

    private String nome;
    private int vida,mvida;
    private int nivel;
    private int xp;
    private int mxp;
    private int atk;

    public Jogador(String nome){
        this.nome = nome;
        this.mvida = 10;
        this.vida = 10;
        this.atk = 5;
        this.nivel = 1;
        this.mxp = 10;
    }

    public String getNome() {
        return nome;
    }
    public void getStatus(){
        System.out.printf("%n%s%nNivel: %2d%nHP...: %2d / %2d (%-10s)%nAtk..: %2d%n",this.nome,this.nivel,this.vida,this.mvida,getBVida(),getAtk());
        getBXp();
    }
    //Cria e desenha uma barra de xp
    public void getBXp(){
        String Bxp = "";
        int xp1 = xp*10/mxp;
        for (int i = 0; i < xp1; i++) {
            Bxp = Bxp + "-";
            if(xp <= 0){
                Bxp = "";
            }
        }
        System.out.printf("XP...: %2d / %2d (%-10s)%n",this.xp,this.mxp,Bxp);

    }
    //Cria e desenha uma barra de vida
    public String getBVida(){
        String Bvida = "";
        int vida1 = vida * 10 / mvida;
        for (int i = 0; i < vida1; i++) {
            Bvida = Bvida + "-";
        }
        return Bvida;
    }
    public int getAtk(){
        return this.atk;
    }
    //Calcula o dano recebido e deduz da vida atual
    public int danoRecebido(int atk){
        this.vida = this.vida - atk;
        System.out.printf("%s recebeu %d de dano!%n", this.nome, atk);
        return this.vida;
    }
    //Aumenta o nivel e status
    public void upar(int xp){
        this.xp += xp;
        while(this.xp >= mxp){
            this.xp -= mxp;
            nivel ++;
            mxp += 10;
            atk += 1;
            mvida += 10;
        }
    }
    //Confere se está vivo
    public boolean isVivo(){
        if(vida <= 0){
            System.out.printf("%n%s morreu!%n", this.nome);
            return false;
        }else{
            return true;
        }
    }
    //Recupera a vida do jogador
    public void cura(){
        this.vida = this.mvida;
        System.out.println("Voce foi curado!");
    }
}
