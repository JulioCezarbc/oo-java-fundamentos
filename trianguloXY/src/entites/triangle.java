package entites;

public class triangle {
    public double a;
    public double b;
    public double c;

    public double areaTri(){
        double p = (a + b + c) / 2.0;
        double result = Math.sqrt(p * ( p - a) * (p - b) * (p - c ));
        System.out.printf("Area do triangulo : %.2f%n", result );
        return result;
    }

}
