package com.prehax.award.controllers;

import com.prehax.award.models.Customer;
import com.prehax.award.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping(path = "/all")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping(path = "getById/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") int id) {
        return service.getCustomerById(id);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some error happened, check the parameters");
    }

}
