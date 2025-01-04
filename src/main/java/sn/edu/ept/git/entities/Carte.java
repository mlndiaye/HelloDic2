package sn.edu.ept.git.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "carte")
public class Carte {
  @Id
  private String code;
  private Date dateCreation;
  private Date dateModification;
  private Date dateDebut;
  private Date dateFin;

  @OneToOne
  private Etudiant etudiant;
}