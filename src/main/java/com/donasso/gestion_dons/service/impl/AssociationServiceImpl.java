package com.donasso.gestion_dons.service.impl;

import com.donasso.gestion_dons.entity.Association;
import com.donasso.gestion_dons.enums.StatutAssociation;
import com.donasso.gestion_dons.repository.AssociationRepository;
import com.donasso.gestion_dons.service.AssociationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssociationServiceImpl implements AssociationService {

    private final AssociationRepository repo;

    @Override
    public Association createAssociation(Association a) {
        a.setStatut(StatutAssociation.EN_ATTENTE);
        return repo.save(a);
    }

    @Override
    public List<Association> getAllAssociations() {
        return repo.findAll();
    }

    @Override
    public Association getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Association introuvable"));
    }

    @Override
    public Association valider(Long id, boolean accepter) {
        Association a = getById(id);

        a.setStatut(accepter ? StatutAssociation.ACCEPTEE : StatutAssociation.REFUSEE);
        a.setDateReponse(LocalDateTime.now());

        return repo.save(a);
    }
}