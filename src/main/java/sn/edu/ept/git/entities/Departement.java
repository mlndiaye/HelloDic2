package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Departement {
    @Id
    @Column(length = 15)
    private String code;

    @Column(unique = true, nullable = false)
    private String nom;

    @OneToMany(mappedBy = "departement")
    private List<Filiaire> filiaires;

    @Embedded
    private Contact contact;
}