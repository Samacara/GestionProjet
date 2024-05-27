package com.apprentice.gestionProjet.Repository;

import com.apprentice.gestionProjet.Entity.Pret;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PretRepository extends JpaRepository<Pret, Integer> {
}
