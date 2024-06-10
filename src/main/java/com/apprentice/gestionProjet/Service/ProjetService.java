package com.apprentice.gestionProjet.Service;


import com.apprentice.gestionProjet.DTO.OuvrierDto;
import com.apprentice.gestionProjet.Entity.Ouvrier;
import com.apprentice.gestionProjet.Entity.Projet;
import org.springframework.data.domain.Page;
import com.apprentice.gestionProjet.DTO.ProjetDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProjetService
{
    public List<ProjetDto>  getallprojet();

   // public List<Ouvrier> getOuvriersParProjet(Integer idProjet);

    public ProjetDto saveProjet(ProjetDto projet);

    public Projet saveProjet1(Projet projet);

    public ProjetDto updateProjetById(ProjetDto projetDto, Integer idProjet);

    public ProjetDto getById(Integer idProjet);

    public void deleteById(Integer idProjet);


    public Integer getBudget(Integer idProjet);

    public ProjetDto soustractionBudget(Integer idProjet,Integer sommeASoustraire);

    public ProjetDto restitutionBudget(Integer idProjet, Integer sommeARestituer);


}