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
@Table(name = "reglementPret")
public class ReglementPret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  Integer montantReglement;

    @ManyToOne
    @JoinColumn(name = "idPret")
    private Pret pret;
}
