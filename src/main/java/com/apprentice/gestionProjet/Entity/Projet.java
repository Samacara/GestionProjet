package com.apprentice.gestionProjet.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projet")

public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "description")
    private String description;

    @Column(name = "budget")
    private Integer budget;

    @OneToMany(mappedBy = "projet")
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<Depense> depenses;

//    @OneToMany(mappedBy = "projet")
//   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    List<Ouvrier> ouvriers;
@ManyToMany
@JoinTable(
        name = "projet_ouvrier",
        joinColumns = @JoinColumn(name = "id"),
        inverseJoinColumns = @JoinColumn(name = "id"))
        List<Ouvrier> ouvriers;
}