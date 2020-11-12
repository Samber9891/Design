package com.tts.designlab.controller;

import java.util.List;
import java.util.Optional;

import com.tts.designlab.model.User;
import com.tts.designlab.repository.UserRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRespository userRepository;

    @GetMapping(value = "/users")
    public List<User> getUsers(@RequestParam(value="state", required=false) String state) {
        if(state != null) {
            return (List<User>) userRepository.findByState(state);
        } else {
            return (List<User>) userRepository.findAll(); 
        }
       
    }

    @GetMapping(value = "/user/{id}")
    public Optional<User> getUser(@PathVariable(value = "id") Long id) {

        return userRepository.findById(id);
    }

    @PostMapping(value = "/users/")
    public void createUser(@RequestBody User user) {

        System.out.println(user);
        userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public void editUser(@PathVariable (value ="id") Long id, @RequestBody User user) {
       
        userRepository.save(user); 


    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
    userRepository.deleteById(id); 

    }

}
