package com.peanuts.sociallunch.logic;

import com.peanuts.sociallunch.dao.ReviewDao;
import com.peanuts.sociallunch.dao.UserDao;


public class ReviewController {

    private ReviewDao reviewDao;
    private UserDao userDao;

    public ReviewController(ReviewDao reviewDao, UserDao userDao) {
        this.reviewDao = reviewDao;
        this.userDao = userDao;
    }

}
