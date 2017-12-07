package com.peanuts.sociallunch.logic;

import com.peanuts.sociallunch.dao.AddressDao;
import com.peanuts.sociallunch.dao.UserDao;
import com.peanuts.sociallunch.model.Address;
import com.peanuts.sociallunch.util.ViewUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AddressController {

    private AddressDao addressDao;
    private UserDao userDao;

    public AddressController(AddressDao addressDao, UserDao userDao) {
        this.addressDao = addressDao;
        this.userDao = userDao;
    }

    public void addAddress (Address address) {
        addressDao.saveAddress(address);
    }

    @RequestMapping(value = "/add-new-address", method = RequestMethod.GET)
    public String showNewAddressForm(Model model, HttpSession session) {
        //userhez kötni, ha bug van, azért van
        model.addAttribute("addresses", addressDao.getAll());
        model.addAttribute("pina", new Address());
        return "new-address";
    }

    @RequestMapping(value = "/add-new-address", method = RequestMethod.POST)
    public String addEventForm(@ModelAttribute Address address, HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        address.setOwner(userDao.findByUsername(username));

        addAddress(address);
        return "redirect:/addevent";
    }

    /*public Route getAllAddresses = (Request request, Response response) -> {
        List<Address> result = addressDao.getAll();
        Map params = new HashMap<>();
        params.put("address", result);
        return ViewUtil.render(request, params, "/address");
    };*/

}
