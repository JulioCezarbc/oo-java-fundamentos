package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Informe o endereço: ");
        String path = entrada.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            List<Employee> list = new ArrayList<>();
            String line = br.readLine();
            while (line != null){
                String[] fi = line.split(",");
                list.add(new Employee(fi[0],fi[1],Double.parseDouble(fi[2])));
                line = br.readLine();
            }
            Comparator<String> comp = (s1,s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
            System.out.println("Informe o valor: ");
            Double vl = entrada.nextDouble();
            List<String> al =list.stream().filter(p -> p.getSalario() > vl).map(Employee::getEmail)
                    .sorted(comp).toList();
               al.forEach(System.out::println);

            Double soma = list.stream().filter(p -> p.getNome().toUpperCase().charAt(0) == 'M').
                    map(Employee::getSalario).reduce(0.0, Double::sum);
            System.out.println(soma);
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
