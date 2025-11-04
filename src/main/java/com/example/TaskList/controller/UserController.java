package com.example.TaskList.controller;

import com.example.TaskList.auth.AuthenticationRequest;
import com.example.TaskList.auth.AuthenticationResponse;
import com.example.TaskList.filter.JwtUtil;
import com.example.TaskList.modal.User;
import com.example.TaskList.service.MyUserDetailsService;
import com.example.TaskList.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tasklist/auth")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> LoginUser(@Valid @RequestBody AuthenticationRequest authenticationRequest){
        final String jwt= userService.userlogin(authenticationRequest);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<String> RegisterUser(@Valid @RequestBody User user){
        String registerMsg= userService.userRegister(user);
        return new ResponseEntity<>(registerMsg, HttpStatus.OK);
    }

}
