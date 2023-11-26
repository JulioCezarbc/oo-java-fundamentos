package entites;

public class product {

    public String name;
    public double price;
    public int quantity;

    public double totalValue(){
        return price * quantity;
    }
    public void addProduct(int quantity){
        this.quantity += quantity;
    }
    public void removeProduct(int quantity){
        this.quantity -= quantity;
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
