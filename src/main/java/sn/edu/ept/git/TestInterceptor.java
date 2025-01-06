package sn.edu.ept.git;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.edu.ept.git.entities.Carte;
import sn.edu.ept.git.entities.Enseignant;
import sn.edu.ept.git.entities.Etudiant;
import sn.edu.ept.git.entities.Personne;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestInterceptor {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        EntityManagerFactory emf= Persistence
                .createEntityManagerFactory("dic2Pu");
        EntityManager em = emf.createEntityManager();

        Etudiant touba = Etudiant.builder()
                .numeroChambre(17)
                .nom("Fall")
                .prenom("Touba")
                .adresse("Pikine")
                .pavillon("H4")
                .build();


        Carte toubaCarte = Carte.builder()
                .code("ddk")
                .etudiant(touba)
                .dateDebut(new GregorianCalendar(2024, Calendar.OCTOBER, 1).getTime())
                .dateFin(new GregorianCalendar(2025, Calendar.SEPTEMBER, 31).getTime())
                .build();
        System.out.println("####" + toubaCarte.getDateCreation());

        em.getTransaction().begin();


//        em.persist(touba);
        em.persist(toubaCarte);
        System.out.println("####" + toubaCarte.getDateCreation());

        Enseignant p = Enseignant.builder()
                        .adresse("Pikine")
                .nom("Fall")
                .prenom("Touba")
                                .build();

        Etudiant lamine = Etudiant.builder()
                .nom("Ndiaye")
                .prenom("Lamine")
                .numeroChambre(25)
                .pavillon("H4")
                .voisin(touba)
                .build();
        em.persist(lamine);
        touba.setVoisin(lamine);
        em.merge(touba);
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();



    }
}
