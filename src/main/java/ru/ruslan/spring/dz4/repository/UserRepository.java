package ru.ruslan.spring.dz4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ruslan.spring.dz4.model.MyUser;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long> {

    Optional<MyUser> findByLogin(String login);
}
