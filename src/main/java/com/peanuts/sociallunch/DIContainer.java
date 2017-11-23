package com.peanuts.sociallunch;

import com.peanuts.sociallunch.dao.*;
import com.peanuts.sociallunch.logic.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DIContainer {

    public SocialLunch init() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("socialLunch");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        AddressDao addressDao = new AddressDao(entityManager);
        AddressController addressController = new AddressController(addressDao);

        EventDao eventDao = new EventDao(entityManager);
        EventController eventController = new EventController(eventDao);

        SocialLunch socialLunch = new SocialLunch(entityManager, addressController, eventController);

        return socialLunch;
    }

}
