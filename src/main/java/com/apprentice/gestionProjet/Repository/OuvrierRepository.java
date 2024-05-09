package com.apprentice.gestionProjet.Repository;

import com.apprentice.gestionProjet.Entity.Ouvrier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OuvrierRepository extends JpaRepository<Ouvrier, Integer> {
}
