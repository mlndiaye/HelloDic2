package sn.edu.ept.git.entities;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sn.edu.ept.git.TestComposedKey;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class RechercheCreneau {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        EntityManagerFactory emf= Persistence
                .createEntityManagerFactory("dic2Pu");
        EntityManager em = emf.createEntityManager();

        CreneauId id = CreneauId.builder()
                .jour(new GregorianCalendar(2025, Calendar.JANUARY, 1).getTime())
                .debut(TestComposedKey.toTime(15, 43, 0))
                .build();

//        String request = "SELECT c FROM Creneau c";
//        Query query = em.createQuery(request);
//        List<Creneau> resultList = query.getResultList();
//        for (Creneau creneau : resultList) {
//            System.out.println("================================");
//            System.out.println(creneau.getJour());
//            System.out.println(creneau.getDebut());
//            System.out.println(creneau.getMatiere());
//        }

        Creneau c = em.find(Creneau.class, id);
        System.out.println("La matiere: " + c.getMatiere());
        em.close();
        emf.close();
    }
}
