package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.PretDto;


import java.util.List;

public interface PretService {

    public List<PretDto> getAllPret();

    public  PretDto savePret(PretDto pretDto);

    public PretDto updatePret(PretDto pretDto,Integer idPret);

    public  PretDto getPretById(Integer idPret);

    public  void  deletePret(Integer idPret);

    public PretDto ajouterReglement(Integer idPret, Integer SommeRegler);

}
