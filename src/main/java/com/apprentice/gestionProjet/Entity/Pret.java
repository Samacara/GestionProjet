package com.apprentice.gestionProjet.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="pret")
public class Pret extends BaseEntity {


    private String nomBanque;
    private String motif;
    private Integer rembousser;
    private Integer montant;
    private LocalDate date;

    @OneToMany(mappedBy ="pret" )
    List<ReglementPret> regelementPrets;
}
