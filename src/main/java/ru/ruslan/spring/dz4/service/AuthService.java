package ru.ruslan.spring.dz4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.ruslan.spring.dz4.dto.RegisterDto;
import ru.ruslan.spring.dz4.enums.Role;
import ru.ruslan.spring.dz4.model.MyUser;
import ru.ruslan.spring.dz4.repository.UserRepository;
import ru.ruslan.spring.dz4.util.JWTUtil;

@Service
public class AuthService {

    private JWTUtil jwtUtil;
    private UserRepository userRepository;

    @Autowired
    public AuthService(JWTUtil jwtUtil, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    public String register(RegisterDto user) {
        MyUser newUser = new MyUser(null, user.getLogin(), user.getPassword(), user.getEmail(), Role.USER);
        System.out.println(newUser);
        userRepository.save(newUser);
        return jwtUtil.generateToken(newUser.getLogin());
    }
}
