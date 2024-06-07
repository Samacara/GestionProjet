package com.apprentice.gestionProjet.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "reglementPret")
public class ReglementPret extends BaseEntity{

    private  Integer montantReglement;

    @ManyToOne
    @JoinColumn(name = "idPret")
    private Pret pret;
}
