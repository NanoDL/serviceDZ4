package ru.ruslan.spring.dz4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.ruslan.spring.dz4.dto.RegisterDto;
import ru.ruslan.spring.dz4.model.MyUser;
import ru.ruslan.spring.dz4.service.AuthService;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final AuthService authService;

    @Autowired
    public HelloController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/register")
    public String register() {
        return "register/index";
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterDto user) {
        System.out.println(user);
        return authService.register(user);
    }
}
