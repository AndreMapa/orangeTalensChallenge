package com.orangeChallenge.orangeChallenge.repository;

import com.orangeChallenge.orangeChallenge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByCpf (String cpf);
    Boolean existsByEmail(String email);
}
