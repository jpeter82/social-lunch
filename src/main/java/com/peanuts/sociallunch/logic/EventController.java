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

import javax.servlet.http.HttpSession;
import java.security.Principal;

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

/*

    public Route getAllEvents = (Request request, Response response) -> {
        List<Event> result = eventDao.getAll();
        Map params = new HashMap<>();
        params.put("events", result);
        return ViewUtil.render(request, params, "/home/index");
    };

    public Route showAddNewForm = (Request request, Response response) -> ViewUtil.render(request, new HashMap(),"/new-event");

    public Route createNewEvent = (Request request, Response response) -> {

        String title = request.queryParams("event-title");
        Integer capacity = Integer.parseInt(request.queryParams("event-capacity"));
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = new Date();

        try {
            datetime = dateTimeFormatter.parse(request.queryParams("event-date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Address address = new Address("Hungary", "Budapest", "1111", "Some street 43. 4/2", "Home");
        String description = request.queryParams("event-description");
        User user = new User("Jee", "Pa",
                "lama23@gi.com", "200000", "valami",
                "2imgfilename", (byte) 1,(byte) 0,null,
                null);


        if (true) {
            Event newEvent = new Event();
            newEvent.setTitle(title);
            newEvent.setCapacity(capacity);
            newEvent.setDate(datetime);
            newEvent.setDescription(description);
            newEvent.setHost(null);
            eventDao.save(newEvent);
            //response.redirect("/event-created");
        }

        Map params = new HashMap<>();
        List<Event> result = eventDao.getAll();
        params.put("events", result);
        return ViewUtil.render(request, params, "/home/index");
    };

    public Route addedEvent = (Request request, Response response) -> ViewUtil.render(request, new HashMap(),"/event-added");


    public Route findEventById = (Request request, Response response) -> {

        long eventId = Long.parseLong(request.queryParams("eid"));
        Event result = eventDao.findEventById(eventId);
        Map params = new HashMap<>();
        params.put("event", result);

        return ViewUtil.render(request, params, "event");
    };
*/

}
