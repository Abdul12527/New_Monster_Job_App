package com.Monster.NewMonster.controller;

import com.Monster.NewMonster.Model.Users;
import com.Monster.NewMonster.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @Autowired
    private UsersServices usersServices;

    @PostMapping("/user/register")
    public ResponseEntity<String> registerUser(@RequestBody Users users){
        return ResponseEntity.ok(usersServices.addUsers(users));
    }
}
