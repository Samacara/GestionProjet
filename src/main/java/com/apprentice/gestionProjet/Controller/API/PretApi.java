package com.apprentice.gestionProjet.Controller.API;

import com.apprentice.gestionProjet.DTO.PretDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface PretApi {

    @PostMapping("/api/v1/prets/creer")
    public ResponseEntity<Object> savePret(@RequestBody PretDto pretDto);

    @PutMapping("/api/v1/prets/{idPret}")
    public ResponseEntity<Object> UpdatePret(@RequestBody PretDto pretDto, @PathVariable(value = "idPret") Integer idPret);

    @GetMapping("/api/v1/prets/{idPret}")
    ResponseEntity<Object> getOnePret(@PathVariable(value = "idPret") Integer idPret);

    @GetMapping("/api/v1/prets")
    public ResponseEntity<Object> getPret();

    @DeleteMapping("/api/v1/prets/{idPret}")
    public void deletePret(@PathVariable(value = "idPret") Integer idPret);
}
