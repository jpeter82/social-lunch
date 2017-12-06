package com.peanuts.sociallunch.repository;

import com.peanuts.sociallunch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);

    User findByUserName(String userName);
}
