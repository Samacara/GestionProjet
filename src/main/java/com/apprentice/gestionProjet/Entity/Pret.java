package com.apprentice.gestionProjet.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="pret")
public class Pret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String nomBanque;
    private String motif;
    private Integer rembousser;
    private Integer montant;
    private Date date;

    @OneToMany(mappedBy ="pret" )
    List<ReglementPret> regelementPrets;
}
