package com.peanuts.sociallunch.dao;

import com.peanuts.sociallunch.logic.UserController;
import com.peanuts.sociallunch.model.Address;
import com.peanuts.sociallunch.model.Event;
import com.peanuts.sociallunch.model.User;
import com.peanuts.sociallunch.util.EncryptBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class InitializerBean {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public String crypt(String pass) {
        return bCryptPasswordEncoder.encode(pass);
    }

    long time = System.currentTimeMillis();
    Timestamp date = new Timestamp(time);

    String lorem =  "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
            "Vestibulum faucibus sapien sit amet lectus dictum, " +
            "non convallis sapien blandit.";

    public InitializerBean(AddressDao addressDao, EventDao eventDao, UserDao userDao, UserController userController) {

        User newUser = new User(
                "Mark",
                "Hello",
                "valami@gmail.com",
                "00000000",
                "valami",
                "imgfile",
                (byte) 1,
                (byte) 0,
                "mark"
        );

        User newUser2 = new User(
                "Joee",
                "Smith",
                "lama@gi2.com",
                "00000",
                "valami",
                "imgfilename",
                (byte) 1,
                (byte) 0,
                null,
                null,
                "joe");

        User newUser3 = new User(
                "pina",
                "szaft",
                "abcd@efgh.com",
                "66666666666",
                "1234",
                "imgfilename",
                (byte) 1,
                (byte) 0,
                null,
                null,
                "pinaszaft");

        userController.setCryptPass(newUser);
        userController.setCryptPass(newUser2);
        userController.setCryptPass(newUser3);

        userDao.saveUser(newUser);
        userDao.saveUser(newUser2);
        userDao.saveUser(newUser3);

        Address newAdress = new Address("HUN", "Csobánka", "Csocsi",
                "utca", newUser);

        addressDao.saveAddress(newAdress);

        Event event1 = new Event(newUser, newAdress, lorem, date, "Let's eat",
                "bb.jpg");

        eventDao.saveEvent(event1);
    }


}
