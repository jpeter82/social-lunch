package com.peanuts.sociallunch.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Event event;

    @ManyToOne
    private User user;

    @CreationTimestamp
    @Column(name = "created")
    private Timestamp createdDate;

    public Reservation() {
    }

    public Reservation(Event event, User user) {
        this.event = event;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

}
