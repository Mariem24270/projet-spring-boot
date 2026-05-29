package com.donasso.gestion_dons.controller;

import com.donasso.gestion_dons.entity.User;
import com.donasso.gestion_dons.repository.UserRepository;
import com.donasso.gestion_dons.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ✅ تسجيل مستخدم جديد
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        // تشفير كلمة المرور قبل الحفظ
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("Utilisateur créé avec succès");
    }

    // ✅ تسجيل الدخول والحصول على Token
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email incorrect"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.status(401).body("Mot de passe incorrect");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
        return ResponseEntity.ok(Map.of(
                "token", token,
                "role", user.getRole(),
                "nom", user.getNom()
        ));
    }
}
