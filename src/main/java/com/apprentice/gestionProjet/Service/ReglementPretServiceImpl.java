package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.PretDto;
import com.apprentice.gestionProjet.DTO.ReglementPretDto;
import com.apprentice.gestionProjet.Entity.ReglementPret;
import com.apprentice.gestionProjet.Repository.ReglementPretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ReglementPretServiceImpl implements ReglementPretService{
    private ReglementPretRepository reglementPretRepository;
    private PretService pretService;
    @Autowired
    public ReglementPretServiceImpl(ReglementPretRepository reglementPretRepository, PretService pretService) {
        this.reglementPretRepository = reglementPretRepository;
        this.pretService = pretService;
    }

    @Override
    public List<ReglementPretDto> getAllReglementPret() {
        List<ReglementPret> datas= reglementPretRepository.findAll();
        List<ReglementPretDto> list = new ArrayList<>();
        for (ReglementPret rp: datas){
            list.add(ReglementPretDto.fromEntity(rp));
        }
        return list;
    }

    @Override
    public ReglementPretDto saveReglementPret(Integer idPret, ReglementPretDto reglementPretDto) {
        PretDto foundPretDto = pretService.getPretById(idPret);
        Integer SommeAregler= foundPretDto.getMontant() - reglementPretDto.getMontantReglement();
        if (SommeAregler >=0 ){
            pretService.ajouterReglement(foundPretDto.getId(), reglementPretDto.getMontantReglement());
            reglementPretDto.setPret(foundPretDto);

            ReglementPret rP = reglementPretRepository.save(ReglementPretDto.toEntity(reglementPretDto));
            return ReglementPretDto.fromEntity(rP);

        }

        return null;
    }

    @Override
    public ReglementPretDto updateReglementPret(Integer idReglementPret, ReglementPretDto reglementPretDto) {
        ReglementPret foundReglementPret= reglementPretRepository.findById(idReglementPret).get();
        if (foundReglementPret !=null){
            foundReglementPret.setId(reglementPretDto.getId());
            foundReglementPret.setMontantReglement(reglementPretDto.getMontantReglement());
            foundReglementPret.setPret(PretDto.toEntity(reglementPretDto.getPret()));

            ReglementPret rP = reglementPretRepository.save(foundReglementPret);
            return ReglementPretDto.fromEntity(rP);
        }
        return null;
    }

    @Override
    public ReglementPretDto getReglementPretById(Integer idReglementPret) {
        ReglementPret rP = reglementPretRepository.findById(idReglementPret).get();
        return ReglementPretDto.fromEntity(rP);

    }

    @Override
    public void deleteReglementPret(Integer idReglementPret) {
        ReglementPret reglementPret = reglementPretRepository.findById(idReglementPret)
                        .orElseThrow(() -> new IllegalArgumentException("Reglement du prêt non trouvé"));
        PretDto pret = pretService.getPretById(reglementPret.getPret().getId());
        pret.setRembousser(pret.getRembousser() - reglementPret.getMontantReglement());
        pretService.savePret(pret);
        reglementPretRepository.deleteById(idReglementPret);

    }
}
