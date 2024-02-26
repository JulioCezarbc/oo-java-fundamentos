package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("--- Test 1 ---");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n--- Test 2 ---");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller sel : list){
            System.out.println(sel);
        }

        System.out.println("\n--- Test 3 ---");
        list = sellerDao.findAll();
        for (Seller sel : list){
            System.out.println(sel);
        }

        System.out.println("\n--- Test 4 ---");
//        Seller seller1 = new Seller(null,"Gre", "gre@gmail,com", new Date(),
//                4000.0, department);
//        sellerDao.insert(seller1);
//        System.out.println("New Seller: " + seller1.getId());

        System.out.println("\n--- Test 5 ---");
        seller = sellerDao.findById(1);
        seller.setName("Marta");
        sellerDao.update(seller);
        System.out.println("Update Completed");

        System.out.println("\n--- Test 6 ---");
        System.out.print("Digite o Id: ");
        int id = entrada.nextInt();

        sellerDao.deleteById(id);
        System.out.println("Delete Completed");


    }
}
