package ru.ruslan.spring.dz4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ruslan.spring.dz4.model.MyUser;
import ru.ruslan.spring.dz4.repository.UserRepository;

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
}
