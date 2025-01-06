package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(CreneauId.class)
@Table(name = "creneau")
public class Creneau {
    @Id
    @Temporal(TemporalType.DATE)
    private Date jour;

    @Id
    @Temporal(TemporalType.TIME)
    private Date debut;
    private LocalTime fin;
    private String matiere;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creneau creneau = (Creneau) o;
        return Objects.equals(jour, creneau.jour) && Objects.equals(debut, creneau.debut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jour, debut);
    }
}