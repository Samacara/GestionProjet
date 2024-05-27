package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.CategorieDto;
import com.apprentice.gestionProjet.Entity.Categorie;
import com.apprentice.gestionProjet.Repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategorieServiceImpl implements CategorieService {

    private CategorieRepository categorieRepository;
    @Autowired
    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }


    @Override
    public CategorieDto saveCategorie(CategorieDto categorieDto) {
        Categorie ca = categorieRepository.save(CategorieDto.toEntity(categorieDto));
        return CategorieDto.fromEntity(ca);
    }

    @Override
    public CategorieDto updateCategorie(CategorieDto categorieDto, Integer idCategorie) {
        Categorie foundCategorie= categorieRepository.findById(idCategorie).get();

        if (foundCategorie !=null){

            foundCategorie.setId(categorieDto.getId());
            foundCategorie.setDescription(categorieDto.getDescription());

            Categorie ca = categorieRepository.save(foundCategorie);
            return CategorieDto.fromEntity(ca);
        }

        return null;
    }

    @Override
    public CategorieDto getCategorieById(Integer idCategorie) {
        Categorie ca = categorieRepository.findById(idCategorie).get();
        return CategorieDto.fromEntity(ca);
    }

    @Override
    public List<CategorieDto> getAllCategorie() {
        List<Categorie> datas = categorieRepository.findAll();
        List<CategorieDto> list= new ArrayList<>();
        for (Categorie cA: datas){
            list.add(CategorieDto.fromEntity(cA));
        }
        return list;
    }

    @Override
    public void DeleteCategorie(Integer idCategorie) {

        categorieRepository.deleteById(idCategorie);

    }
}
