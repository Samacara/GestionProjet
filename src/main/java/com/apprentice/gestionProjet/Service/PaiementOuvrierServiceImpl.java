package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.PaiementOuvrierDto;
import com.apprentice.gestionProjet.DTO.ProjetDto;
import com.apprentice.gestionProjet.DTO.ProjetOuvrierDto;
import com.apprentice.gestionProjet.Entity.PaiementOuvrier;
import com.apprentice.gestionProjet.Entity.ProjetOuvrier;
import com.apprentice.gestionProjet.Repository.PaiementOuvrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PaiementOuvrierServiceImpl implements PaiementOuvrierService{

    private PaiementOuvrierRepository paiementOuvrierRepository;
    private ProjetOuvrierService projetOuvrierService;
    private ProjetService projetService;
    @Autowired
    public PaiementOuvrierServiceImpl(PaiementOuvrierRepository paiementOuvrierRepository, ProjetOuvrierService projetOuvrierService, ProjetService projetService) {
        this.paiementOuvrierRepository = paiementOuvrierRepository;
        this.projetOuvrierService = projetOuvrierService;
        this.projetService = projetService;
    }



    @Override
    public List<PaiementOuvrierDto> getallpaiementOuvrier() {
        List<PaiementOuvrier> datas= paiementOuvrierRepository.findAll();
        List<PaiementOuvrierDto> list = new ArrayList<>();
        for (PaiementOuvrier p: datas){
            list.add(PaiementOuvrierDto.fromEntity(p));
        }
            return list;
    }

    @Override
    public PaiementOuvrierDto savepaiementOuvrier(Integer idProjetOuvrier, PaiementOuvrierDto paiementOuvrier) {
        ProjetOuvrierDto foundProjetOuvrier = projetOuvrierService.getProjetOuvrierById(idProjetOuvrier);
        Integer SommeAregler = foundProjetOuvrier.getSalaire() - paiementOuvrier.getReglerOperation();
        //int salaireRestant = foundProjetOuvrier.getSalaire() - SommeAregler;
        if (SommeAregler >= 0) {
            projetService.soustractionBudget(foundProjetOuvrier.getId(), paiementOuvrier.getReglerOperation());
            paiementOuvrier.setProjetOuvrier(foundProjetOuvrier);
            projetOuvrierService.ajouterRegler(foundProjetOuvrier.getId(), paiementOuvrier.getReglerOperation() );
            paiementOuvrier.setProjetOuvrier(foundProjetOuvrier);
            PaiementOuvrier p = paiementOuvrierRepository.save(PaiementOuvrierDto.toEntity(paiementOuvrier));

            return PaiementOuvrierDto.fromEntity(p);
        } else {
            return null;
        }

    }




//        ProjetOuvrierDto salaire1 = projetOuvrierService.getProjetOuvrierById(paiementOuvrier.getProjetOuvrier().getProjet().getId());
//        Integer nouveauBudget = salaire1.getProjet().getBudget() -paiementOuvrier.getSalaire();
//
//        if (foundProjetOuvrier != null && nouveauBudget >= 0){
//            projetService.soustractionBudget(salaire1.getProjet().getId(), paiementOuvrier.getSalaire());
//            paiementOuvrier.setProjetOuvrier(salaire1);
//
//            paiementOuvrier.setProjetOuvrier(foundProjetOuvrier);
//            PaiementOuvrier p = paiementOuvrierRepository.save(PaiementOuvrierDto.toEntity(paiementOuvrier));
//
//            return PaiementOuvrierDto.fromEntity(p);
//        }
//        else {
//            throw new IllegalArgumentException("Le salaire excède le budget disponible pour ce projet.");
//        }


    @Override
    public PaiementOuvrierDto UpdatePaiementOuvrier(PaiementOuvrierDto paiementOuvrierDto, Integer idPaiementOuvrier) {
        PaiementOuvrier found = paiementOuvrierRepository.findById(idPaiementOuvrier).get();
        if (found !=null){
            found.setId(paiementOuvrierDto.getId());
            found.setRegelerOperation(paiementOuvrierDto.getReglerOperation());
            found.setProjetOuvrier(PaiementOuvrierDto.toEntity(paiementOuvrierDto).getProjetOuvrier());

            PaiementOuvrier p = paiementOuvrierRepository.save(PaiementOuvrierDto.toEntity(paiementOuvrierDto));
            return PaiementOuvrierDto.fromEntity(p);
        }
        return null;
    }

    @Override
    public PaiementOuvrierDto GetPaiementOuvrierById(Integer idPaiementOuvrier) {
        PaiementOuvrier p = paiementOuvrierRepository.findById(idPaiementOuvrier).get();
        return PaiementOuvrierDto.fromEntity(p);
    }

    @Override
    public void deletpaiementouvrier(Integer idPaiementOuvrier) {

        paiementOuvrierRepository.deleteById(idPaiementOuvrier);
    }
}
