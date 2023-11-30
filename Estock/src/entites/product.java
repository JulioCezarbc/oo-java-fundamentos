package entites;

public class product {

    private String name;
    private double price;
    private int quantity;


    public product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public product(String name, double price) {
        this.name = name;
        this.price = price;
        
    }

    public double totalValue(){
        return price * quantity;
    }
    public void addProduct(int quantity){
        this.quantity += quantity;
    }
    public void removeProduct(int quantity){
        this.quantity -= quantity;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public double getQuantity(){
        return quantity;
    }


    @Override
    public String toString() {
        return "produto: " +
                name + "\n"+
                "preço: R$" +
                String.format("%.2f", price) +"\n"+
                "quantidade: " + quantity +"\n"+
                "total: R$" + String.format("%.2f",totalValue());
    }
}
