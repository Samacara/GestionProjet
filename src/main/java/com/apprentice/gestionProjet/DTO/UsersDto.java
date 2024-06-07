package com.apprentice.gestionProjet.DTO;

import com.apprentice.gestionProjet.Entity.Users;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UsersDto {
    private  Integer id;

    private  String role;
    private String email;
    private String username;
    private  String password;
    private LocalDate dateModification;
    private LocalDate dateCreation;

    public static UsersDto fromEntity(Users users){
        return UsersDto.builder()
                .id(users.getId())
                .dateCreation(users.getDateCreation())
                .dateModification(users.getDateModification())
                .role(users.getRole())
                .email(users.getEmail())
                .username(users.getUsername())
                .password(users.getPassword())
                .build();
    }

    public static Users toEntity(UsersDto usersDto){

        return Users.builder()
                .id(usersDto.getId())
                .email(usersDto.getEmail())
                .role(usersDto.getRole())
                .username(usersDto.getUsername())
                .password(usersDto.getPassword())
                .build();
    }
}
