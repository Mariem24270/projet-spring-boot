package com.donasso.gestion_dons.service;

import com.donasso.gestion_dons.entity.Association;
import java.util.List;

public interface AssociationService {

    Association createAssociation(Association a);

    List<Association> getAllAssociations();

    Association getById(Long id);

    Association valider(Long id, boolean accepter);
}