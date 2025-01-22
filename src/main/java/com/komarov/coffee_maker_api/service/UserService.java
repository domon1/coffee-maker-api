package com.komarov.coffee_maker_api.service;

import com.komarov.coffee_maker_api.entity.UserEntity;
import com.komarov.coffee_maker_api.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void save(UserEntity user){
        userRepository.save(user);
    }
}
