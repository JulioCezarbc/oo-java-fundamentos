package application;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null,"bob","bob@gmail");
        Pessoa p2 = new Pessoa(null,"bobe","bobe@gmail");
        Pessoa p3 = new Pessoa(null,"boba","boba@gmail");


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
        System.out.println("!!!");

    }
}