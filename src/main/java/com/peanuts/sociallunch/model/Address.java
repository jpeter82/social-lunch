package com.peanuts.sociallunch.model;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "getAll", query = "SELECT a FROM Address a")
})
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

    @Column(name = "alias")
    private String alias;

    public Address() {
    }

    public Address(String country, String city, String zipCode, String addressLine, String alias) {
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
        this.addressLine = addressLine;
        this.alias = alias;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String type) {
        this.alias = type;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}