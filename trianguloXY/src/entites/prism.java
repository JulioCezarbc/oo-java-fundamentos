package entites;

public class prism {

    public double area;
    public double altura;

    public double volumePri(){
        double vol = area * altura;
        System.out.printf("O volume do prisma é: %.2f%n" , vol);
        return vol;
    }


}
