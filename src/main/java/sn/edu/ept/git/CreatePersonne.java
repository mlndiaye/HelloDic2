package sn.edu.ept.git;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.edu.ept.git.entities.Personne;

import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CreatePersonne {
    public static void main(String[] args) {
         System.out.printf("Hello and welcome!");

        EntityManagerFactory emf= Persistence
                .createEntityManagerFactory("dic2Pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Personne ali = new Personne();
        ali.setNom("Fall");
        ali.setPrenom("Ali");
        LocalDate birthday = LocalDate.of(1990, 1, 1);
        ali.setDateNaissance(birthday);
//        ali.setId(1);

        Personne fatou=Personne.builder()
                .nom("Ndiaye")
                .prenom("Fatou")
                .dateNaissance(LocalDate.of(2000, 10, 21))
//                .id(5)
                .build();

        System.out.println("Create personne " + ali);
        em.persist(ali);

        em.persist(fatou);

        Personne p=new Personne();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter id : ");
        p.setId(sc.nextInt());
        System.out.println("Enter nom : ");
        p.setNom(sc.next());
        System.out.println("Enter prenom : ");
        p.setPrenom(sc.next());
        if(p.getId()<=0){
            em.getTransaction().rollback();
        }else {
             em.persist(p);
        }

        em.getTransaction().commit();
        //em.getTransaction().rollback();
        em.close();
        emf.close();
    }
}