package com.peanuts.sociallunch.model;

import javax.persistence.*;

@Entity
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "zip")
    private String zipCode;

    @Column(name = "address_line")
    private String addressLine;

    @ManyToOne
    private User owner;

    public Address() {
    }

    public Address(String country, String city, String zipCode, String addressLine, User owner) {
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
        this.addressLine = addressLine;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String name) {
        this.addressLine = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}