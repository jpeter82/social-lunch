package com.peanuts.sociallunch;
//import spark.template.thymeleaf.ThymeleafTemplateEngine;

import javax.persistence.*;

import static spark.Spark.*;

import com.peanuts.sociallunch.dao.EventDao;
import com.peanuts.sociallunch.logic.AddressController;
import com.peanuts.sociallunch.logic.EventController;
import com.peanuts.sociallunch.model.*;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import static spark.debug.DebugScreen.enableDebugScreen;


public class SocialLunch {

    private EntityManager entityManager;
    private AddressController addressController;
    private EventController eventController;

    public SocialLunch() {
    }

    public SocialLunch(EntityManager entityManager, AddressController addressController,
                       EventController eventController) {
        this.entityManager = entityManager;
        this.addressController = addressController;
        this.eventController = eventController;
    }

    public void start() {

        entityManager.clear();
        this.populateDB();

        // Spark
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(8888);

        get("/", (req, res) -> {
            return new ThymeleafTemplateEngine().render(this.eventController.getAllEvents());
        });

        get("/event", (req, res) -> {
            String eventId = req.queryParams("eid");
            return new ThymeleafTemplateEngine().render(this.eventController.findEventById(eventId));
        });

        get("/address", (req, res) -> {
            return new ThymeleafTemplateEngine().render(this.addressController.getAllAddresses());
        });

        enableDebugScreen();


    }


    public void populateDB () {

        long time = System.currentTimeMillis();
        java.sql.Timestamp date = new java.sql.Timestamp(time);

        String lorem =  "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Vestibulum faucibus sapien sit amet lectus dictum, " +
                        "non convallis sapien blandit.";

        User newUser = new User("Joe", "Smith",
                "lama@gi.com", "00000", "valami",
                "imgfilename", (byte) 1,(byte) 0,null,
                null);

        User newUser2 = new User("Nate", "Hyber",
                "lama1@gi.com", "100000", "valami",
                "1imgfilename", (byte) 1,(byte) 0,null,
                null);

        User newUser3 = new User("Jee", "Pa",
                "lama2@gi.com", "200000", "valami",
                "2imgfilename", (byte) 1,(byte) 0,null,
                null);

        Address newAdress = new Address("HUN", "Csobánka", "Csocsi",
                "utca", "10");
        Address newAdress2 = new Address("HUN", "Bud", "Kiraly",
                "utca", "11");

        Place newPlace = new Place(newAdress, 112);
        Place newPlace2 = new Place(newAdress2, 110);
        Place newPlace3 = new Place(newAdress2, 8);

        Event event1 = new Event(newUser, newPlace, lorem, date, "Let's eat",
                "bb.jpg");
        Event event2 = new Event(newUser2, newPlace, lorem, date, "Happy :)",
                "cake.jpg");
        Event event3 = new Event(newUser2, newPlace, lorem, date, "Cheer",
                "cheer.jpg");
        Event event4 = new Event(newUser, newPlace, lorem, date, "BB party",
                "girls.jpg");
        Event event5 = new Event(newUser, newPlace, lorem, date, "India",
                "india.jpg");
        Event event6 = new Event(newUser2, newPlace, lorem, date, "Awesome pig",
                "pig.jpg");
        Event event7 = new Event(newUser, newPlace, lorem, date, "Roll",
                "roll.jpg");
        Event event8 = new Event(newUser2, newPlace, lorem, date, "Wine tateing",
                "wine.jpg");
        Event event9 = new Event(newUser2, newPlace, lorem, date, "Crazy",
                "barrel.png");

        Reservation reservation = new Reservation(event1, newUser);
        Reservation reservation2 = new Reservation(event2, newUser2);
        
        Review review = new Review(newUser, newUser2, event1, 7);
        Review review2 = new Review(newUser2, newUser, event2, 6);

        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newAdress);
        this.entityManager.persist(newAdress2);
        this.entityManager.persist(newPlace);
        this.entityManager.persist(newPlace2);
        this.entityManager.persist(newPlace3);
        this.entityManager.persist(newUser);
        this.entityManager.persist(newUser2);
        this.entityManager.persist(event1);
        this.entityManager.persist(event2);
        this.entityManager.persist(event3);
        this.entityManager.persist(event4);
        this.entityManager.persist(event5);
        this.entityManager.persist(event6);
        this.entityManager.persist(event7);
        this.entityManager.persist(event8);
        this.entityManager.persist(event9);
        this.entityManager.persist(review);
        this.entityManager.persist(review2);
        this.entityManager.persist(reservation);
        this.entityManager.persist(reservation2);
        transaction.commit();
    }

}
