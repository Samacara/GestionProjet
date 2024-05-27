package com.apprentice.gestionProjet.Repository;

import com.apprentice.gestionProjet.Entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}
