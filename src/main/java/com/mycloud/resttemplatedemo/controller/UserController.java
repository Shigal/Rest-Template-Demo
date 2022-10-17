package com.mycloud.resttemplatedemo.controller;/*
 *
 * @author Lawshiga
 *
 */

import com.mycloud.resttemplatedemo.exception.ResourceNotFoundException;
import com.mycloud.resttemplatedemo.model.UserData;
import com.mycloud.resttemplatedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserData> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserData getUserById(@PathVariable(value = "id") int userId){
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with this id " + userId));
    }

    @PostMapping
    public ResponseEntity<UserData> createUser(@RequestBody UserData user){
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public UserData updateUser(@RequestBody UserData userData, @PathVariable("id") int userId){
        UserData existingUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with id:"+ userId));
        if(userData.getFirstName() != null) {
            existingUser.setFirstName(userData.getFirstName());
        }
        if(userData.getLastName() != null) {
            existingUser.setLastName(userData.getLastName());
        }
        if(userData.getEmail() != null) {
            existingUser.setEmail(userData.getEmail());
        }

        return userRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserData> deleteUser(@PathVariable(value = "id") int userId){
        UserData existingUser = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("user not found with the id: " + userId));
        userRepository.delete(existingUser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
