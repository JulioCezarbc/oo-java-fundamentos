package View;

import Controller.AutomovelController;
import Model.AutoMovel;
import Model.Caminhao;
import Model.Carro;
import Model.Moto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAutomovel {
    private List<AutoMovel> listaAutoMovel;
    private final AutomovelController controller;
    private final Scanner entrada;

    public MenuAutomovel(List<AutoMovel> listaAutoMovel, AutomovelController controller) {
        this.listaAutoMovel = new ArrayList<>();
        this.controller = controller;
        this.entrada = new Scanner(System.in);
    }

    public void mostrarMenu() {
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

            switch (escolha) {
                case 1 -> adicionarCarro();
                case 2 -> adicionarCaminhao();
                case 3 -> adicionarMoto();
                case 4 -> exibirLista();
                case 5 -> System.out.println("Saindo....");
                default -> System.out.println("Opção invalida");
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (escolha != 5);
    }

    private void adicionarCarro() {
        try {
            System.out.println("--- Adicionando Carro ---");

            System.out.print("Informe o nome da marca: ");
            String nomeMarca = entrada.next();
            if (!validarApenasLetras(nomeMarca)) {
                throw new RuntimeException("Erro: O nome da marca deve conter apenas letras!");
            }

            System.out.print("Informe o nome do modelo: ");
            String nomeModelo = entrada.next();
            if (!validarApenasLetras(nomeModelo)) {
                throw new RuntimeException("Erro: O nome do modelo deve conter apenas letras!");
            }

            System.out.print("Informe a placa: ");
            String placa = entrada.next();

            Carro carro = new Carro(nomeMarca, nomeModelo, placa);
            listaAutoMovel.add(carro);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    private void adicionarCaminhao() {
        try {
            System.out.println("--- Adicionando Caminhão ---");

            System.out.print("Informe o nome da marca: ");
            String nomeMarca = entrada.next();
            if (!validarApenasLetras(nomeMarca)) {
                throw new RuntimeException("Erro: O nome da marca deve conter apenas letras!");
            }

            System.out.print("Informe o nome do modelo: ");
            String nomeModelo = entrada.next();
            if (!validarApenasLetras(nomeModelo)) {
                throw new RuntimeException("Erro: O nome do modelo deve conter apenas letras!");
            }

            System.out.print("Informe a placa: ");
            String placa = entrada.next();


            System.out.print("Informe a carga: ");
            String cargaStr = entrada.next();
            if (!validarApenasNumeros(cargaStr)) {
                throw new RuntimeException("Erro: A carga deve conter apenas números!");
            }
            double carga = Double.parseDouble(cargaStr);

            Caminhao caminhao = new Caminhao(nomeMarca, nomeModelo, placa, carga);
            listaAutoMovel.add(caminhao);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private void adicionarMoto() {
        try {
            System.out.println("--- Adicionando Moto ---");

            System.out.print("Informe o nome da marca: ");
            String nomeMarca = entrada.next();
            if (!validarApenasLetras(nomeMarca)) {
                throw new RuntimeException("Erro: O nome da marca deve conter apenas letras!");
            }

            System.out.print("Informe o nome do modelo: ");
            String nomeModelo = entrada.next();
            if (!validarApenasLetras(nomeModelo)) {
                throw new RuntimeException("Erro: O nome do modelo deve conter apenas letras!");
            }

            System.out.print("Informe a placa: ");
            String placa = entrada.next();

            Moto moto = new Moto(nomeMarca, nomeModelo, placa);
            listaAutoMovel.add(moto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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

    private boolean validarApenasLetras(String input) {
        return input.matches("[a-zA-Z]+");
    }
    private boolean validarApenasNumeros(String input) {
        return input.matches("[0-9]+");
    }
}