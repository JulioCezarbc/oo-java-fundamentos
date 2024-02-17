package application;

import entities.Product;
import model.service.ProductService;
import util.ProductPredicate;
import util.priceUpdate;
import util.upperFunc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Program {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        Locale.setDefault(Locale.US);

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("HD CASE", 80.90));


        String a = "Notebook";

        ProductService ps = new ProductService();
        double soma = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T' );


        System.out.println(soma);



        // predicate
        //list.removeIf(p -> p.getPrice() >=100);
        //list.removeIf(new ProductPredicate());
        //list.removeIf(Product::staticProduct);
        //list.removeIf(Product::NostaticProduct);

        //Predicate<Product> pred = p -> p.getPrice()>=100;
        //list.removeIf(pred);

        //list.removeIf(p -> p.getPrice()>=100);

        //Comparator<Product> comp = Comparator.comparing(p -> p.getName().toLowerCase());
        //Comparator<Product> comp = (p1,p2) -> p1.getName().toLowerCase().compareTo(p2.getName().toLowerCase());
        //list.sort(comp);


        //Consumer
        //list.forEach(new priceUpdate());
        //list.forEach(Product::staticPrice);
        //list.forEach(Product::noStaticPro);
        //Consumer<Product> cons = p -> p.setPrice(p.getPrice() * 2.1);
        //list.forEach(cons);
        //list.forEach(p -> p.setPrice(p.getPrice() * 5));
        //list.forEach(p -> p.getName().toUpperCase());

        //function

        //List<String> name = list.stream().map(new upperFunc()).collect(Collectors.toList());
        //List<String> name = list.stream().map(new upperFunc()).toList();
        //name.forEach(System.out::println);

        //List<String> name = list.stream().map(Product::staticCase).toList();

        //List<String> name = list.stream().map(Product::NoStaticCase).toList();


        //Function<Product, String> func = p-> p.getName().toUpperCase();
        //List<String> name = list.stream().map(func).toList();

        //List<String> name = list.stream().map(p-> p.getName().toUpperCase()).toList();
        //name.forEach(System.out::println);






        //list.forEach(System.out::println);



//        for (Product p : list){
//            System.out.println(p);
//        }
//
    }
}
