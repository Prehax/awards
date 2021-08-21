package com.prehax.award.controllers;

import com.prehax.award.models.Transaction;
import com.prehax.award.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@ResponseBody
@RequestMapping(path = "/transaction")
public class TransactionController {

    @Autowired
    TransactionService service;

    // get all transactions
    @GetMapping(path = "/all")
    public List<List<Transaction>> getAllTransactions() {
        return service.getAllTransactions();
    }

    // search by month
    @GetMapping(path = "/getByMonth/{month}")
    public List<Transaction> getTransactionsByMonth(@PathVariable(name = "month") int month) {
        return service.getTransactionsByMonth(month);
    }

    // delete a certain transaction
    @DeleteMapping(path = "/deleteById/{id}")
    public ResponseEntity<String> deleteTransactionById(@PathVariable(name = "id") int id) {
        Transaction t = service.deleteTransactionById(id);
        if (t != null) {
            return ResponseEntity.ok("Delete "+ t + " successful");
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // add a transaction
    @PostMapping(path = "/add")
    public ResponseEntity<String> addTransaction(@RequestBody Transaction transaction) {
        Transaction t = service.addTransaction(transaction, transaction.getId());
        if (t != null) {
            return ResponseEntity.ok("Added "+ t + " successful");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Transaction with id=" + transaction.getId() + " has existed");
        }
    }

    // update a transaction
    @PutMapping(path = "/update")
    public ResponseEntity<String> updateTransaction(@RequestBody Transaction transaction) {
        service.updateTransaction(transaction);
        return ResponseEntity.ok("Updated "+ transaction + " successful");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some error happened, check the parameters");
    }

}
// 1. allow user to add / update transactions --ok
// 2. delete transaction --ok
// 3. search by month --ok
// 4. testing
// 5. Exception handling