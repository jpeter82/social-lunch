package com.peanuts.sociallunch.logic;

import com.peanuts.sociallunch.dao.EventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    EventDao eventDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex(Model model) {
        model.addAttribute("events", eventDao.getAll());
        return "home/index";
    }



}
