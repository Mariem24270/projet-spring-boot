package com.donasso.gestion_dons.repository;

import com.donasso.gestion_dons.entity.Association;
import com.donasso.gestion_dons.enums.StatutAssociation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssociationRepository extends JpaRepository<Association, Long> {

    List<Association> findByStatut(StatutAssociation statut);
}