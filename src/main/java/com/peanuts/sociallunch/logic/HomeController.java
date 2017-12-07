package com.peanuts.sociallunch.logic;

import com.peanuts.sociallunch.dao.EventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    EventDao eventDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex(Model model) {
        model.addAttribute("events", eventDao.getAll());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getName() != "anonymousUser") {
            model.addAttribute("username", auth.getName());
        }
        return "home/index";
    }

    @RequestMapping(value = "/event", method = RequestMethod.GET)

    public String showEvent(Model model,
                            @RequestParam(value = "eid", required = true) String eventId,
                            HttpSession session) {

        System.out.println("Session ID: " + session.getId());
        String name = principal.getName();
        System.out.println("Ez a user neve: " + name);
        model.addAttribute("event", eventDao.findEventById(eventId));
        return "event";
    }

}
