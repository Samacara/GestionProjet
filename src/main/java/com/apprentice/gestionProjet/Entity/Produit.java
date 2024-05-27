package com.apprentice.gestionProjet.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private  String nomProduit;
    private  String designation;
    private  Integer stock;

    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;

    @OneToMany(mappedBy = "produit")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    List<SortieProduit> sortieProduits;
}
