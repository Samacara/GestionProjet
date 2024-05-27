package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.PaiementOuvrierDto;

import java.util.List;

public interface PaiementOuvrierService {

    public List<PaiementOuvrierDto> getallpaiementOuvrier();

    public PaiementOuvrierDto savepaiementOuvrier(Integer idProjetOuvrier, PaiementOuvrierDto paiementOuvrier);

    public PaiementOuvrierDto UpdatePaiementOuvrier(PaiementOuvrierDto paiementOuvrierDto, Integer idPaiementOuvrier );

    public PaiementOuvrierDto GetPaiementOuvrierById(Integer idPaiementOuvrier);

    public void deletpaiementouvrier(Integer idPaiementOuvrier);

}
