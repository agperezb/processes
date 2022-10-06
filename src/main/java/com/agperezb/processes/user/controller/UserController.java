package com.agperezb.processes.user.controller;

import com.agperezb.processes.user.entity.User;
import com.agperezb.processes.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(this.userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
        Optional<User> user = this.userService.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        List<User> user = this.userService.findByName(name);
        if (user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<?> save(@RequestBody User user) {
        try {
            User userSave = this.userService.save(user);
            return new ResponseEntity<>(userSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody User user) {
        try {
            Optional<User> userBd = this.userService.findById(id);
            if (userBd.isPresent()) {
                User userUpdate = this.userService.save(user);
                return new ResponseEntity<>(userUpdate, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        Optional<User> userBD = userService.findById(id);
        if(userBD.isPresent()){
            userService.delete(userBD.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
