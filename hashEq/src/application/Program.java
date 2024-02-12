package application;

import entities.Client;

public class Program {
    public static void main(String[] args) {
        Client s1 = new Client("Maria", "maria@gmail.com");
        Client s2 = new Client("Maria", "maria@gmail.com");

        String c1 = new String("test");
        String c2 ="test";


        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.equals(s2));

        System.out.println(c1 == c2);



    }
}
