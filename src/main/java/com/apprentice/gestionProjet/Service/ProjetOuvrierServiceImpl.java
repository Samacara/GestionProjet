package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.OuvrierDto;
import com.apprentice.gestionProjet.DTO.ProjetDto;
import com.apprentice.gestionProjet.DTO.ProjetOuvrierDto;
import com.apprentice.gestionProjet.Entity.ProjetOuvrier;
import com.apprentice.gestionProjet.Repository.ProjetOuvrierRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjetOuvrierServiceImpl implements ProjetOuvrierService {


    private ProjetOuvrierRipository projetOuvrierRipository;
    private ProjetService projetService;
    private OuvrierService ouvrierService;

    @Autowired
    public ProjetOuvrierServiceImpl(ProjetOuvrierRipository projetOuvrierRipository, ProjetService projetService, OuvrierService ouvrierService) {
        this.projetOuvrierRipository = projetOuvrierRipository;
        this.projetService = projetService;
        this.ouvrierService = ouvrierService;
    }

    @Override
    public List<ProjetOuvrierDto> getallprojetsOuvriers() {
        List<ProjetOuvrier> datas = projetOuvrierRipository.findAll();
        List<ProjetOuvrierDto> list = new ArrayList<>();
        for (ProjetOuvrier p: datas){
            list.add(ProjetOuvrierDto.fromEntity(p));
        }
        return list;
    }



    @Override
    public ProjetOuvrierDto saveProjetOuvrier(Integer projetId, Integer ouvrierId, ProjetOuvrierDto projetOuvrier) {
         ProjetDto foundProjet = projetService.getById(projetId);
        OuvrierDto foundOuvrier = ouvrierService.getOuvrierById(ouvrierId);
        if(foundProjet != null && foundOuvrier != null){
            projetOuvrier.setOuvrier(foundOuvrier);
            projetOuvrier.setProjet(foundProjet);

            ProjetOuvrier p = projetOuvrierRipository.save(ProjetOuvrierDto.toEntity(projetOuvrier));
            return ProjetOuvrierDto.fromEntity(p);
        }else{
            return  null;
        }

    }



    @Override
    public ProjetOuvrierDto updateProjetOuvrierById(ProjetOuvrierDto projetOuvrierDto, Integer idProjetOuvrier) {
        ProjetOuvrier found= projetOuvrierRipository.findById(idProjetOuvrier).get();
        if (found!=null){
            found.setId(projetOuvrierDto.getId());
            found.setSalaire(projetOuvrierDto.getSalaire());
            found.setOuvrier(ProjetOuvrierDto.toEntity(projetOuvrierDto).getOuvrier());
            found.setProjet(ProjetOuvrierDto.toEntity(projetOuvrierDto).getProjet());

            ProjetOuvrier p =projetOuvrierRipository.save(ProjetOuvrierDto.toEntity(projetOuvrierDto));
            return ProjetOuvrierDto.fromEntity(p);
        }
        return null;
    }




    @Override
    public ProjetOuvrierDto getProjetOuvrierById(Integer idProjetOuvrier) {
        ProjetOuvrier p= projetOuvrierRipository.findById(idProjetOuvrier).get();
        return ProjetOuvrierDto.fromEntity(p);
    }

    @Override
    public void deleteProjetOuvrierById(Integer idProjetOuvrier) {

        projetOuvrierRipository.deleteById(idProjetOuvrier);

    }

    @Override
    public ProjetOuvrierDto ajouterRegler(Integer idProjetOuvrier, Integer SommeAajouter) {

        ProjetOuvrier po = projetOuvrierRipository.findById(idProjetOuvrier)
                .orElseThrow(() -> new IllegalArgumentException("ProjetOuvrier non trouvé"));

        int totalReglement = po.getRegler() + SommeAajouter;
        if (totalReglement <= po.getSalaire()) {
            po.setRegler(totalReglement);

            ProjetOuvrier pO = projetOuvrierRipository.save(po);
            return ProjetOuvrierDto.fromEntity(pO);
        }

     else {
        throw new IllegalArgumentException("La somme à soustraire dépasse le salaire disponible.");
     }

    }
  }