package com.apprentice.gestionProjet.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projetOuvrier")

public class ProjetOuvrier extends BaseEntity {




      private Integer salaire;

      private Integer regler;

      @ManyToOne
      @JoinColumn(name = "idProjet")
      private Projet projet;

      @ManyToOne
      @JoinColumn(name = "idOuvrier")
      private Ouvrier ouvrier;

        // Getters and setters
        @OneToMany(mappedBy = "projetOuvrier")
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        List<PaiementOuvrier> paiementOuvriers;
}
