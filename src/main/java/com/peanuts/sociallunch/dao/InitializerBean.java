package com.peanuts.sociallunch.dao;

import com.peanuts.sociallunch.model.Address;
import com.peanuts.sociallunch.model.Event;
import com.peanuts.sociallunch.model.User;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class InitializerBean {

    long time = System.currentTimeMillis();
    Timestamp date = new Timestamp(time);

    String lorem =  "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
            "Vestibulum faucibus sapien sit amet lectus dictum, " +
            "non convallis sapien blandit.";

    public InitializerBean(AddressDao addressDao, EventDao eventDao, UserDao userDao) {

        User newUser = new User("Joe", "Smith", "notlamejohnsmith",
                "lama@gi.com", "00000", "valami",
                "imgfilename", (byte) 1,(byte) 0,null,
                null);

        userDao.saveUser(newUser);

        Address newAdress = new Address("HUN", "Csobánka", "Csocsi",
                "utca", "10");

        addressDao.saveAddress(newAdress);

        Event event1 = new Event(newUser, newAdress, lorem, date, "Let's eat",
                "bb.jpg");

        eventDao.saveEvent(event1);
    }


}
