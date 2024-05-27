package com.apprentice.gestionProjet.Entity;


import jakarta.persistence.*;
import lombok.*;
@Data

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "paiementOuvrier")

public class PaiementOuvrier {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer regelerOperation;

    @ManyToOne
    @JoinColumn(name = "idProjetOuvrier")
    private ProjetOuvrier projetOuvrier;
}
