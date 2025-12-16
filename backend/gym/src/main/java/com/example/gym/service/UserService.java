package com.example.gym.service;

import com.example.gym.entity.User;
import com.example.gym.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User Id not found"));
    }

    public User updateUser(Long id, User user){
        User user1 = getById(id);
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());

        return userRepository.save(user1);
    }

    public void delete(Long id){
        if(!userRepository.existsById(id)){
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

}
