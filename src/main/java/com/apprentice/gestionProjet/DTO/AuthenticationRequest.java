package com.apprentice.gestionProjet.DTO;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;

    // Getters and setters
}