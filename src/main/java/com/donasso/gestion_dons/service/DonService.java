package com.donasso.gestion_dons.service;

import com.donasso.gestion_dons.entity.Don;
import com.donasso.gestion_dons.enums.StatutDon;
import com.donasso.gestion_dons.repository.DonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DonService {

    @Autowired
    private DonRepository donRepository;

    // Ajouter Don
    public Don ajouterDon(Don don) {

        don.setStatut(StatutDon.EN_ATTENTE);

        return donRepository.save(don);
    }

    // Afficher tous dons
    public List<Don> getAllDons() {

        return donRepository.findAll();
    }

    // Filtrer type
    public List<Don> getByType(String type) {

        return donRepository.findByTypeDon(type);
    }

    // Filtrer statut
    public List<Don> getByStatut(StatutDon statut) {

        return donRepository.findByStatut(statut);
    }

    // Supprimer don
    public void deleteDon(Long id) {

        donRepository.deleteById(id);
    }
}