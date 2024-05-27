package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.DepenseDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface DepenseService {

    public List<DepenseDto> getallDepense();

    public DepenseDto saveDepense(Integer projetId, DepenseDto depense);

    public DepenseDto updateDepenseById(DepenseDto depenseDto, Integer id);

    public DepenseDto getDepenseById(Integer IdDepense);

    public void deleteDepenseById(Integer IdDepense);

   public Page<DepenseDto> findPagination(Integer pagesize, Integer pageno, String sortfield, String sortdirection);

//    public DepenseDto creerDepense(DepenseDto depenseDto);
//
}
