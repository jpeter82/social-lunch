package com.peanuts.sociallunch.logic;

import com.peanuts.sociallunch.dao.ReviewDao;
import com.peanuts.sociallunch.dao.UserDao;
import com.peanuts.sociallunch.model.Event;
import com.peanuts.sociallunch.model.Review;
import com.peanuts.sociallunch.model.User;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReviewController {

    private ReviewDao reviewDao;
    private UserDao userDao;

    public ReviewController(ReviewDao reviewDao, UserDao userDao) {
        this.reviewDao = reviewDao;
        this.userDao = userDao;
    }

    public ModelAndView getAllReview() {
        Map params = new HashMap<>();
        return new ModelAndView(params, "review");
    }

    public ModelAndView writeReview(long userId, long eventId, int rating) {

        long time = System.currentTimeMillis();
        java.sql.Timestamp date = new java.sql.Timestamp(time);
        User user = userDao.getById(userId);
        Review review = new Review();
        review.setGiver(user);
        review.setRating(rating);

        reviewDao.writeReview(review);

        Map params = new HashMap<>();
        return new ModelAndView(params,"address");

    }

}
