package com.apprentice.gestionProjet.Entity;

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
@Table(name = "categorie")
public class Categorie extends BaseEntity {


    private  String description;
    @OneToMany(mappedBy = "categorie")
    List<Produit> produits;
}
