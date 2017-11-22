package com.peanuts.sociallunch;
//import spark.template.thymeleaf.ThymeleafTemplateEngine;

import com.peanuts.sociallunch.controller.EventController;
import com.peanuts.sociallunch.controller.HomeController;
import com.peanuts.sociallunch.model.HibernateUtil;
import com.peanuts.sociallunch.model.dao.UserHibernateDao;
import com.peanuts.sociallunch.model.dao.interfaces.UserDao;
import com.peanuts.sociallunch.model.entities.Address;

import com.peanuts.sociallunch.model.entities.Event;
import com.peanuts.sociallunch.model.entities.Place;
import com.peanuts.sociallunch.model.entities.User;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.getInteger;
import static java.lang.Integer.parseInt;
import static spark.Spark.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.debug.DebugScreen.enableDebugScreen;


public class SocialLunch {

    public static void main(String[] args) {

        // Spark
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        //staticFileLocation("/view");
        port(8888);

        get("/", HomeController::showIndex, new ThymeleafTemplateEngine());
        get("/event/eventid/view", EventController::viewEvent, new ThymeleafTemplateEngine());
        get("/event/register", EventController::registerEvent, new ThymeleafTemplateEngine());

        enableDebugScreen();

        // Hibernate
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("socialLunch");
        EntityManager em = emf.createEntityManager();
        populateDb(em);

        // Example query
        List firsts = em.createQuery("FROM Event ").getResultList();
        System.out.println(firsts.toString());

        for (int i = 0; i < firsts.size(); i++) {
         Event event = (Event) firsts.get(i);
        System.out.println(event.getTitle());
        }

        em.close();
        emf.close();*/

        List<User> johns = new ArrayList<>();
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;

        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            UserDao dao = new UserHibernateDao();
            dao.setSession(session);

            transaction = session.beginTransaction();
            johns = dao.findByFirstName("John");
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }

            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }

        for (User user : johns) {
            System.out.println("USER FIRST NAME: " + user.getFirstName());
        }

    }

    public static void populateDb (EntityManager em) {

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
    }
}
