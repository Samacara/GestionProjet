package com.apprentice.gestionProjet.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "produit")
public class Produit extends BaseEntity{


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
