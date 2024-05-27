package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.OuvrierDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface OuvrierService {

    public List<OuvrierDto> getallOuvrier();


    public OuvrierDto saveOuvrier (OuvrierDto ouvrier);

    public OuvrierDto updateOuvrierById(OuvrierDto ouvrierDto, Integer id);

    public OuvrierDto getOuvrierById(Integer IdOuvrier);

    public void deleteOuvrierById(Integer IdOuvrier);

    public OuvrierDto ajouterOuvrierAProjet(Integer IdOuvrier, Integer idProjet, Integer salaire);

    public Page<OuvrierDto> findPagination(Integer pagesize, Integer pageno, String sortfield, String sortdirection);
}
