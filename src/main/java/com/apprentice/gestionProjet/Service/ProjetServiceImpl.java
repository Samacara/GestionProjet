package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.ProjetDto;
import com.apprentice.gestionProjet.Entity.Projet;
import com.apprentice.gestionProjet.Repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProjetServiceImpl implements ProjetService {

    private ProjetRepository projetRepository;

    @Autowired
    public ProjetServiceImpl(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }


    @Override
    public List<ProjetDto> getallprojet() {
        List<Projet> datas = projetRepository.findAll();
        List<ProjetDto> list = new ArrayList<>();
        for (Projet p : datas) {
            list.add(ProjetDto.fromEntity(p));
        }
        return list;
    }


    @Override
    public ProjetDto saveProjet(ProjetDto projet) {
        Projet p = projetRepository.save(ProjetDto.toEntity(projet));
        return ProjetDto.fromEntity(p);
    }

    @Override
    public Projet saveProjet1(Projet projet) {
        return projetRepository.save(projet);
    }


    @Override
    public ProjetDto updateProjetById(ProjetDto projetDto, Integer idProjet) {
        Projet found = projetRepository.findById(idProjet).get();
        if (found != null) {
            found.setBudget(projetDto.getBudget());
            found.setDescription(projetDto.getDescription());
            found.setLibelle(projetDto.getLibelle());
            found.setId(projetDto.getId());

            Projet projet = projetRepository.save(ProjetDto.toEntity(projetDto));
            return ProjetDto.fromEntity(projet);
        }
        return null;
    }

    @Override
    public ProjetDto getById(Integer idProjet) {
        Projet p = projetRepository.findById(idProjet).get();
        return ProjetDto.fromEntity(p);
    }

    @Override
    public void deleteById(Integer idProjet) {
        projetRepository.deleteById(idProjet);
    }


    @Override
    public Integer getBudget(Integer idProjet) {
        Projet projet = projetRepository.findById(idProjet)
                .orElseThrow(() -> new IllegalArgumentException("Projet non trouvé"));
        return projet.getBudget();
    }

    @Override
    public ProjetDto soustractionBudget(Integer idProjet, Integer sommeASoustraire) {
        Projet projet = projetRepository.findById(idProjet)
                .orElseThrow(() -> new IllegalArgumentException("Projet non trouvé"));

        int budgetRestant = projet.getBudget() - sommeASoustraire;

        if (budgetRestant >= 0) {
            projet.setBudget(budgetRestant);

            Projet prg = projetRepository.save(projet);
            return ProjetDto.fromEntity(prg);
        } else {
            throw new IllegalArgumentException("La somme à soustraire dépasse le budget disponible.");
        }

    }

    @Override
    public ProjetDto restitutionBudget(Integer idProjet, Integer sommeARestituer) {
        Projet projet = projetRepository.findById(idProjet)
                .orElseThrow(() -> new IllegalArgumentException("Projet non trouvé"));

        projet.setBudget(projet.getBudget() + sommeARestituer);
        Projet prg = projetRepository.save(projet);
        return ProjetDto.fromEntity(prg);
    }
}
