package com.apprentice.gestionProjet.Controller.API;


import com.apprentice.gestionProjet.DTO.OuvrierDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface OuvrierApi {
    //enregistre un Ouvier
    @PostMapping("/api/v1/ouviers/creer")
    public ResponseEntity<Object> CreateOuvier(@RequestBody OuvrierDto ouvrier);

    //Modifier un ouvrier
    @PutMapping("/api/v1/ouviers/{idOuvier}")
    public ResponseEntity<Object> UpdateOuvrier(@RequestBody OuvrierDto ouvrierDto, @PathVariable(value ="idOuvier") Integer idOuvier);

    //recupere un seul Ouvier
    @GetMapping("/api/v1/ouviers/{idOuvier}")
    public ResponseEntity<Object> getOneOuvier(@PathVariable(value = "idOuvier") Integer idOuvier);

    //supprime un Ouvier
    @DeleteMapping("/api/v1/ouviers/{idOuvier}")
    public void DeleteOuvier(@PathVariable(value = "idOuvier") Integer idOuvier);

    //recupere toutes les Ouviers
    @GetMapping("api/v1/ouviers")
    public ResponseEntity<Object> getAllOuviers();

}
