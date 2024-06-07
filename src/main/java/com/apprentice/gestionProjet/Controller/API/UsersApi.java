package com.apprentice.gestionProjet.Controller.API;

import com.apprentice.gestionProjet.DTO.UsersDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface UsersApi {

    @PostMapping("/utilisateur/connexion/ghx")
    public ResponseEntity<Object> saveUsers(@RequestBody UsersDto usersDto);

    @PutMapping("/api/v1/users/{idUsers}")
    public ResponseEntity<Object> updateUsers(@RequestBody  UsersDto usersDto, @PathVariable(value = "idUsers") Integer idUsers);

    @GetMapping("/api/v1/users/{idUsers}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "idUsers") Integer idUsers);

    @GetMapping("api/v1/users")
    public ResponseEntity<Object> getAllUsers();

    @DeleteMapping("/api/v1/users/{idUsers}")
    public void deleteOneUser(@PathVariable(value = "idUsers") Integer idUsers);
}
