package com.apprentice.gestionProjet.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sortieProduit")
public class SortieProduit {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantite;

    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "idSortie")
    private Sortie sortie;

}
