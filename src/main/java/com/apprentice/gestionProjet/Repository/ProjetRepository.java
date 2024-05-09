package com.apprentice.gestionProjet.Repository;

import com.apprentice.gestionProjet.Entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {
}
