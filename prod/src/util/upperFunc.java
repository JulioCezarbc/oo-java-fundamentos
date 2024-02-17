package util;

import entities.Product;

import java.util.function.Function;

public class upperFunc implements Function<Product, String> {
    @Override
    public String apply(Product product) {
        return product.getName().toUpperCase();
    }
}
