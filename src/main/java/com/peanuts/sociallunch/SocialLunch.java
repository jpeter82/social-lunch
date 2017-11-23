package com.peanuts.sociallunch;
//import spark.template.thymeleaf.ThymeleafTemplateEngine;

import javax.persistence.*;

import static spark.Spark.*;

import com.peanuts.sociallunch.logic.AddressController;
import com.peanuts.sociallunch.logic.ReviewController;
import com.peanuts.sociallunch.model.Address;
import com.peanuts.sociallunch.model.User;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.debug.DebugScreen.enableDebugScreen;


public class SocialLunch {

    private EntityManager entityManager;
    private AddressController addressController;
    private ReviewController reviewController;

    public SocialLunch() {
    }

    public SocialLunch(EntityManager entityManager, AddressController addressController, ReviewController reviewController) {
        this.entityManager = entityManager;
        this.addressController = addressController;
        this.reviewController = reviewController;
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
        get("/review", (req, res) -> {
            return new ThymeleafTemplateEngine().render(this.reviewController.getAllReview());
        });
        post("/review2", (req, res) -> {
//
//           String user =  req.queryParams("user");
//           String event =  req.queryParams("event");
            String user = "1";
            String event = "1";
           String rating =  req.queryParams("rating");

            return new ThymeleafTemplateEngine().render(this.reviewController.writeReview(user,event,rating));
        });


        enableDebugScreen();


    }


    public void populateDB() {

        User newUser = new User("John", "Doe", "john@doe.com", "+3615425425", "mfwkmfkem","",(byte) 1,(byte) 0,null,null);
        Address newAdress = new Address("Hungary", "Budapest", "1111", "Csocsi u. 10. 1/5", "Home");
        /*Place newPlace = new Place(newAdress, 112);
        Timestamp date = new Timestamp(52534L);
        Event newEvent = new Event(newUser, newPlace,"cool", date, "Első buli");
        Event eventTwo = new Event(newUser, newPlace,"cool2", date, "Első buli2");*/

        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newAdress);
        this.entityManager.persist(newUser);
        /*entityManager.persist(newPlace);
        entityManager.persist(newUser);
        entityManager.persist(newEvent);
        entityManager.persist(eventTwo);*/
        transaction.commit();
        System.out.println("Commit done");
    }

}
