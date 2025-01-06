package sn.edu.ept.git.entities;


import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreneauId implements Serializable {
    private Date jour;
    private Date debut;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreneauId creneauId = (CreneauId) o;
        return Objects.equals(jour, creneauId.jour) && Objects.equals(debut, creneauId.debut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jour, debut);
    }
}
