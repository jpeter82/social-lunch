package com.peanuts.sociallunch.dao;

import com.peanuts.sociallunch.model.Event;
import com.peanuts.sociallunch.model.Review;
import com.peanuts.sociallunch.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ReviewDao {

    private EntityManager em;

    public ReviewDao(EntityManager em) {
        this.em = em;
    }

    public  void  writeReview(Review review) {
        EntityTransaction transaction = this.em.getTransaction();
        Review review1  = review;
        transaction.begin();
        em.persist(review1);
        transaction.commit();


    }

    public User getuser(String usId){
        Long userId = Long.parseLong(usId);

        User user =  em.createNamedQuery("reviewgiver",User.class).setParameter("id",userId).getSingleResult();
        return user;

    }

    public Event getEvent(String eventId){
        Query query= em.createNamedQuery("reviewEvent", Review.class).setParameter("id",eventId);
        Event event= (Event) query.getSingleResult();
        return event;
    }

}
