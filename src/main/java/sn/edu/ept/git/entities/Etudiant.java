package sn.edu.ept.git.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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
}
