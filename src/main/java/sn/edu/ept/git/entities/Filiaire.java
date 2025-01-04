package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "filiaire")
public class Filiaire {
    @Id
    private String code;

    @Column(unique = true, nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "DEPARTEMENT")
    private Departement departement;
}