package com.peanuts.sociallunch;
//import spark.template.thymeleaf.ThymeleafTemplateEngine;

import javax.persistence.*;

import static spark.Spark.*;

import com.peanuts.sociallunch.dao.EventDao;
import com.peanuts.sociallunch.logic.AddressController;
import com.peanuts.sociallunch.logic.EventController;
import com.peanuts.sociallunch.model.Address;
import com.peanuts.sociallunch.model.Event;
import com.peanuts.sociallunch.model.Place;
import com.peanuts.sociallunch.model.User;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

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
        //staticFileLocation("/view");
        port(8888);

        get("/", (req, res) -> {
            return new ThymeleafTemplateEngine().render(this.eventController.getAllEvents());
        });

        get("/address", (req, res) -> {
            return new ThymeleafTemplateEngine().render(this.addressController.getAllAddresses());
        });

        enableDebugScreen();


    }


    public void populateDB () {




        User newUser = new User("John", "Doe", "john@doe.com", "+3615425425", "mfwkmfkem","",(byte) 1,(byte) 0,null,null);
        Address newAdress = new Address("Hungary", "Budapest", "1111", "Csocsi u. 10. 1/5", "Home");
        Place newPlace = new Place(newAdress, 112);

        long time = System.currentTimeMillis();
        java.sql.Timestamp date = new java.sql.Timestamp(time);


        //Timestamp date = new Timestamp();
        //String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        Event newEvent = new Event(newUser, newPlace,"cool", date, "Első buli");
        Event eventTwo = new Event(newUser, newPlace,"cool2", date, "Első buli2");

        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newAdress);
        this.entityManager.persist(newPlace);
        this.entityManager.persist(newUser);
        this.entityManager.persist(newEvent);
        this.entityManager.persist(eventTwo);
        transaction.commit();
        System.out.println("Commit done");
    }

}
