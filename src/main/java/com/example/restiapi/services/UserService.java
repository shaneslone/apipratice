package com.example.restiapi.services;

import com.example.restiapi.models.User;
import com.example.restiapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) return user.get();
        else
        {
            throw new IllegalStateException("User with id " + id + " not found!");
        }
    }

    public User findUserByEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()) return user.get();
        else
        {
            throw new IllegalStateException("User with email " + email + " not found!");
        }
    }

    public User save(User newUser) {
        Optional<User> user = userRepository.findByEmail(newUser.getEmail());
        if(user.isPresent()) throw new IllegalStateException("User with email " + newUser.getEmail() + " already exist!");
        return userRepository.save(newUser);
    }
}
