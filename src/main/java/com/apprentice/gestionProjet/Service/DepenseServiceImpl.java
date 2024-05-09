package com.apprentice.gestionProjet.Service;
import com.apprentice.gestionProjet.DTO.DepenseDto;
import com.apprentice.gestionProjet.DTO.ProjetDto;
import com.apprentice.gestionProjet.Entity.Depense;
import com.apprentice.gestionProjet.Entity.Projet;
import com.apprentice.gestionProjet.Repository.DepenseRepository;
import com.apprentice.gestionProjet.Repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DepenseServiceImpl implements DepenseService{


    private DepenseRepository depenseRepository;
    private ProjetService projetService;

    @Autowired
    public DepenseServiceImpl(DepenseRepository depenseRepository, ProjetService projetService) {
        this.depenseRepository = depenseRepository;
        this.projetService = projetService;
    }

    public DepenseServiceImpl(ProjetService projetService) {
        this.projetService = projetService;
    }

    @Override
    public List<DepenseDto> getallDepense() {
        List<Depense> datas = depenseRepository.findAll();
        List<DepenseDto> list = new ArrayList<>();
        for (Depense d: datas){
            list.add(DepenseDto.fromEntity(d));
        }
        return list;
    }

//    @Override
//    public DepenseDto saveDepense(DepenseDto depense) {
//        Depense d= depenseRepository.save(DepenseDto.toEntitity(depense));
//        return DepenseDto.fromEntity(d);
//    }


    @Override
    public DepenseDto saveDepense(DepenseDto depenseDto) {
//        Depense depense = DepenseDto.toEntitity(depenseDto);
        ProjetDto projet = projetService.getById(depenseDto.getProjet().getId());
        Integer nouveauBudget = projet.getBudget() - depenseDto.getMontant();
        if (nouveauBudget >= 0) {
            projetService.soustractionBudget(projet.getId(), depenseDto.getMontant());
            depenseDto.setProjet(projet);
            Depense savedDepense = depenseRepository.save(DepenseDto.toEntitity(depenseDto));
            return DepenseDto.fromEntity(savedDepense);
        } else {
            throw new IllegalArgumentException("La dépense excède le budget disponible pour ce projet.");
        }
    }

    // Autres méthodes de service pour la gestion des dépenses...




    @Override
    public DepenseDto updateDepenseById(DepenseDto depenseDto, Integer id) {
        Depense found = depenseRepository.findById(id).get();
        if(found!=null){
            found.setId(depenseDto.getId());
            found.setMontant(depenseDto.getMontant());
            found.setMotif(depenseDto.getMotif());

            Depense depense = depenseRepository.save(DepenseDto.toEntitity(depenseDto));
            return DepenseDto.fromEntity(depense);

        }
        return null;
    }

    @Override
    public DepenseDto getDepenseById(Integer IdDepense) {
        Depense d= depenseRepository.findById(IdDepense).get();
        return DepenseDto.fromEntity(d);
    }

    @Override
    public void deleteDepenseById(Integer IdDepense) {
        depenseRepository.deleteById(IdDepense);
    }

    @Override
    public Page<DepenseDto> findPagination(Integer pagesize, Integer pageno, String sortfield, String sortdirection) {
        return null;
    }

//    @Override
//    public DepenseDto creerDepense(DepenseDto depenseDto) {
//        Projet projet = DepenseDto.toEntitity(depenseDto);
//
//
//        return null;
//    }
}