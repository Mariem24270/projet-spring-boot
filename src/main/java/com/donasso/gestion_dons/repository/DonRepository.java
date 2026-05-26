package com.donasso.gestion_dons.repository;

import com.donasso.gestion_dons.entity.Don;
import com.donasso.gestion_dons.enums.StatutDon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonRepository extends JpaRepository<Don, Long> {

    List<Don> findByTypeDon(String typeDon);

    List<Don> findByStatut(StatutDon statut);
}