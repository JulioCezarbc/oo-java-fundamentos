package func;

import java.util.Scanner;

public class qf {
    public static final int numPistas = 5;
    public static final int numTentativas = 5;
    public static void dicas(String[] dicas, Scanner entrada) {

        for (int i = 0; i < numPistas; i++) {
            System.out.print("Jogador 1 - Informe a pista " + (i + 1) + ": ");
            dicas[i] = entrada.nextLine();
        }
    }


    public static int jogador2(String nomeFilme, String[] pistas, Scanner entrada) {

        int pontuacao = 0;

        System.out.println("\nPista 1; " + pistas[0]);

        for (int tent = 1; tent <= numTentativas; tent++) {
            System.out.println("\nJogador 2 - Qual o nome do filme? ");
            String tentativaUsu = entrada.nextLine();

            if (compFilmes(tentativaUsu, nomeFilme)) {
                pontuacao = pont(tent);
                System.out.println("Você acertou! +" + pontuacao + " pontos!");
                break;
            } else {
                System.out.println("Você errou!");

                if (tent > 1) {
                    System.out.println();
                    pistas(pistas, tent);
                }
            }
        }

        return pontuacao;
    }


    public static boolean compFilmes(String tentativaUsuario, String nomeFilme) {
        return tentativaUsuario.equalsIgnoreCase(nomeFilme);
    }

    public static void pistas(String[] pistas, int tentativa) {
        System.out.println("    \tPistas");
        for (int i = 0; i < tentativa; i++) {
            System.out.println("\tPista " + (i + 1) + "; " + pistas[i]);
        }
    }

    public static int pont(int tent) {
        return switch (tent) {
            case 1 -> 100;
            case 2 -> 60;
            case 3 -> 40;
            case 4 -> 20;
            case 5 -> 10;
            default -> 0;
        };
    }
}
