package com.apprentice.gestionProjet.Controller.API;

import com.apprentice.gestionProjet.DTO.ReglementPretDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ReglementPretApi {

    @PostMapping("/api/v1/reglements/{idPret}/prets")
    public ResponseEntity<Object> saveReglement(@RequestBody ReglementPretDto reglementPretDto, @PathVariable(value = "idPret") Integer idPret);

    @PutMapping("/api/v1/reglements/{idReglement}")
    public ResponseEntity<Object> UpdateReglement(Integer idReglement, ReglementPretDto reglementPretDto);

    @GetMapping("/api/v1/reglements/{idReglement}")
    public ResponseEntity<Object> getReglementById(@PathVariable(value = "idReglement")Integer idReglement);

    @GetMapping("/api/v1/reglements")
    public ResponseEntity<Object> getAllReglement();

    @DeleteMapping("/api/v1/reglements/{idReglement}")
    public void deleteReglement(@PathVariable(value = "idReglement") Integer idReglement);
}
