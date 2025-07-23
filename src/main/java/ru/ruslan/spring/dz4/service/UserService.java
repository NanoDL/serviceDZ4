package ru.ruslan.spring.dz4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.ruslan.spring.dz4.model.MyUser;
import ru.ruslan.spring.dz4.repository.UserRepository;
import ru.ruslan.spring.dz4.util.CustomUserDetails;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MyUser findUserByUsername(String username) {
        return userRepository.findByLogin(username).orElse(null);
    }

    public MyUser getUserFromContext(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
            return null;
        }
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        return customUserDetails.getUser();
    }
}
