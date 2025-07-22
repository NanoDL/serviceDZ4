package ru.ruslan.spring.dz4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ruslan.spring.dz4.dto.RegisterDto;
import ru.ruslan.spring.dz4.model.MyUser;

@Controller
@RequestMapping("/api")
public class HelloController {


    @GetMapping("/register")
    public String register() {
        return "register/index";
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterDto user) {

    }
}
