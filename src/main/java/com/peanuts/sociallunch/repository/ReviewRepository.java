package com.peanuts.sociallunch.repository;

import com.peanuts.sociallunch.model.Event;
import com.peanuts.sociallunch.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findReviewsByEvent(Event event);


}
