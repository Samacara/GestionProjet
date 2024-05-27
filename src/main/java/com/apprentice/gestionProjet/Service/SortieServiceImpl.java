package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.ProjetDto;
import com.apprentice.gestionProjet.DTO.SortieDto;
import com.apprentice.gestionProjet.Entity.Sortie;
import com.apprentice.gestionProjet.Repository.SortieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SortieServiceImpl implements SortieService{
    private SortieRepository sortieRepository;
    private ProjetService projetService;
    @Autowired
    public SortieServiceImpl(SortieRepository sortieRepository, ProjetService projetService) {
        this.sortieRepository = sortieRepository;
        this.projetService = projetService;
    }




    @Override
    public SortieDto saveSortie(SortieDto sortieDto, Integer idProjet) {
        ProjetDto foundProjet = projetService.getById(idProjet);
        if (foundProjet != null) {
            sortieDto.setProjet(foundProjet);
            Sortie s = sortieRepository.save(SortieDto.toEntity(sortieDto));
            return SortieDto.fromEntity(s);
        }
        return null;
    }
    @Override
    public SortieDto updateSortie(SortieDto sortieDto, Integer idSortie) {
        Sortie foundSortie = sortieRepository.findById(idSortie).get();
        if (foundSortie != null){
            foundSortie.setId(sortieDto.getId());
            foundSortie.setIntitule(sortieDto.getIntitule());
            foundSortie.setProjet(SortieDto.toEntity(sortieDto).getProjet());

            Sortie s = sortieRepository.save(foundSortie);
            return SortieDto.fromEntity(s);
        }
        return null;
    }

    @Override
    public SortieDto GetOneSortie(Integer idSortie) {
        Sortie sr= sortieRepository.findById(idSortie).get();
        return SortieDto.fromEntity(sr);
    }

    @Override
    public List<SortieDto> getAllSortie() {
        List<Sortie> datas = sortieRepository.findAll();
        List<SortieDto> list = new ArrayList<>();
        for (Sortie s : datas){

            list.add(SortieDto.fromEntity(s));
        }
        return list;
    }

    @Override
    public void deleteSortie(Integer idSortie) {
        sortieRepository.deleteById(idSortie);

    }
}
