package application;

import entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);

        System.out.print("Entre com o endereço: ");
        String path = entrada.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            List<Product> list = new ArrayList<>();
            String line = br.readLine();
            while (line != null){
                String[] field = line.split(",");
                list.add(new Product(field[0], Double.parseDouble(field[1])));
                line = br.readLine();
            }
            double avg = list.stream().map(Product::getPreco).reduce(0.0, Double::sum) / list.size() ;
            System.out.println("Media: " + String.format("%.2f", avg));

            Comparator<String> comp = (s1, s2)-> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> nomes = list.stream().filter(p -> p.getPreco() < avg).map(p -> p.getNome())
                    .sorted(comp.reversed()).toList();
            nomes.forEach(System.out::println);

        }catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
