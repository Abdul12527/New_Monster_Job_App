package com.Monster.NewMonster.services;

import com.Monster.NewMonster.Model.Users;
import com.Monster.NewMonster.repository.IUsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersServices {
    @Autowired
    private IUsersRepo usersRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users findByEmail(String email){
        return usersRepo.findByEmail(email).orElseThrow();
    }

    public String addUsers(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        usersRepo.save(users);
        return "added successfully";
    }
}
