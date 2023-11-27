package application;

import entites.product;

import java.util.Scanner;

public class program {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);


        System.out.println("Informe o produto: ");
        String name = entrada.next();

        System.out.println("Informe o preço: ");
        double price = entrada.nextDouble();

        System.out.println("Informe a quantidade: ");
        int quantity = entrada.nextInt();
        product produto = new product(name,price,quantity);


        System.out.println();
        System.out.println(produto);
        System.out.println();

        System.out.println("Informe o numero de produtos, para ser adicionado no estoque! ");
        quantity = entrada.nextInt();
        produto.addProduct(quantity);

        System.out.println();
        System.out.println(produto);
        System.out.println();

        System.out.println("Informe o numero de produtos, para ser removido do estoque! ");
        quantity = entrada.nextInt();
        produto.removeProduct(quantity);

        System.out.println(produto);

    }
}
