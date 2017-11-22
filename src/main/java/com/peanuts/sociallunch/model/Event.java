package com.peanuts.sociallunch.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    private User host;

    @ManyToOne
    private Place place;

    @Column(name = "description")
    private String description;

    @ManyToMany
    private List<Tag> tagList;

    @OneToMany(mappedBy = "event")
    private List<Review> reviewList;

    @Column(name = "date")
    private Timestamp date;

    @CreationTimestamp
    @Column(name = "created")
    private Timestamp createdDate;


    public Event() {
    }

    public Event(User host, Place place, String description,  Timestamp date, String name) {
        this.host = host;
        this.place = place;
        this.description = description;
        this.date = date;
        this.title = name;
    }

    public long getId() {
        return id;
    }

    public User getHost() {
        return host;
    }

    public Place getPlace() {
        return place;
    }

    public String getDescription() {
        return description;
    }

    public List<Tag> getTag() {
        return tagList;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTag(List<Tag> tag) {
        this.tagList = tag;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public List<Review> getReviewListList() {
        return reviewList;
    }

    public void setReviewListList(List<Review> reviewListList) {
        this.reviewList = reviewListList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

}

