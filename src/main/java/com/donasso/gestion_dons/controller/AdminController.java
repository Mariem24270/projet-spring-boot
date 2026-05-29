package com.donasso.gestion_dons.controller;

import com.donasso.gestion_dons.entity.Association;
import com.donasso.gestion_dons.entity.Don;
import com.donasso.gestion_dons.entity.User;
import com.donasso.gestion_dons.repository.AssociationRepository;
import com.donasso.gestion_dons.repository.DonRepository;
import com.donasso.gestion_dons.repository.UserRepository;
import com.donasso.gestion_dons.dto.StatsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DonRepository donRepository;

    @Autowired
    private AssociationRepository associationRepository;

    // ✅ عرض كل المستخدمين
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ عرض كل الدونات
    @GetMapping("/dons")
    public List<Don> getAllDons() {
        return donRepository.findAll();
    }

    // ✅ عرض كل الجمعيات
    @GetMapping("/associations")
    public List<Association> getAllAssociations() {
        return associationRepository.findAll();
    }

    // ✅ حذف دون
    @DeleteMapping("/dons/{id}")
    public ResponseEntity<String> deleteDon(@PathVariable Long id) {
        donRepository.deleteById(id);
        return ResponseEntity.ok("Don supprimé avec succès");
    }

    // ✅ حظر مستخدم
    @PutMapping("/users/{id}/ban")
    public ResponseEntity<String> banUser(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User non trouvé"));
        user.setRole("BANNED");
        userRepository.save(user);
        return ResponseEntity.ok("Utilisateur banni");
    }

    // ✅ الإحصائيات العامة
    @GetMapping("/stats")
    public StatsDTO getStats() {
        StatsDTO stats = new StatsDTO();
        stats.setNombreDons(donRepository.count());
        stats.setNombreAssociations(associationRepository.count());
        stats.setNombreUsers(userRepository.count());
        return stats;
    }
}