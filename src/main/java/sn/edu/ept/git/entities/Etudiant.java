package sn.edu.ept.git.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

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
}
