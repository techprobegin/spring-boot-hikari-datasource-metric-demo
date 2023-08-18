/**
 *
 */
package com.techprobegin.hikari.controller;

import com.techprobegin.hikari.entity.Customer;
import com.techprobegin.hikari.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tech Pro Begin
 */

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customer-details/{id}")
    public Customer getAccountDetails(@PathVariable int id) {
        log.info("Entered into getAccountDetails() method");
        Customer customer = customerRepository.findByCustomerId(id).
                orElseThrow(() -> new RuntimeException("Customer not found for id:" + id));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Customer details has been fetched for id:{}",id);
        return customer;
    }

    @PostMapping("/create-customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer cust) {
        Customer customer = customerRepository.save(cust);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

}
