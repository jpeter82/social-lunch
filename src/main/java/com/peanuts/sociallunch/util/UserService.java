package com.peanuts.sociallunch.util;

import com.peanuts.sociallunch.UserRepository;
import com.peanuts.sociallunch.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public void saveUser(User entity) {
        userRepository.save(entity);
    }

    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    public List<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
