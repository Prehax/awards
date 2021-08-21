package com.prehax.award.services;

import com.prehax.award.models.Customer;
import com.prehax.award.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    private Map<Integer, Customer> customers = CustomerRepository.customers;

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    public Customer getCustomerById(int id) { return customers.get(id); }

}
