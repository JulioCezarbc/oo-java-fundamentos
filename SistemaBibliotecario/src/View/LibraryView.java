package View;

import Controller.LibraryController;

import Model.Book;

import java.util.List;
import java.util.Scanner;

import static Controller.LibraryController.validarApenasLetras;

public class LibraryView {


    private final LibraryController controller;

    public LibraryView(LibraryController controller) {
        this.controller = controller;
    }

    public void menu(){
        System.out.println("--- Menu ---");
        System.out.println("1 - Adicionar book");
        System.out.println("2 - Listar books");
        System.out.println("3 - Sair");
        System.out.print("Opção: ");
    }
    public void exec(){
        Scanner entrada = new Scanner(System.in);
        String opcao;
        do {
            menu();
            opcao = entrada.nextLine();
            if (validarApenasNumeros(opcao)) {
                int numero = Integer.parseInt(opcao);

                switch (numero) {
                    case 1 -> adicionarBook();
                    case 2 -> listarBook();
                    case 3 -> System.out.println("Saindo....");
                    default -> System.out.println("Opção inválida");
                }
            } else {
                System.out.println("Entrada inválida. Deve conter apenas números inteiros.");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (!opcao.equals("3"));
    }

    public static boolean validarApenasNumeros(String opcao) {
        return opcao.matches("\\d+");
    }

    public void adicionarBook(){
        try {
            Scanner entrada = new Scanner(System.in);
            System.out.print("\nDigite o título do livro: ");
            String titulo = entrada.nextLine();

            if (!validarApenasLetras(titulo)) {
                throw new RuntimeException("\nErro: O nome do book deve conter apenas letras!\n");
            }

            System.out.print("Digite o nome do autor: ");
            String autor = entrada.nextLine();

            if (!validarApenasLetras(autor)){
                throw new RuntimeException("\nErro: O nome do autor deve conter apenas letras!\n");
            }

            controller.adicionarBook(titulo, autor);
            System.out.println("\nBook adicionado\n");
        }catch (Exception e){ //IllegalArgumentException e
            System.out.println(e.getMessage());

        }
    }


    public void listarBook(){
        List<Book> listar = controller.listarBook();
        for (Book book : listar){
            System.out.println("\nBook: " + book.getTituloBook() + "\nAutor: " + book.getNomeAutor() + "\n");
        }
    }
}