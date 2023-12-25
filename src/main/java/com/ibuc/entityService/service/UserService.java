package com.ibuc.entityService.service;

import com.ibuc.entityService.entity.User;
import com.ibuc.entityService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUser(User user){
        return this.userRepository.save(user);
    }

    public User updateUser(Long userId,User updatedUser){
        User user = this.userRepository.findByUserId(userId);
        if(user != updatedUser){
           return this.userRepository.save(updatedUser);
        }
        return user;
    }

    public User getUserById(Long userId){
        return this.userRepository.findByUserId(userId);
    }
}
