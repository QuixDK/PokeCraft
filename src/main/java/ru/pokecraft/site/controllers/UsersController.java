package ru.pokecraft.site.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pokecraft.site.models.users.Users;
import ru.pokecraft.site.models.login.AuthRequest;
import ru.pokecraft.site.models.login.AuthResponse;
import ru.pokecraft.site.models.login.RegistrationRequest;
import ru.pokecraft.site.service.UserService;

import javax.security.sasl.AuthenticationException;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UsersController {

    private UserService userService;
    private ObjectMapper objectMapper;

    @SneakyThrows
    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody @Valid RegistrationRequest request) {
        return ResponseEntity.ok(objectMapper.writeValueAsString(userService.createUsers(request)));
    }

    @SneakyThrows
    @PostMapping("/login")
    public ResponseEntity<String> auth(@RequestBody @Valid AuthRequest request) {
        return ResponseEntity.ok(objectMapper.writeValueAsString(userService.findUserByUsernameAndPassword(request.getUsername(),request.getPassword())));
    }

    @SneakyThrows
    @GetMapping("/{user_id}")
    public ResponseEntity<String> getUserData(@PathVariable(name = "user_id") long userId) {
        return ResponseEntity.ok(objectMapper.writeValueAsString(userService.findUserById(userId).getUsersData()));
    }

}
