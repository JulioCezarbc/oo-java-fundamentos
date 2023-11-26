package princip;
import func.qf;
import java.util.Scanner;


public class QualOFilme {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Jogador 1 - Informe o nome do filme: ");
        String nomeFilme = entrada.nextLine();
        String[] pistas = new String[5];

        qf.dicas(pistas, entrada);

        int pontuacao = qf.jogador2(nomeFilme, pistas, entrada);
        System.out.println("\nPontuação final do Jogador 2: " + pontuacao);

        entrada.close();
    }
}