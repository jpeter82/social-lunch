package com.peanuts.sociallunch.dao;

import com.peanuts.sociallunch.model.Event;
import com.peanuts.sociallunch.model.Review;
import com.peanuts.sociallunch.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ReviewDao {

    private EntityManager entityManager;

    public ReviewDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public  void  writeReview(Review review) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        Review review1  = review;
        transaction.begin();
        entityManager.persist(review1);
        transaction.commit();
    }

    public Event getEvent(long eventId){
        Query query= entityManager.createNamedQuery("reviewEvent", Review.class).setParameter("id", eventId);
        Event event= (Event) query.getSingleResult();
        return event;
    }

}
