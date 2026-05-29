package com.donasso.gestion_dons.controller;

import com.donasso.gestion_dons.entity.Association;
import com.donasso.gestion_dons.service.AssociationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/associations")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AssociationController {

    private final AssociationService service;

    @PostMapping("/inscription")
    public Association create(@RequestBody Association a) {
        return service.createAssociation(a);
    }

    @GetMapping
    public List<Association> getAll() {
        return service.getAllAssociations();
    }

    @PutMapping("/{id}/valider")
    public Association valider(@PathVariable Long id,
                               @RequestParam boolean accepter) {
        return service.valider(id, accepter);
    }
}