package com.peanuts.sociallunch.dao;

import com.peanuts.sociallunch.model.User;
import com.peanuts.sociallunch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import java.util.List;

@Service
public class UserDao {

    @Autowired
    UserRepository userRepository;

    public void saveUser (User user) {
        userRepository.save(user);
    }

    public User findById (long id) {
        return userRepository.findOne(id);
    }

    public User findByUsername (String username) {
        return userRepository.findUserByUsername(username);
    }

    public List<User> findAll() {
       return userRepository.findAll();
    }



}