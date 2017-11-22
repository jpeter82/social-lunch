package com.peanuts.sociallunch.dao;

import com.peanuts.sociallunch.model.Address;

import javax.persistence.EntityManager;
import java.util.List;

public class AddressDao {

    private EntityManager em;

    public AddressDao(EntityManager em) {
        this.em = em;
    }

    public List<Address> getAll() {

        List<Address> addresses = em.createNamedQuery("getAll", Address.class).getResultList();
        return addresses;

    }





}
