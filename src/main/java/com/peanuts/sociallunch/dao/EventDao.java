package com.peanuts.sociallunch.dao;

import com.peanuts.sociallunch.model.Event;

import javax.persistence.EntityManager;

public class EventDao {

    private EntityManager entityManager;

    public EventDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Event event) {
        entityManager.getTransaction().begin();
        entityManager.persist(event);
        entityManager.getTransaction().commit();
    }

}
