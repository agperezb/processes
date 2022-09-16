package com.agperezb.processes.user.service;

import com.agperezb.processes.user.entity.User;
import com.agperezb.processes.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public record UserService(UserRepository userRepository) {

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public Optional<User> findById(UUID id) {
        return this.userRepository.findById(id);
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }
}
