package sn.edu.ept.git;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.edu.ept.git.entities.Creneau;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestComposedKey {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        EntityManagerFactory emf= Persistence
                .createEntityManagerFactory("dic2Pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Creneau c1 = Creneau.builder()
                .jour(new GregorianCalendar(2025, Calendar.JANUARY, 1).getTime())
                .debut(toTime(15, 43, 0))
                .fin(LocalTime.of(16, 43))
                .matiere("Dev web 3")
                .build();
        em.persist(c1);
        Creneau c2 = Creneau.builder()
                .jour(new GregorianCalendar(2025, Calendar.JANUARY, 1).getTime())
                .debut(toTime(14, 23, 0))
                .fin(LocalTime.of(16, 43, 0))
                .matiere("Computer vision")
                .build();

        em.persist(c2);
        em.getTransaction().commit();
        em.close();
        emf.close();


    }

    public static Date toTime(int heure, int minute, int seconde) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, heure);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, seconde);
        return cal.getTime();
    }
}
