package com.donasso.gestion_dons.controller;

import com.donasso.gestion_dons.entity.Don;
import com.donasso.gestion_dons.enums.StatutDon;
import com.donasso.gestion_dons.service.DonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dons")
@CrossOrigin(origins = "*")
public class DonController {

    @Autowired
    private DonService donService;

    @PostMapping
    public Don ajouterDon(@RequestBody Don don) {
        return donService.ajouterDon(don);
    }

    @GetMapping
    public List<Don> getAllDons() {
        return donService.getAllDons();
    }

    @GetMapping("/type/{type}")
    public List<Don> getByType(@PathVariable String type) {
        return donService.getByType(type);
    }

    @GetMapping("/statut/{statut}")
    public List<Don> getByStatut(@PathVariable StatutDon statut) {
        return donService.getByStatut(statut);
    }

    @DeleteMapping("/{id}")
    public void deleteDon(@PathVariable Long id) {
        donService.deleteDon(id);
    }

    @GetMapping("/association/{id}")
    public List<Don> getByAssociation(@PathVariable Long id) {
        return donService.getByAssociation(id);
    }
}