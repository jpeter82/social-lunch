package com.peanuts.sociallunch.repository;

import com.peanuts.sociallunch.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findAddressById(int id);


}
