package com.apprentice.gestionProjet.Repository;

import com.apprentice.gestionProjet.Entity.Pret;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PretRepository extends JpaRepository<Pret, Integer> {
    List<Pret> getPretByDateBetween(LocalDate dateDebut, LocalDate dateFin);

//    List<Pret> findByDateBetween(LocalDate dateDebut, LocalDate dateFin );


}
