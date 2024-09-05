package com.example.utilisateur.Auth;

import com.example.utilisateur.Config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private JwtService jwtService;

    private final AuthenticationService authenticationService;

    // Enregistre un utilisateur standard (non admin)
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(
            @RequestBody RegisterRequest request
    ) {
        // Logique pour enregistrer un utilisateur avec un rôle USER
        return ResponseEntity.ok(authenticationService.register(request));
    }

//    // Enregistre un administrateur
//    @PostMapping("/register/admin")
//    public ResponseEntity<AuthenticationResponse> registerAdmin(
//            @RequestBody RegisterRequest request
//    ) {
//        // Logique spécifique pour enregistrer un administrateur
//        return ResponseEntity.ok(authenticationService.registerAdmin(request));
//    }

    // Authentifie un utilisateur (qu'il soit USER ou ADMIN)
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        // Logique pour authentifier un utilisateur existant
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        jwtService.validateToken(token);
        return "Token is valid";
    }
}
