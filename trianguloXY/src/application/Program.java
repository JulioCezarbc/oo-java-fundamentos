package application;
import entites.prism;
import entites.square;
import entites.triangle;
import entites.circle;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);


        triangle x = new triangle();
        triangle y = new triangle();

        System.out.println("Coloque as medidas do X: ");
        x.a = entrada.nextDouble();
        x.b = entrada.nextDouble();
        x.c = entrada.nextDouble();

        System.out.println("Coloque as medidas do Y: ");
        y.a = entrada.nextDouble();
        y.b = entrada.nextDouble();
        y.c = entrada.nextDouble();

        double areaX = x.areaTri();
        double areaY = y.areaTri();



        circle z = new circle();
        System.out.println("  ");
        System.out.println("Coloque o raio do circulo: ");

        z.raio = entrada.nextDouble();
        double areaZ = z.areaCirc();



        square w = new square();
        System.out.println("  ");
        System.out.println("Coloque a base do quadrado: ");

        w.lado = entrada.nextDouble();
        double areaW = w.areaSq();



        prism v = new prism();
        System.out.println("  ");
        System.out.println("Informe a area da base e a altura do prisma: ");
        
        v.area = entrada.nextDouble();
        v.altura = entrada.nextDouble();
        double Vol = v.volumePri();

        entrada.close();
    }
}
