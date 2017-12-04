package com.peanuts.sociallunch;

import com.peanuts.sociallunch.dao.*;
import com.peanuts.sociallunch.logic.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DIContainer {

    public void init() {
      
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("socialLunch");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //AddressDao addressDao = new AddressDao(entityManager);
        //ReviewDao reviewDao= new ReviewDao(entityManager);
        //UserDao userDao = new UserDao(entityManager);
        //EventDao eventDao = new EventDao(entityManager);

        //AddressController addressController = new AddressController(addressDao);
        //EventController eventController = new EventController(eventDao, userDao);
        //ReviewController reviewController = new ReviewController(reviewDao, userDao);

        /*SocialLunch socialLunch = new SocialLunch(entityManager, addressController,
                eventController, reviewController);*/
      
        //return socialLunch;
    }

}
