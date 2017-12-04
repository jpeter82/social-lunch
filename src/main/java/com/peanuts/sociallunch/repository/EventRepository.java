package com.peanuts.sociallunch.repository;

import com.peanuts.sociallunch.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByTitle(String title);

}
