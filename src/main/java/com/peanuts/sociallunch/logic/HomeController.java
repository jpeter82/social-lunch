package com.peanuts.sociallunch.logic;

import com.peanuts.sociallunch.dao.EventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    EventDao eventDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex(Model model) {
        model.addAttribute("events", eventDao.getAll());
        return "home/index";
    }

    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public String showEvent(
            Model model,
            @RequestParam(value = "eid", required = true) String eventId
            ) {
        model.addAttribute("event", eventDao.findEventById(eventId));
        return "event";
    }



}