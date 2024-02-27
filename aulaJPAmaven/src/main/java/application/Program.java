package application;

import dominio.Pessoa;

public class Program {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(1,"bob","bob@gmail");
        Pessoa p2 = new Pessoa(2,"boba","boba@gmail");
        Pessoa p3 = new Pessoa(3,"bobe","bobe@gmail");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);


    }
}
