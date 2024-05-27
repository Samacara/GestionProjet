package com.apprentice.gestionProjet.Repository;


import com.apprentice.gestionProjet.Entity.ProjetOuvrier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetOuvrierRipository  extends JpaRepository<ProjetOuvrier, Integer> {
}
