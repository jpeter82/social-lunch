package com.peanuts.sociallunch.logic;

import com.peanuts.sociallunch.dao.AddressDao;

import com.peanuts.sociallunch.dao.EventDao;
import com.peanuts.sociallunch.model.Address;
import com.peanuts.sociallunch.model.Event;
import com.peanuts.sociallunch.model.User;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventController {

    private EventDao eventDao;

    public EventController(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    // Handles one event view, create new event
    public ModelAndView showAddNewForm() {
        //List<Address> result = eventDao.getAll();
        Map params = new HashMap<>();
        //params.put("address", result);

        return new ModelAndView(params,"/new-event");
    }

    public ModelAndView createNewEvent(Request request, Response response) {


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
        return new ModelAndView(params,"/home/index");
    }

    public ModelAndView addedEvent() {
        Map params = new HashMap<>();
        return new ModelAndView(params,"/event-added");
    }

    public ModelAndView getAllEvents() {
        List<Event> result = eventDao.getAll();
        Map params = new HashMap<>();
        params.put("events", result);
        return new ModelAndView(params,"/home/index");
    }


    public ModelAndView findEventById(String eventId) {
        Event result = eventDao.findEventById(eventId);
        Map params = new HashMap<>();
        params.put("event", result);

        return new ModelAndView(params,"event");
    }

}
