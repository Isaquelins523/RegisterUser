package com.Lins.RegisterUser_Java_Spring.controllers;

import com.Lins.RegisterUser_Java_Spring.domain.user.RequestUser;
import com.Lins.RegisterUser_Java_Spring.domain.user.User;
import com.Lins.RegisterUser_Java_Spring.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity getAllUsers() {
        var allUsers = repository.findAll();
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping
    public ResponseEntity CreateUser(@RequestBody @Validated RequestUser data){
        User newUser = new User(data);
        repository.save(newUser);
        return ResponseEntity.ok("user created successfully");
    }

    @PutMapping
    public ResponseEntity UpdatedUser(@RequestBody @Validated RequestUser data){
        Optional<User> optionalUser = repository.findById(data.id());
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setName(data.name());
            user.setEmail(data.email());
            user.setAge((Integer) data.age());

            repository.save(user);

            return ResponseEntity.ok("User updated");
        }else {
            return ResponseEntity.notFound().build();
        }
    };

    @DeleteMapping("/{id}")
    public ResponseEntity DeleteUser(@PathVariable("id") String id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.ok("User deleted");
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
