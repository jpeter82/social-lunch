package com.peanuts.sociallunch.dao;

import com.peanuts.sociallunch.model.Address;
import com.peanuts.sociallunch.model.Event;
import com.peanuts.sociallunch.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class EventDao {

    @Autowired
    private EventRepository eventRepository;
  
    public void saveEvent(Event event) {
        eventRepository.save(event);
    }

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    public Event findEventById(long eventId) {
        return eventRepository.findOne(eventId);
    }

}
