package com.peanuts.sociallunch;


import javax.persistence.*;
import com.peanuts.sociallunch.dao.*;
import com.peanuts.sociallunch.logic.*;
import com.peanuts.sociallunch.model.*;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;


public class SocialLunch {

    private EntityManager entityManager;
    private AddressController addressController;
    private ReviewController reviewController;
    private EventController eventController;

    public SocialLunch() {
    }

    public SocialLunch(EntityManager entityManager, AddressController addressController,
                       EventController eventController, ReviewController reviewController) {

        this.entityManager = entityManager;
        this.addressController = addressController;
        this.eventController = eventController;
        this.reviewController = reviewController;

    }

    public void start() {

        entityManager.clear();
        this.populateDB();

        // Spark
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(8888);


        get(Path.INDEX, this.eventController.getAllEvents);
        get(Path.EVENT, this.eventController.findEventById);
        get(Path.ADDRESS, this.addressController.getAllAddresses);
        get(Path.REVIEW, this.reviewController.getAllReview);
        post(Path.REVIEW2, this.reviewController.writeReview);
        get(Path.ADD_EVENT, this.eventController.showAddNewForm);
        post(Path.ADD_EVENT, this.eventController.createNewEvent);
        get(Path.EVENT_CREATED, this.eventController.addedEvent);

        enableDebugScreen();

    }

    public void populateDB() {

        long time = System.currentTimeMillis();
        Timestamp date = new Timestamp(time);

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

        Event event1 = new Event(newUser, newAdress2, lorem, date, "Let's eat",
                "bb.jpg");
        Event event2 = new Event(newUser2, newAdress2, lorem, date, "Happy :)",
                "cake.jpg");
        Event event3 = new Event(newUser2, newAdress2, lorem, date, "Cheer",
                "cheer.jpg");
        Event event4 = new Event(newUser, newAdress2, lorem, date, "BB party",
                "girls.jpg");
        Event event5 = new Event(newUser, newAdress2, lorem, date, "India",
                "india.jpg");
        Event event6 = new Event(newUser2, newAdress2, lorem, date, "Awesome pig",
                "pig.jpg");
        Event event7 = new Event(newUser, newAdress2, lorem, date, "Roll",
                "roll.jpg");
        Event event8 = new Event(newUser2, newAdress2, lorem, date, "Wine tateing",
                "wine.jpg");
        Event event9 = new Event(newUser2, newAdress2, lorem, date, "Crazy",
                "barrel.png");

        Reservation reservation = new Reservation(event1, newUser);
        Reservation reservation2 = new Reservation(event2, newUser2);
        
        Review review = new Review(newUser, newUser2, event1, 7);
        Review review2 = new Review(newUser2, newUser, event2, 6);

        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newAdress);
        this.entityManager.persist(newAdress2);
        this.entityManager.persist(newAdress2);
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
