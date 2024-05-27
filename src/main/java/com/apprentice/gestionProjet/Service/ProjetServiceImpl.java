package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.OuvrierDto;
import com.apprentice.gestionProjet.DTO.ProjetDto;
import com.apprentice.gestionProjet.Entity.Ouvrier;
import com.apprentice.gestionProjet.Entity.Projet;
import com.apprentice.gestionProjet.Repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProjetServiceImpl implements ProjetService {

    private ProjetRepository projetRepository;

    public ProjetServiceImpl(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    @Autowired


    @Override
    public List<ProjetDto> getallprojet() {
        List<Projet> datas = projetRepository.findAll();
        List<ProjetDto> list = new ArrayList<>();
        for(Projet p: datas){
            list.add(ProjetDto.fromEntity(p));
        }
        return list;
    }

//    @Override
//    public List<Ouvrier> getOuvriersParProjet(Integer idProjet) {
//        Projet projet = projetRepository.findById(idProjet)
//                .orElseThrow(() -> new IllegalArgumentException("Projet non trouvé"));
//        return projet.getOuvriers();
//    }



    @Override
    public ProjetDto saveProjet(ProjetDto projet) {
        Projet p =  projetRepository.save(ProjetDto.toEntity(projet));
        return ProjetDto.fromEntity(p);
    }

    @Override
    public Projet saveProjet1(Projet projet) {
        return projetRepository.save(projet);
    }



    @Override
    public ProjetDto updateProjetById(ProjetDto projetDto, Integer idProjet) {
        Projet  found = projetRepository.findById(idProjet).get();
        if (found!=null){
            found.setBudget(projetDto.getBudget());
            found.setDescription(projetDto.getDescription());
            found.setLibelle(projetDto.getLibelle());
            found.setId(projetDto.getId());

            Projet projet = projetRepository.save(ProjetDto.toEntity(projetDto));
            return ProjetDto.fromEntity(projet);
        }
        return  null;
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
    public Page<ProjetDto> findPagination(Integer pagesize, Integer pageno, String sortfield, String sortdirection) {
        return null;


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

            Projet prg= projetRepository.save(projet);
            return ProjetDto.fromEntity(prg);
        } else {
            throw new IllegalArgumentException("La somme à soustraire dépasse le budget disponible.");
        }

    }

//    @Override
//    public Integer getBudgetProjet(Integer idProjet) {
//        Projet projet = projetRepository.findById(idProjet).orElse(null);
//        if (projet != null) {
//            return projet.getBudget();
//        }
//        return 0;
//    }
//
//    @Override
//    public Integer soustraireDuBudget(Integer idProjet, Integer montant) {
//        Projet projet = projetRepository.findById(idProjet).orElse(null);
//        if (projet != null) {
//            Integer nouveauBudget = projet.getBudget() - montant;
//            projet.setBudget(nouveauBudget);
//            projetRepository.save(projet);
//            return nouveauBudget;
//        }
//        return 0;
//    }


}