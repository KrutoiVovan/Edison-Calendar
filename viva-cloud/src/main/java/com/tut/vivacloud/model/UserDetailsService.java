package com.tut.vivacloud.model;

import com.tut.vivacloud.model.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    UserDetailsRepository repo;

    @Autowired
    public UserDetailsService(UserDetailsRepository repo) {
        this.repo = repo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<User> details = repo.findById(username);
            if(details.isPresent()){
                return details.get();
            }
            throw new UsernameNotFoundException("Couldn't find user with username = " + username);
        }
}
