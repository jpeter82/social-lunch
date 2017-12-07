package com.peanuts.sociallunch.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "getAllReview",query ="SELECT rev FROM Review rev")
})
@Table(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    //@Column(name = "review_giver", nullable = false)
    private User giver;

    @ManyToOne
//    @Column(name = "review_receiver")
    private User receiver;

    @ManyToOne
    private Event event;

    @Column(name = "rating", nullable = false)
    private int rating;


    @Column(name = "created") // nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date createdDate;

    public Review() {
    }

    public Review(int id) {
        this.id = id;
    }

    public Review(User giver, Event event, int rating) {
        this.giver = giver;
        this.event = event;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getGiver() {
        return giver;
    }

    public void setGiver(User giver) {
        this.giver = giver;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
