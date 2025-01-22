package com.komarov.coffee_maker_api.controller;

import com.komarov.coffee_maker_api.entity.UserEntity;
import com.komarov.coffee_maker_api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserEntity userOut) {
        UserEntity user = userService.findByUsername(userOut.getUsername());
        if (user != null) {
            if (Objects.equals(user.getPassword(), userOut.getPassword())){
                return ResponseEntity.ok(user);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserEntity user) {
        userService.save(user);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
