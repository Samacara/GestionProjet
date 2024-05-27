package com.apprentice.gestionProjet.Repository;

import com.apprentice.gestionProjet.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}
