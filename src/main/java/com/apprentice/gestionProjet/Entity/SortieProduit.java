package com.apprentice.gestionProjet.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sortieProduit")
public class SortieProduit extends BaseEntity {
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
