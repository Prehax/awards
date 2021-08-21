package com.prehax.award.repositories;

import com.prehax.award.models.Customer;
import com.prehax.award.models.Transaction;
import com.prehax.award.repositories.TransactionRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CustomerRepository {

    public static final Map<Integer, Customer> customers = new HashMap<>();
    static {
        // dummy data for customer, id = [0, 40), name is random
        for(int i=0; i<40; i++) {
            customers.put(i, new Customer(i, "DummyName"+i,0));
        }
        List<List<Transaction>> allTransactions = TransactionRepository.transactions;
        for(int i=0; i<12; i++) {
            for(int j=0; j < allTransactions.get(i).size(); j++){
                Transaction transaction = allTransactions.get(i).get(j);
                Customer customer = customers.get(transaction.getCustomerId());
                customer.setAwardPoints(customer.getAwardPoints() + transaction.getAward());
            }
        }
    }
}
