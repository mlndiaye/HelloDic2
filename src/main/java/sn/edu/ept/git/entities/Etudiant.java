package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("ELEVE-INGENIEUR")

public class Etudiant extends Personne {

    @OneToOne(mappedBy = "etudiant")
    private Carte carte;

    @OneToOne
    private Etudiant voisin;

    private Integer numeroChambre;
    @Column(nullable = false)
    private String pavillon;

}
