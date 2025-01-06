package sn.edu.ept.git.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Contact {
    private String telephone;
    private String email;
    private String adresse;
    private String siteWeb;
    private String fb;
    private String twitter;
    private String linkedin;
    private String instagram;
}
