package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.PaiementOuvrierDto;
import com.apprentice.gestionProjet.DTO.ProjetOuvrierDto;
import com.apprentice.gestionProjet.Entity.PaiementOuvrier;
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
    public void deletpaiementouvrier(Integer idPaiementOuvrier) {PaiementOuvrier paiementOuvrier = paiementOuvrierRepository.findById(idPaiementOuvrier)
            .orElseThrow(() -> new IllegalArgumentException("Paiement ouvrier non trouvé"));

        projetService.restitutionBudget(paiementOuvrier.getProjetOuvrier().getProjet().getId(), paiementOuvrier.getRegelerOperation());
        projetOuvrierService.soustraireRegler(paiementOuvrier.getProjetOuvrier().getId(), paiementOuvrier.getRegelerOperation());

        paiementOuvrierRepository.delete(paiementOuvrier);
    }

}
