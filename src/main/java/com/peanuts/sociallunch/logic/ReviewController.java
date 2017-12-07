package com.peanuts.sociallunch.logic;

import com.peanuts.sociallunch.dao.ReviewDao;
import com.peanuts.sociallunch.dao.UserDao;
import com.peanuts.sociallunch.model.Event;
import com.peanuts.sociallunch.model.Review;
import com.peanuts.sociallunch.model.User;
import com.peanuts.sociallunch.util.ViewUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReviewController {

    @Autowired
    ReviewDao reviewDao;



    /*public Route getAllReview = (Request request, Response response) -> ViewUtil.render(request, new HashMap(),"review");

    public Route writeReview = (Request request, Response response) -> {

        long userId = 1L;
        long event = 1L;
        int rating = Integer.parseInt(request.queryParams("rating"));
        long time = System.currentTimeMillis();
        java.sql.Timestamp date = new java.sql.Timestamp(time);
        User user = userDao.getById(userId);
        Review review = new Review();
        review.setGiver(user);
        review.setRating(rating);

        reviewDao.writeReview(review);

        Map params = new HashMap<>();
        return ViewUtil.render(request, params,"address");
    };
*/
}
