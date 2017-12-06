package com.peanuts.sociallunch.logic;

import com.peanuts.sociallunch.model.User;
import com.peanuts.sociallunch.repository.UserRepository;
//import com.peanuts.sociallunch.util.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String addUser(User user) {
        userRepository.save(user);
        return "/";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addUserForm(@ModelAttribute User user) {
        user.encryptPassword();
        addUser(user);
        return "redirect:/";
    }

}