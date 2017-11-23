package com.peanuts.sociallunch.dao;

import com.peanuts.sociallunch.model.Address;
import com.peanuts.sociallunch.model.Event;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

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

    public List<Event> getAll() {

        List<Event> events = em.createNamedQuery("getAllEvents", Event.class).getResultList();
        return events;
    }

    public Event findEventById(String eventId) {

        long eventIdLong = Long.parseLong(eventId);
        Query eventQuery = em.createNamedQuery("findEventById", Event.class).setParameter("id", eventIdLong);
        List<Event> result = eventQuery.getResultList();
        Event eventById = result.get(0);

        return eventById;
    }

}
