package com.donasso.gestion_dons.controller;

import com.donasso.gestion_dons.entity.Don;
import com.donasso.gestion_dons.enums.StatutDon;
import com.donasso.gestion_dons.service.DonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/dons")
@CrossOrigin(origins = "*")
public class DonController {

    @Autowired
    private DonService donService;

    // =========================
    // AJOUTER UN DON
    // =========================
    @PostMapping
    public Don ajouterDon(@RequestBody Don don) {
        return donService.ajouterDon(don);
    }

    // =========================
    // LISTE DES DONS
    // =========================
    @GetMapping
    public List<Don> getAllDons() {
        return donService.getAllDons();
    }

    // =========================
    // FILTRE PAR TYPE
    // =========================
    @GetMapping("/type/{type}")
    public List<Don> getByType(@PathVariable String type) {
        return donService.getByType(type);
    }

    // =========================
    // FILTRE PAR STATUT
    // =========================
    @GetMapping("/statut/{statut}")
    public List<Don> getByStatut(@PathVariable StatutDon statut) {
        return donService.getByStatut(statut);
    }

    // =========================
    // SUPPRIMER DON
    // =========================
    @DeleteMapping("/{id}")
    public void deleteDon(@PathVariable Long id) {
        donService.deleteDon(id);
    }

    // =========================
    // UPLOAD IMAGE
    // =========================
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            Path uploadDir = Paths.get("uploads");
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            Path filePath = uploadDir.resolve(fileName);
            Files.write(filePath, file.getBytes());

            return fileName;

        } catch (Exception e) {
            return "Erreur upload: " + e.getMessage();
        }
    }
}