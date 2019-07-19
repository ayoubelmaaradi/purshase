package com.med.repository;

import com.med.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    public List<Customer> findByAddressAndEmail(String address, String email);
    public List<Customer>findByIce(String ice);
}
