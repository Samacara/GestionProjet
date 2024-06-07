package com.apprentice.gestionProjet.Controller;

import com.apprentice.gestionProjet.Controller.API.UsersApi;
import com.apprentice.gestionProjet.DTO.UsersDto;
import com.apprentice.gestionProjet.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController implements UsersApi {
    private UsersService usersService;
    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public ResponseEntity<Object> saveUsers(UsersDto usersDto) {
        return ResponseEntity.ok().body(usersService.saveUsers(usersDto));
    }

    @Override
    public ResponseEntity<Object> updateUsers(UsersDto usersDto, Integer idUsers) {
        return ResponseEntity.ok().body(usersService.updateUsers(usersDto, idUsers));
    }

    @Override
    public ResponseEntity<Object> getOneUser(Integer idUsers) {
        return ResponseEntity.ok().body(usersService.getOneUser(idUsers));
    }

    @Override
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok().body(usersService.getAllUsers());
    }

    @Override
    public void deleteOneUser(Integer idUsers) {
        usersService.deleteUsers(idUsers);

    }
}
