package com.peanuts.sociallunch.logic;


import com.peanuts.sociallunch.dao.AddressDao;
import com.peanuts.sociallunch.dao.EventDao;
import com.peanuts.sociallunch.dao.UserDao;
import com.peanuts.sociallunch.model.Event;

import com.peanuts.sociallunch.model.User;
import com.peanuts.sociallunch.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {

    private EventDao eventDao;
    private UserDao userDao;
    private AddressDao addressDao;

    public EventController(EventDao eventDao, UserDao userDao, AddressDao addressDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
        this.addressDao = addressDao;
    }

    public void addEvent(Event event) {
        eventDao.saveEvent(event);
    }

    @RequestMapping(value = "/addevent", method = RequestMethod.GET)
    public String showNewEventForm(Model model) {
        model.addAttribute("addresses", addressDao.getAll());
        model.addAttribute("event", new Event());
        return "new-event";
    }

    @RequestMapping(value = "/addevent", method = RequestMethod.POST)
    public String addEventForm(@ModelAttribute Event event, @RequestParam String addressId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        event.setHost(userDao.findByUsername(username));
        event.setAddress(addressDao.findById(Integer.parseInt(addressId)));
        addEvent(event);
        return "redirect:/";
    }

    @RequestMapping(value = "/event/{event-id}/join", method = RequestMethod.GET)
    public String joinEvent(@PathVariable("event-id") String eventId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Event event = eventDao.findEventById(eventId);

        if (!auth.getName().equals(event.getHost().getUsername())) {
            event.getJoinedUsers().add(userDao.findByUsername(username));
            eventDao.saveEvent(event);
        }

        return "redirect:/event?eid=" + eventId;
    }

    @RequestMapping(value = "/event/{event-id}/leave", method = RequestMethod.GET)
    public String leaveEvent(@PathVariable("event-id") String eventId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Event event = eventDao.findEventById(eventId);
        User user = userDao.findByUsername(username);
        event.getJoinedUsers().remove(user);
        eventDao.saveEvent(event);
        return "redirect:/event?eid=" + eventId;
    }

}
