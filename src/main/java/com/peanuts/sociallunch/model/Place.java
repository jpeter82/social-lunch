package com.peanuts.sociallunch.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Address address;

    int capacity;

    @CreationTimestamp
    @Column(name = "created")
    private Timestamp createdDate;

    public Place() {
    }

    public Place(Address address, int capacity) {
        this.address = address;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }
}
