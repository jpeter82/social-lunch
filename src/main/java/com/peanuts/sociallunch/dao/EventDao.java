package com.peanuts.sociallunch.dao;

import com.peanuts.sociallunch.model.Address;
import com.peanuts.sociallunch.model.Event;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EventDao {

    private EntityManager em;

    public EventDao(EntityManager em) {
        this.em = em;
    }

    public List<Event> getAll() {

        List<Event> events = em.createNamedQuery("getAllEvents", Event.class).getResultList();
        return events;

    }

    public List<Event> findEventById(String eventId) {

        long eventIdLong = Long.parseLong(eventId);
        Query eventQuery = em.createNamedQuery("findEventById", Event.class).setParameter("id", eventIdLong);
        List<Event> result = eventQuery.getResultList();

        return result;
    }
}
