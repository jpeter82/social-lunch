package com.peanuts.sociallunch.dao;

import com.peanuts.sociallunch.logic.UserController;
import com.peanuts.sociallunch.model.Address;
import com.peanuts.sociallunch.model.Event;
import com.peanuts.sociallunch.model.User;
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

    String markBday1 = "Absztinens, szíriuszi nyersvegán mulatság, keresztyén dalokkal, rózsafüzér-olvasással, és klarisszás apácák zsoltáraival fűszerezett istentisztelettel egybekötve.";
    String markBday2 = "Alkoholgőzös világi tivornya, anyagyalázó death metallal, misztériumjátékokkal, sátánidézéssel és Antikrisztusvárással egybekötve.";

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
                "Boaty",
                "McBoatface",
                "nemvagyokrobot@gmail.com",
                "66666666666",
                "OrbánViktor=Jézus",
                "imgfilename",
                (byte) 1,
                (byte) 0,
                null,
                null,
                "bigblakbuty");

        userController.setCryptPass(newUser);
        userController.setCryptPass(newUser2);
        userController.setCryptPass(newUser3);

        userDao.saveUser(newUser);
        userDao.saveUser(newUser2);
        userDao.saveUser(newUser3);

        Address newAdress = new Address("HUN", "Csobánka", "Csocsi",
                "utca", newUser);

        Address newAdress2 = new Address("HUN", "Tormafölde", "6666",
                "Petőfi utca 666.", newUser3);

        addressDao.saveAddress(newAdress);
        addressDao.saveAddress(newAdress2);

        Event event1 = new Event(newUser, newAdress, lorem, date, "Let's eat",
                "bb.jpg");
        Event event2 = new Event(newUser3, newAdress2, markBday1, date, "Márk szülinap",
                "bb.jpg");
        Event event3 = new Event(newUser2, newAdress2, markBday2, date, "Márk szülinap",
                "bb.jpg");

        eventDao.saveEvent(event1);
        eventDao.saveEvent(event2);
        eventDao.saveEvent(event3);
    }


}
