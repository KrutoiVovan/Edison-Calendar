package com.tut.vivacloud.controllers;

import com.tut.vivacloud.model.User;
import com.tut.vivacloud.model.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class InitUsersController {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    PasswordEncoder encoder;
    @PostMapping("/newuser")
    public void createUser(@RequestParam String username, @RequestParam String password){
        userDetailsRepository.save(new User(username, password, encoder));
    }

}
