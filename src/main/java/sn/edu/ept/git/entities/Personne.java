package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "ROLE")
@DiscriminatorValue("EMPLOYE")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;


    private LocalDate dateNaissance;
    @ManyToOne
    private Pays paysNaissance;

    @ManyToMany
    private List<Pays> nationalites;

    @Embedded
    private Contact contact;
}
