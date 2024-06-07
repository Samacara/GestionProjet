package com.apprentice.gestionProjet.Entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data

@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "paiementOuvrier")

public class PaiementOuvrier extends BaseEntity{


    private Integer regelerOperation;

    @ManyToOne
    @JoinColumn(name = "idProjetOuvrier")
    private ProjetOuvrier projetOuvrier;
}
