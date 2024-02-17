package entities;

public class Product {
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public static String staticCase(Product p){
        return p.getName().toUpperCase();
    }

    public String NoStaticCase(){
        return name.toUpperCase();
    }

//    public static void staticPrice(Product p){
//        p.setPrice(p.getPrice() * 1.1);
//    }
//    public void noStaticPro(){
//        price *= 1.1;
//    }



//    public static boolean staticProduct(Product p){
//        return p.getPrice() >=100;
//    }
//
//    public boolean NostaticProduct(){
//        return price>=100;
//    }

    @Override
    public String toString() {
        return name + ", " + String.format("%.2f", price);
    }
}
