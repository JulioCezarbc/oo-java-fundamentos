package entites;

public class square {
    public double lado;

    public double areaSq(){
        double area = lado * lado;
        System.out.printf("A area do quadrado é: %.2f%n",area);
        return area;
    }


}
