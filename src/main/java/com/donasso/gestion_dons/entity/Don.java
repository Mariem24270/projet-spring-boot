package com.donasso.gestion_dons.entity;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;
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

    @NotNull
    private String titre;

    private String description;
    @NotNull
    private String typeDon;

    private Double montant;

    private String image;

    @Enumerated(EnumType.STRING)
    private StatutDon statut;
}