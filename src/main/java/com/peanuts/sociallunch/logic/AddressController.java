package com.peanuts.sociallunch.logic;

import com.peanuts.sociallunch.dao.AddressDao;
import com.peanuts.sociallunch.model.Address;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressController {

    private AddressDao addressDao;

    public AddressController(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public ModelAndView getAllAddresses() {
        List<Address> result = addressDao.getAll();
        Map params = new HashMap<>();
        params.put("address", result);

        return new ModelAndView(params,"/address");
    }

}
