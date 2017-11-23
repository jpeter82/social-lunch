package com.peanuts.sociallunch;
//import spark.template.thymeleaf.ThymeleafTemplateEngine;

import javax.persistence.*;

import static spark.Spark.*;

import com.peanuts.sociallunch.logic.AddressController;
import com.peanuts.sociallunch.logic.EventController;
import com.peanuts.sociallunch.model.Address;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.debug.DebugScreen.enableDebugScreen;


public class SocialLunch {

    private EntityManager entityManager;
    private AddressController addressController;
    private EventController eventController;

    public SocialLunch() {
    }

    public SocialLunch(EntityManager entityManager, AddressController addressController, EventController eventController) {
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
            return "Hello World!";
        });

        get("/address", (req, res) -> {
            return new ThymeleafTemplateEngine().render(this.addressController.getAllAddresses());
        });

        get("/add-event", (req, res) -> {
            return new ThymeleafTemplateEngine().render(this.eventController.showAddNewForm());
        });

        post("/add-event", (request, response) -> {
            return new ThymeleafTemplateEngine().render(this.eventController.createNewEvent(request, response));
        });

        get("/event-created", (request, response) -> {
            return new ThymeleafTemplateEngine().render(this.eventController.addedEvent());
        });

        enableDebugScreen();

    }


    public void populateDB () {

        //User newUser = new User("John", "Doe", "john@doe.com", "+3615425425", "mfwkmfkem","",(byte) 1,(byte) 0,null,null);
        Address newAdress = new Address("Hungary", "Budapest", "1111", "Csocsi u. 10. 1/5", "Home");
        /*Timestamp date = new Timestamp(52534L);
        Event newEvent = new Event(newUser, newAddress,"cool", date, "Első buli");
        Event eventTwo = new Event(newUser, newAddress,"cool2", date, "Első buli2");*/

        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newAdress);
        /*entityManager.persist(newPlace);
        entityManager.persist(newUser);
        entityManager.persist(newEvent);
        entityManager.persist(eventTwo);*/
        transaction.commit();
        System.out.println("Commit done");
    }

}
