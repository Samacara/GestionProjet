package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.PretDto;
import com.apprentice.gestionProjet.Entity.Pret;
import com.apprentice.gestionProjet.Repository.PretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PretServiceImpl implements PretService {

    private PretRepository pretRepository;

    @Autowired
    public PretServiceImpl(PretRepository pretRepository) {
        this.pretRepository = pretRepository;
    }

    @Override
    public List<PretDto> getAllPret() {
        List<Pret> datas = pretRepository.findAll();
        List<PretDto> list = new ArrayList<>();
        for (Pret pr : datas) {
            list.add(PretDto.fromEntity(pr));
        }
        return list;
    }

    @Override
    public PretDto savePret(PretDto pretDto) {
        Pret pr = pretRepository.save(PretDto.toEntity(pretDto));
        return PretDto.fromEntity(pr);
    }

    @Override
    public PretDto updatePret(PretDto pretDto, Integer idPret) {
        Pret foundPret = pretRepository.findById(idPret).get();
        if (foundPret != null) {
            foundPret.setId(pretDto.getId());
            foundPret.setNomBanque(pretDto.getNomBanque());
            foundPret.setMotif(pretDto.getMotif());
            foundPret.setMontant(pretDto.getMontant());
            foundPret.setRembousser(pretDto.getRembousser());
            foundPret.setDate(LocalDate.parse(pretDto.getDate()));

            Pret pr = pretRepository.save(PretDto.toEntity(pretDto));
            return PretDto.fromEntity(pr);

        }
        return null;
    }

    @Override
    public PretDto getPretById(Integer idPret) {
        Pret pr = pretRepository.findById(idPret).get();
        return PretDto.fromEntity(pr);
    }

    @Override
    public void deletePret(Integer idPret) {
        pretRepository.deleteById(idPret);

    }

    @Override
    public PretDto ajouterReglement(Integer idPret, Integer SommeRegler) {
        Pret pR = pretRepository.findById(idPret)
                .orElseThrow(() -> new IllegalArgumentException("Pret non trouvé"));

        int totalReglementPret = pR.getRembousser() + SommeRegler;
        if (totalReglementPret <= pR.getMontant()) {
            pR.setRembousser(totalReglementPret);

            Pret pr = pretRepository.save(pR);
            return PretDto.fromEntity(pr);
        } else {
            throw new IllegalArgumentException("La totalité du montant des réglement est supérieur au montant du pret .");
        }

    }

    @Override
    public List<PretDto> getAllPretByPeriod(String dateDebut, String dateFin) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return pretRepository.getPretByDateBetween(LocalDate.parse(dateDebut, formatter),LocalDate.parse(dateFin,formatter)).stream()
                .map(PretDto::fromEntity)
                .collect(Collectors.toList());

    }
}


