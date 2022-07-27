import Inimigos.Cobra;
import Inimigos.Inimigo;
import Inimigos.Lobo;
import Inimigos.Slime;
import Player.Jogador;

import java.security.SecureRandom;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mapa mapa = new Mapa();
        Inimigo inimigo;

        //Recebe o nome do Jogador
        System.out.println("Qual o seu nome?");
        Jogador jogador = new Jogador(scanner.next());

        //loop Geral
        boolean loop = true;
        while(loop) {

            //Cria o mapa
            mapa.getMapa();

            //Pega a string e compara com WASD que está em mapa
            System.out.println(jogador.getNome() + " use WASD para se mover pelo mapa.");
            String controle = scanner.next();
            mapa.controle(controle);
            mapa.getMapa();

            //Conta os passos para procurar um inimigo
            mapa.checkStep();

            //A cada 3 passos no mapa acha um inimigo
            if (Mapa.step == 3) {
                int I = new SecureRandom().nextInt(8);
                if(I <= 2){
                    inimigo = new Slime();
                }else if(I > 2 && I < 6){
                    inimigo = new Lobo();
                }else{
                    inimigo = new Cobra();
                }

                System.out.println("Apareceu um inimigo: " + inimigo.getNome());

                //Para o loop geral
                loop = false;

                //Inicia o loop da batalha
                boolean loopB = true;
                    while (loopB) {
                        System.out.printf("________________________________________________");

                        //Mostra o status do jogador
                        jogador.getStatus();
                        System.out.printf("%n%n________________________________________________%n%n");

                        //Mostra o status do inimigo atual
                        inimigo.getStatus();
                        System.out.printf("________________________________________________");
                        System.out.printf("%n[%d]Batalhar [%d]Status [%d]Curar [%d]Fugir %n", 1, 2, 3, 4);
                        int opcao = scanner.nextInt();

                        if(opcao == 1){

                            //loop para que enquanto estiverem vivos tanto o jogador quanto o inimigo
                            while (inimigo.isVivo() && jogador.isVivo()) {
                                inimigo.danoRecebido(jogador.getAtk());
                                System.out.println(jogador.getNome() + " deu " + jogador.getAtk() + " de dano!");

                                /*Verifica se o inimigo ainda está vivo e se estiver o inimigo ataca
                                Se apenas o jogador estiver vivo ativa o else que dá xp para o jogador*/
                                if (inimigo.isVivo()) {
                                jogador.danoRecebido(inimigo.getAtk());
                                System.out.println(inimigo.getNome() + " deu " + inimigo.getAtk() + " de dano!");
                                } else {
                                jogador.upar(inimigo.getXp());
                                loopB = false;
                                loop = true;
                                }
                                break;
                            }
                        } else if (opcao == 2) {

                            //Mostra o status quando é solicitado
                            jogador.getStatus();

                        } else if (opcao == 3) {

                            //Aumenta a vida do jogador
                            jogador.cura();

                        } else {
                            //Foge da luta
                            System.out.println("Voce fugiu!");
                            loop = true;
                            break;
                        }
                    }
            }
            continue;
        }
    }
}