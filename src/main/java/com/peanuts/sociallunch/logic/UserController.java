package com.peanuts.sociallunch.logic;

import com.peanuts.sociallunch.model.User;
import com.peanuts.sociallunch.repository.UserRepository;
//import com.peanuts.sociallunch.util.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    public void setCryptPass(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addUserForm(@ModelAttribute User user) {
        setCryptPass(user);
        userRepository.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model,
                        @RequestParam(value = "logout", required = false) String logout) {
        //String name = principal.getName();
        //model.addAttribute("username", name);
        if (logout != null) {
            System.out.println("logout done");
            model.addAttribute("message", "Logged out from JournalDEV successfully.");
        }


        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session) {
        session.invalidate();
        System.out.println("logout done");
        model.addAttribute("message", "Logged out, see You soon.");

        return "login";
    }

}