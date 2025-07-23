package ru.ruslan.spring.dz4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.ruslan.spring.dz4.dto.LoginDto;
import ru.ruslan.spring.dz4.dto.RegisterDto;
import ru.ruslan.spring.dz4.enums.Role;
import ru.ruslan.spring.dz4.model.MyUser;
import ru.ruslan.spring.dz4.repository.UserRepository;
import ru.ruslan.spring.dz4.util.JWTUtil;

@Service
public class AuthService {

    private final DaoAuthenticationProvider authenticationProvider;
    private final AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(JWTUtil jwtUtil, UserRepository userRepository, PasswordEncoder passwordEncoder, DaoAuthenticationProvider authenticationProvider, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationProvider = authenticationProvider;
        this.authenticationManager = authenticationManager;
    }

    public String register(RegisterDto user) {
        String encodePassword = passwordEncoder.encode(user.getPassword());
        MyUser newUser = new MyUser(null, user.getLogin(), encodePassword, user.getEmail(), Role.USER);

        System.out.println(newUser);
        userRepository.save(newUser);
        return jwtUtil.generateToken(newUser.getLogin());
    }

    public String login(LoginDto user) {
        MyUser dbUser = userRepository.findByLogin(user.getLogin()).orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
            System.out.println("Parol");
            return jwtUtil.generateToken(dbUser.getLogin());
        }
        return null;
    }
}
