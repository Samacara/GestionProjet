package com.apprentice.gestionProjet.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class Users extends BaseEntity {
    private String email;
    private String username;
    private  String password;
    private  String role;
}
