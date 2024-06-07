package com.apprentice.gestionProjet.DTO;

import com.apprentice.gestionProjet.Entity.PaiementOuvrier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaiementOuvrierDto {

    private Integer  id;

    private Integer reglerOperation;

    private ProjetOuvrierDto projetOuvrier;
    private LocalDate dateModification;
    private LocalDate dateCreation;

    public  static PaiementOuvrierDto fromEntity(PaiementOuvrier paiementOuvrier){

      return   PaiementOuvrierDto.builder()
              .id(paiementOuvrier.getId())
              .dateCreation(paiementOuvrier.getDateCreation())
              .dateModification(paiementOuvrier.getDateModification())
              .reglerOperation(paiementOuvrier.getRegelerOperation())
              .projetOuvrier(ProjetOuvrierDto.fromEntity(paiementOuvrier.getProjetOuvrier()))
              .build();
    }

    public static PaiementOuvrier toEntity(PaiementOuvrierDto paiementOuvrierDto){

        return PaiementOuvrier.builder()
                .id(paiementOuvrierDto.getId())
                .regelerOperation(paiementOuvrierDto.getReglerOperation())
                .projetOuvrier(ProjetOuvrierDto.toEntity(paiementOuvrierDto.getProjetOuvrier()))
                .build();

    }
}
