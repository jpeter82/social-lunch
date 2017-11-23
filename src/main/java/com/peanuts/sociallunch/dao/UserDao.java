package com.peanuts.sociallunch.dao;

import com.peanuts.sociallunch.model.User;

import javax.persistence.EntityManager;

public class UserDao {

    private EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User getById(long userId){
        User user =  entityManager.createNamedQuery("getUserById", User.class).setParameter("id",userId).getSingleResult();
        return user;
    }

}