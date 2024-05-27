package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.ReglementPretDto;

import java.util.List;

public interface ReglementPretService {

    public List<ReglementPretDto> getAllReglementPret();

    public ReglementPretDto saveReglementPret(Integer idPret, ReglementPretDto reglementPretDto);

    public ReglementPretDto updateReglementPret (Integer idReglementPret, ReglementPretDto reglementPretDto);

    public ReglementPretDto getReglementPretById(Integer idReglementPret);

    public void deleteReglementPret(Integer idReglementPret);
}
