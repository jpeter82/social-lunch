package com.peanuts.sociallunch.logic;

import com.peanuts.sociallunch.dao.AddressDao;
import com.peanuts.sociallunch.dao.EventDao;
import com.peanuts.sociallunch.model.Address;
import com.peanuts.sociallunch.model.Event;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventController {

    // Handles one event view, create new event


    private EventDao eventDao;

    public EventController(EventDao evetDao) {
        this.eventDao = evetDao;
    }

    public ModelAndView getAllEvents() {
        List<Event> result = eventDao.getAll();
        Map params = new HashMap<>();
        params.put("events", result);
        return new ModelAndView(params,"/home/index");
    }


    public ModelAndView findEventById(String eventId) {
        List<Event> result = eventDao.findEventById(eventId);
        Map params = new HashMap<>();
        params.put("events", result);

        return new ModelAndView(params,"/home/index");
    }

}
