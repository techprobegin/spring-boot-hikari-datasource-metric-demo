package com.techprobegin.hikari.repository;

import com.techprobegin.hikari.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	Optional<Customer> findByCustomerId(int customerId);

}
