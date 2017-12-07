package com.peanuts.sociallunch.dao;

import com.peanuts.sociallunch.model.Address;
import com.peanuts.sociallunch.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class AddressDao {

    @Autowired
    private AddressRepository addressRepository;

    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public  Address findById(int id) {
        return addressRepository.findAddressById(id);
    }





}
