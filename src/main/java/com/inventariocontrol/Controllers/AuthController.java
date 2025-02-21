package com.inventariocontrol.Controllers;

import com.inventariocontrol.DTO.LoginRequest;
import com.inventariocontrol.Security.JwtUtil;
import com.inventariocontrol.Repository.UserRepository;
import com.inventariocontrol.Entities.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public AuthController(JwtUtil jwtUtil, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<UserEntity> user = userRepository.findByUsername(request.getUsername());
        if (user.isPresent()) {
            String token = jwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }
    }

}
