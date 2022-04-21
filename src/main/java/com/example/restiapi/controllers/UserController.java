package com.example.restiapi.controllers;

import com.example.restiapi.models.User;
import com.example.restiapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String welcome(){
        return "Hello World";
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userService.findAll();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserById(@RequestParam(required = false) Long id, @RequestParam(required = false) String email){
        if(id != null) {
            User user = userService.findUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        if(email != null) {
            User user = userService.findUserByEmail(email);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/user")
    public ResponseEntity<?> addNewUser(@RequestBody User newUser){
        User user = userService.save(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
