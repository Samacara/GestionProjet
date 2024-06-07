package com.apprentice.gestionProjet.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
@RequiredArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate dateCreation;

    @UpdateTimestamp
    private LocalDate dateModification;
}
