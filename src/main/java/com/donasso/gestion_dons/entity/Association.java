package com.donasso.gestion_dons.entity;

import com.donasso.gestion_dons.enums.StatutAssociation;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "associations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;
    private String telephone;
    private String adresse;
    private String description;

    @Enumerated(EnumType.STRING)
    private StatutAssociation statut = StatutAssociation.EN_ATTENTE;

    private LocalDateTime dateDemande;
    private LocalDateTime dateReponse;

    @PrePersist
    public void init() {
        this.dateDemande = LocalDateTime.now();
    }
}