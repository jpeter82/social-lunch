package com.peanuts.sociallunch.logic;

import com.peanuts.sociallunch.dao.UserDao;
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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void setCryptPass(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    }

    private UserDao userDao;


    public UserController(UserDao userDao){
        this.userDao = userDao;

    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public String addUser(User user) {
        userDao.saveUser(user);
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model,
                        @RequestParam(value = "logout", required = false) String logout) {
        if (logout != null) {
            model.addAttribute("message", "Logged out, see You soon.");
        }
        return "login";
    }
}