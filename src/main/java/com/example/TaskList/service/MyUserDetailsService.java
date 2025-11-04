package com.example.TaskList.service;
import com.example.TaskList.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepo userRepo;

    @Autowired
    public MyUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.example.TaskList.modal.User user = userRepo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("Email for this user do not exist"+ email));
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail()) // email used as username
                .password(user.getPassword())
                .roles("USER")
                .build();

    }
}
