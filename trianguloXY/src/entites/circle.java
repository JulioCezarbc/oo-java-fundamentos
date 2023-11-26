package entites;

public class circle {

    public double raio;

    public double areaCirc(){
        double area = raio * (3.14*2);
        System.out.printf("Area do circulo: %.2f%n" , area);
        return area;
    }
}
