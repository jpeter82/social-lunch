package com.peanuts.sociallunch.logic;

import com.peanuts.sociallunch.dao.EventDao;
import com.peanuts.sociallunch.model.Event;
import com.peanuts.sociallunch.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

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

        Event event = eventDao.findEventById(eventId);
        model.addAttribute("event", event);
        model.addAttribute("joined_usernames", event.getJoinedUsers()
                                                       .stream()
                                                       .map(User::getUsername)
                                                       .collect(Collectors.toList()));

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth.getName() != null && !auth.getName().equals("")) {
            model.addAttribute("username", auth.getName());
        }

        return "event";
    }

}
