package com.peanuts.sociallunch.util;

import com.peanuts.sociallunch.model.Event;
import com.peanuts.sociallunch.model.User;
import com.peanuts.sociallunch.repository.EventRepository;
import com.peanuts.sociallunch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public void deleteAll() {
        eventRepository.deleteAll();
    }

    public void saveEvent(Event entity) {
        eventRepository.save(entity);
    }

    public Event findById(Long id) {
        return eventRepository.findOne(id);
    }

    public List<Event> findByName(String title) {
        return eventRepository.findByTitle(title);
    }
}
