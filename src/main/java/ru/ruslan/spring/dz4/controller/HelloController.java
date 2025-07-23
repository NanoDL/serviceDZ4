package ru.ruslan.spring.dz4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.ruslan.spring.dz4.dto.LoginDto;
import ru.ruslan.spring.dz4.dto.RegisterDto;
import ru.ruslan.spring.dz4.enums.Role;
import ru.ruslan.spring.dz4.model.MyUser;
import ru.ruslan.spring.dz4.service.AuthService;
import ru.ruslan.spring.dz4.service.UserService;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final AuthService authService;
    private final UserService userService;

    @Autowired
    public HelloController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
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

    @PostMapping("/login")
    public String login(@RequestBody LoginDto user) {
        return authService.login(user);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        MyUser user = userService.getUserFromContext();
        if (user != null) {
            return ResponseEntity.ok("Hello, " + user.getLogin());
        } else {
            return ResponseEntity.ok("Hello" + "Guest");
        }
    }
}
