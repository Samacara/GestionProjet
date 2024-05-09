package com.apprentice.gestionProjet.Repository;

import com.apprentice.gestionProjet.Entity.Depense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepenseRepository extends JpaRepository<Depense, Integer> {
}
