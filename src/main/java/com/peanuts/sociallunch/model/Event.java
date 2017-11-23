package com.peanuts.sociallunch.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
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

    @Column(name = "capacity")
    private Integer capacity;

    @ManyToOne
    // Address here @ManyToOne
    private Address address;

    @Column(name = "description")
    private String description;

    @ManyToMany
    private List<Tag> tagList;

    @OneToMany(mappedBy = "event")
    private List<Review> reviewList;

    @Column(name = "date")
    private Date date;

    @CreationTimestamp
    @Column(name = "created")
    private Timestamp createdDate;


    public Event() {
    }

    public Event(User host, Address address, String description,  Date date, String title) {
        this.host = host;
        this.address = address;
        this.description = description;
        this.date = date;
        this.title = title;
    }

    public Event(String title, User host, Integer capacity, Address address, String description, Date date, Timestamp createdDate) {
        this.title = title;
        this.host = host;
        this.capacity = capacity;
        this.address = address;
        this.description = description;
        this.date = date;
        this.createdDate = createdDate;
    }

    public long getId() {
        return id;
    }

    public User getHost() {
        return host;
    }

    public Address getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public List<Tag> getTag() {
        return tagList;
    }

    public Date getDate() {
        return date;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTag(List<Tag> tag) {
        this.tagList = tag;
    }

    public void setDate(Date date) {
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

}

