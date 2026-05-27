package com.donasso.gestion_dons.entity;

import com.donasso.gestion_dons.enums.StatutDon;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Don {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    private String typeDon;

    private Double montant;

    private String image;

    @Enumerated(EnumType.STRING)
    private StatutDon statut;

    @ManyToOne
    @JoinColumn(name = "association_id")
    private Association association;
}