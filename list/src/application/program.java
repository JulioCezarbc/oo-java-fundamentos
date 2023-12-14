package application;

import entites.lista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
//        List <Integer> list = new ArrayList<>();
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//
//        list.add(4,2);
//        System.out.println("Tamanho " + list.size());
//        list.remove(4);
//
//        for (Integer i : list){
//            System.out.println(i);
//        }
//
//
//        List<String> list = new ArrayList<>();
//
//        list.add("Alex");
//        list.add("Bob");
//        list.add("Anna");
//        list.add("Marco");
//
//        for (String x : list){
//            System.out.println(x);
//        }
//        list.removeIf(x -> x.charAt(0) == 'M');
//
//        System.out.println("---------");
//        for (String x : list){
//            System.out.println(x);
//        }
//        System.out.println("---------");
//
//        System.out.println("Index bob " + list.indexOf("Bob"));
//
//        System.out.print("Index Marco ");
//        if (list.indexOf("Marco") > 0 ){
//            System.out.println(list.indexOf("Marco"));
//        }else System.out.println("Nao existe ");
        Scanner entrada = new Scanner (System.in);

        List<lista> list = new ArrayList();
        System.out.println("Quantos funcionarios setao registrados ? ");
        int n = entrada.nextInt();

        for (int i = 0; i<n; i++){
            System.out.println("\nFunc #" + (i + 1)+": ");
            System.out.print("Informe o id: ");
            int id = entrada.nextInt();
            while (hasId(list, id)) {
                System.out.print("Id em uso. Tente novamente: ");
                id = entrada.nextInt();
            }

            System.out.print("Nome: ");
            entrada.nextLine();
            String nome = entrada.nextLine();

            System.out.print("Salario: ");
            Double salario = entrada.nextDouble();
            list.add(new lista(id, nome, salario));
        }


        System.out.println("\nId do funcionario: ");
        int id = entrada.nextInt();
        lista emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (emp == null) {
            System.out.println("Este id nao existe!");
        }
        else {
            System.out.print("Informe a porcentagem: ");
            double percentage = entrada.nextDouble();
            emp.AddSalary(percentage);
        }

        System.out.println();
        System.out.println("Lista: ");
        for (lista obj : list) {
            System.out.println(obj);
        }

    }
    public static boolean hasId(List<lista> list, int id) {
        lista emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
