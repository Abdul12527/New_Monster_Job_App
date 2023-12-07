package com.Monster.NewMonster.repository;

import com.Monster.NewMonster.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsersRepo extends JpaRepository<Users,Integer> {
    Optional<Users> findByEmail(String email);
}
