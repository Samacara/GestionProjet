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
@Table(name = "depense")

public class Depense extends BaseEntity{


    private Integer montant;

    private String motif;

    @ManyToOne
    @JoinColumn(name = "idProjet")
    private Projet projet;

}
