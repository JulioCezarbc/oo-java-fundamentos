    package model.service;

    import entities.Product;

    import java.util.List;
    import java.util.function.Predicate;

    public class ProductService {
        public double filteredSum(List<Product> list, Predicate<Product> crit){
            double soma = 0.0;
            for (Product p : list ){
                if (crit.test(p)) {
                    soma+= p.getPrice();
                }
            }
            return soma;
        }
    }
