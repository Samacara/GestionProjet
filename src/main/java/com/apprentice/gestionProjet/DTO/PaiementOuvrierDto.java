package com.apprentice.gestionProjet.DTO;

import com.apprentice.gestionProjet.Entity.PaiementOuvrier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaiementOuvrierDto {

    private Integer  id;

    private Integer reglerOperation;

    private ProjetOuvrierDto projetOuvrier;

    public  static PaiementOuvrierDto fromEntity(PaiementOuvrier paiementOuvrier){

      return   PaiementOuvrierDto.builder()
              .id(paiementOuvrier.getId())
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
