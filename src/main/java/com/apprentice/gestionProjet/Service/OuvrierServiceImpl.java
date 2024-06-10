package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.OuvrierDto;
import com.apprentice.gestionProjet.Entity.Ouvrier;
import com.apprentice.gestionProjet.Repository.OuvrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class OuvrierServiceImpl implements OuvrierService{

    private  OuvrierRepository ouvrierRepository;
    @Autowired
    public OuvrierServiceImpl(OuvrierRepository ouvrierRepository) {
        this.ouvrierRepository = ouvrierRepository;
    }



    @Override
    public List<OuvrierDto> getallOuvrier() {
        List<Ouvrier> datas = ouvrierRepository.findAll();
        List<OuvrierDto> list= new ArrayList<>();
        for (Ouvrier o: datas){
            list.add(OuvrierDto.fromEntity(o));
        }
        return list;

    }


    @Override
    public OuvrierDto saveOuvrier(OuvrierDto ouvrier) {
        Ouvrier o= ouvrierRepository.save(OuvrierDto.toEntity(ouvrier));
        return OuvrierDto.fromEntity(o);
    }

    @Override
    public OuvrierDto updateOuvrierById(OuvrierDto ouvrierDto, Integer id) {
        Ouvrier found = ouvrierRepository.findById(id).get();
        if(found!=null){
            found.setId(ouvrierDto.getId());
            found.setNom(ouvrierDto.getNom());
            found.setAdresse(ouvrierDto.getAdresse());
            found.setLocalisation(ouvrierDto.getLocalisation());

            Ouvrier ouvrier = ouvrierRepository.save(OuvrierDto.toEntity(ouvrierDto));
            return  OuvrierDto.fromEntity(ouvrier);
        }
        return null;
    }

    @Override
    public OuvrierDto getOuvrierById(Integer IdOuvrier) {
        Ouvrier o= ouvrierRepository.findById(IdOuvrier).get();
        return OuvrierDto.fromEntity(o);

    }

    @Override
    public void deleteOuvrierById(Integer IdOuvrier) {
        ouvrierRepository.deleteById(IdOuvrier);
    }

    @Override
    public OuvrierDto ajouterOuvrierAProjet(Integer IdOuvrier, Integer idProjet, Integer salaire) {
        return null;
    }





}