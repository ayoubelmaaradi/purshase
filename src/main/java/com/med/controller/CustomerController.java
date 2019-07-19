package com.med.controller;

import com.med.model.Customer;
import com.med.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api-purshase")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/customer")
    public Customer postCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/customer/edit/{id}")
    public Customer getOneCustomer(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.get() != null) {
            return customer.get();
        }
        return null;
    }

    @PostMapping("/customer/update/{id}")
    public Customer updateCustomer(@PathVariable("id") Long id, Customer customer) {
        Optional<Customer> customerLoaded = customerRepository.findById(id);
        if (customerLoaded != null) {
            return customerRepository.save(customer);
        }

        return null;
    }

    @DeleteMapping("/customer/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer != null) {
            customerRepository.delete(customer.get());
            return new ResponseEntity<Customer>(HttpStatus.OK);
        }
        return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) { this.customerRepository =customerRepository;}






}