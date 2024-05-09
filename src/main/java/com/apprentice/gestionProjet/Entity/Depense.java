package com.apprentice.gestionProjet.Entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "depense")

public class Depense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer montant;

    private String motif;

    @ManyToOne
    @JoinColumn(name = "idProjet")
    private Projet projet;

}
