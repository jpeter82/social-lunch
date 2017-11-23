package com.peanuts.sociallunch.logic;

import com.peanuts.sociallunch.dao.ReviewDao;
import com.peanuts.sociallunch.model.Event;
import com.peanuts.sociallunch.model.Review;
import com.peanuts.sociallunch.model.User;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewController {

    private ReviewDao reviewDao;

    public ReviewController(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    public ModelAndView getAllReview() {

        Map params = new HashMap<>();

        return new ModelAndView(params, "review");
    }

    public ModelAndView writeReview(String usId,String eventId, String rating){
        long time = System.currentTimeMillis();
        java.sql.Timestamp date = new java.sql.Timestamp(time);
        User user = reviewDao.getuser(usId);
//        Event event = reviewDao.getEvent(eventId);
        Review review = new Review();
        int rate = Integer.parseInt(rating);
        review.setGiver(user);
//        review.setEvent(event);
        review.setRating(rate);

        reviewDao.writeReview(review);

        Map params = new HashMap<>();
        return new ModelAndView(params,"address");

    }


}
