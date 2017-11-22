package com.peanuts.sociallunch;
//import spark.template.thymeleaf.ThymeleafTemplateEngine;

import javax.persistence.*;

import static spark.Spark.*;

import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.debug.DebugScreen.enableDebugScreen;


public class SocialLunch {

    public static void main(String[] args) {

        // Spark
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        //staticFileLocation("/view");
        port(8888);

        get("/", (req, res) -> {
            return "Hello World!";
        });

        enableDebugScreen();


    }

    /*public static void populateDb (EntityManager em) {

        User newUser = new User("John", "Doe", "john@doe.com", "+3615425425", "mfwkmfkem","",(byte) 1,(byte) 0,null,null);
        Address newAdress = new Address("Hungary", "Budapest", "1111", "Csocsi u. 10. 1/5", "Home");
        Place newPlace = new Place(newAdress, 112);
        Timestamp date = new Timestamp(52534L);
        Event newEvent = new Event(newUser, newPlace,"cool", date, "Első buli");
        Event eventTwo = new Event(newUser, newPlace,"cool2", date, "Első buli2");

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(newAdress);
        em.persist(newPlace);
        em.persist(newUser);
        em.persist(newEvent);
        em.persist(eventTwo);
        transaction.commit();
        System.out.println("Commit done");
    }*/
}
