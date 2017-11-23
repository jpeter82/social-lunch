package com.peanuts.sociallunch.logic;

import com.peanuts.sociallunch.dao.AddressDao;
import com.peanuts.sociallunch.model.Address;
import com.peanuts.sociallunch.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressController {

    private AddressDao addressDao;

    public AddressController(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public Route getAllAddresses = (Request request, Response response) -> {
        List<Address> result = addressDao.getAll();
        Map params = new HashMap<>();
        params.put("address", result);
        return ViewUtil.render(request, params, "/address");
    };

}
