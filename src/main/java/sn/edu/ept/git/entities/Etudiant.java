package sn.edu.ept.git.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Etudiant {
    @Id
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
