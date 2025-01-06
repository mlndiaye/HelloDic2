package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;
    private String telephone;
    private String adresse;

    @OneToOne(mappedBy = "etudiant")
    private Carte carte;

    @ManyToOne
    private Pays paysNaissance;

    @ManyToMany
    private List<Pays> nationalites;
}
