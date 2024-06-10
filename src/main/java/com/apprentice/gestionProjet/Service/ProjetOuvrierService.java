package com.apprentice.gestionProjet.Service;


import com.apprentice.gestionProjet.DTO.ProjetOuvrierDto;


import java.util.List;

public interface ProjetOuvrierService {



    public List<ProjetOuvrierDto> getallprojetsOuvriers();

//    public List<OuvrierDto> getOuvriersByProjet(Integer idProjet);

    public ProjetOuvrierDto saveProjetOuvrier(Integer projetId, Integer ouvrierId, ProjetOuvrierDto projetOuvrier);

    public ProjetOuvrierDto updateProjetOuvrierById(ProjetOuvrierDto projetOuvrierDto, Integer idProjetOuvrier);

    public ProjetOuvrierDto getProjetOuvrierById(Integer idProjetOuvrier);

    public  void deleteProjetOuvrierById(Integer idProjetOuvrier);


    public ProjetOuvrierDto ajouterRegler(Integer idProjetOuvrier, Integer SommeAajouter);

   public ProjetOuvrierDto soustraireRegler(Integer idProjetOuvrier, Integer sommeASoustraire);
}



