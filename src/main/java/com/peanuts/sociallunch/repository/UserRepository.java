package com.peanuts.sociallunch.repository;

import com.peanuts.sociallunch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);


}
