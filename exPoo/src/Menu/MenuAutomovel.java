package Menu;

import entites.AutoMovel;
import entites.Caminhao;
import entites.Carro;
import entites.Moto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAutomovel {
    private List<AutoMovel> listaAutoMovel;
    private Scanner entrada;


    public MenuAutomovel() {
        this.listaAutoMovel = new ArrayList<>();
        this.entrada = new Scanner(System.in);
    }

    public void MostrarMenu(){
        int escolha;

        do {
            System.out.println("-----Minha Garagem-----");
            System.out.println("1 - Adicionar Carro");
            System.out.println("2 - Adicionar Caminhão");
            System.out.println("3 - Adicionar Moto");
            System.out.println("4 - Exibir Lista");
            System.out.println("5 - Sair");
            System.out.print("Informe a opção: ");
            escolha = entrada.nextInt();

            switch (escolha){
                case 1:
                    adicionarCarro();
                    break;
                case 2:
                    adicionarCaminhao();
                    break;
                case 3:
                    adicionarMoto();
                    break;
                case 4:
                    exibirLista();
                    break;
                case 5:
                    System.out.println("Saindo....");
                    break;
                default:
                    System.out.println("Opção invalida");
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (escolha != 5);
    }

    private void adicionarCarro(){
        System.out.println("--- Adicionando Carro ---");
        System.out.print("Informe o nome da marca: ");
        String nomeMarca = entrada.next();
        System.out.print("Informe o nome do modelo: ");
        String nomeModelo = entrada.next();
        System.out.print("Informe a placa: ");
        String placa = entrada.next();

        Carro carro = new Carro (nomeMarca, nomeModelo, placa);
        listaAutoMovel.add(carro);
    }
    private void adicionarCaminhao(){
        System.out.println("--- Adicionando Caminhão ---");
        System.out.print("Informe o nome da marca: ");
        String nomeMarca = entrada.next();
        System.out.print("Informe o nome do modelo: ");
        String nomeModelo = entrada.next();
        System.out.print("Informe a placa: ");
        String placa = entrada.next();
        System.out.print("Informe a carga: ");
        double carga = entrada.nextDouble();

        Caminhao caminhao = new Caminhao (nomeMarca, nomeModelo, placa, carga);
        listaAutoMovel.add(caminhao);
    }
    private void adicionarMoto(){
        System.out.println("--- Adicionando Moto ---");
        System.out.print("Informe o nome da marca: ");
        String nomeMarca = entrada.next();
        System.out.print("Informe o nome do modelo: ");
        String nomeModelo = entrada.next();
        System.out.print("Informe a placa: ");
        String placa = entrada.next();

        Moto moto = new Moto (nomeMarca, nomeModelo, placa);
        listaAutoMovel.add(moto);
    }
    private void exibirLista() {
        System.out.println("------ Lista de Veículos ------");
        for (AutoMovel autoMovel : listaAutoMovel) {
            if (autoMovel instanceof Caminhao) {
                System.out.println("Tipo: Caminhão");
                System.out.println("Capacidade de Carga: " + ((Caminhao) autoMovel).getCarga());
            } else if (autoMovel instanceof Carro) {
                System.out.println("Tipo: Carro");
            } else {
                System.out.println("Tipo: Moto");
            }
            System.out.println("Marca: " + autoMovel.getNomeMarca());
            System.out.println("Modelo: " + autoMovel.getNomeModelo());
            System.out.println("Placa: " + autoMovel.getPlaca());
            System.out.println("----------------------");
        }
        System.out.println();
    }

}
