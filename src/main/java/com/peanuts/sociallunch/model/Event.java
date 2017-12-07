package com.peanuts.sociallunch.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "getAllEvents", query = "FROM Event"),
        @NamedQuery(name = "findEventById" , query ="FROM Event WHERE id=:id" )
})
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
    private Address address;
    @Column(name = "description")
    private String description;
    @ManyToMany
    private List<Tag> tagList;
    @OneToMany(mappedBy = "event")
    private List<Review> reviewList;
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @CreationTimestamp
    @Column(name = "created")
    private Timestamp createdDate;
    @Column(name = "picture")
    private String picture;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "event_user",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> joinedUsers;

    public Event() {
        this.joinedUsers = new HashSet<>();
    }

    public Event(String title, User host, Integer capacity, Address address, String description, Date date) {
        this.title = title;
        this.host = host;
        this.capacity = capacity;
        this.address = address;
        this.description = description;
        this.date = date;
    }

    public Event(String title, Integer capacity, Address address, String description) {
        this.title = title;
        this.capacity = capacity;
        this.address = address;
        this.description = description;
        this.joinedUsers = new HashSet<>();
    }

    public Event(User host, Address address, String description, Date date, String title, String picture) {
        this.host = host;
        this.address = address;
        this.description = description;
        this.date = date;
        this.picture = picture;
        this.title = title;
        this.joinedUsers = new HashSet<>();
    }

    public Event(String title, User host, Integer capacity, Address address, 
                 String description, Date date, Timestamp createdDate) {
        this.title = title;
        this.host = host;
        this.capacity = capacity;
        this.address = address;
        this.description = description;
        this.date = date;
        this.createdDate = createdDate;
        this.joinedUsers = new HashSet<>();
    }

    public Event(String title, User host, Integer capacity, Address address, String description, List<Tag> tagList, List<Review> reviewList, Date date, Timestamp createdDate, String picture, Set<User> joinedUsers) {
        this.title = title;
        this.host = host;
        this.capacity = capacity;
        this.address = address;
        this.description = description;
        this.tagList = tagList;
        this.reviewList = reviewList;
        this.date = date;
        this.createdDate = createdDate;
        this.picture = picture;
        this.joinedUsers = joinedUsers;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Set<User> getJoinedUsers() {
        return joinedUsers;
    }

    public void setJoinedUsers(Set<User> joinedUsers) {
        this.joinedUsers = joinedUsers;
    }

}
