package princip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Define uma classe chamada JogoDaMemoria, que estende JFrame (classe de janela GUI do Java)
public class JogoDaMemoria extends JFrame {

    // Declara variáveis de instância
    private List<String> cartas;        // Lista para armazenar os valores das cartas
    private List<JButton> botoes;       // Lista para armazenar os botões que representam as cartas
    private int cartaAtual = -1;         // Índice da carta atualmente virada
    private int cartaAnterior = -1;      // Índice da carta virada anteriormente

    // Construtor para a classe JogoDaMemoria
    public JogoDaMemoria() {
        // Inicializa os valores das cartas e os botões
        cartas = new ArrayList<>();
        botoes = new ArrayList<>();

        // Adiciona 8 pares de cartas à lista
        for (int i = 0; i < 8; i++) {
            cartas.add(String.valueOf(i));
            cartas.add(String.valueOf(i));
        }

        // Embaralha as cartas aleatoriamente
        Collections.shuffle(cartas);

        // Configura a interface gráfica
        setTitle("Jogo da Memória");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 4));  // Define o layout como uma grade 4x4

        // Cria botões para as cartas
        for (int i = 0; i < 16; i++) {
            JButton button = new JButton("?");  // Cria um botão com "?" como texto inicial

            // Configura a fonte
            Font buttonFont;
            if (Character.isDigit(cartas.get(i).charAt(0))) {
                // Se o valor da carta for um número, usa um tamanho de fonte maior
                buttonFont = new Font("Arial", Font.BOLD, 20);
            } else {
                // Caso contrário, usa um tamanho de fonte menor para o caractere "?"
                buttonFont = new Font("Arial", Font.PLAIN, 16);
            }
            button.setBackground(Color.WHITE);  // Configura a cor de fundo como branca

            button.setFont(buttonFont);
            final int index = i;

            // Adiciona um ouvinte de ação para cada botão
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    virarCarta(index);
                }
            });
            add(button);
            botoes.add(button);
        }

        setVisible(true);
    }

    // Método para virar uma carta
    private void virarCarta(int index) {
        if (cartaAtual == -1) {
            cartaAtual = index;
            botoes.get(index).setText(cartas.get(index));
        } else {
            botoes.get(index).setText(cartas.get(index));
            cartaAnterior = cartaAtual;
            cartaAtual = -1;

            // Verifica se as cartas são iguais
            if (!cartas.get(cartaAnterior).equals(cartas.get(index))) {
                // Se não forem iguais, aguarde um pouco e, em seguida, vire as cartas de volta
                Timer timer = new Timer(750, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        botoes.get(cartaAnterior).setText("?");
                        botoes.get(index).setText("?");
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

            // Verifica se todas as cartas foram encontradas
            if (todasCartasEncontradas()) {
                JOptionPane.showMessageDialog(this, "Parabéns! Você encontrou todos os pares!");
                System.exit(0);
            }
        }
    }

    // Método para verificar se todas as cartas foram encontradas
    private boolean todasCartasEncontradas() {
        for (JButton button : botoes) {
            if (button.getText().equals("?")) {
                return false;
            }
        }
        return true;
    }

    // Método principal para iniciar o jogo
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JogoDaMemoria();
            }
        });
    }
}