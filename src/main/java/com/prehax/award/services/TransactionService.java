package com.prehax.award.services;


import com.prehax.award.repositories.CustomerRepository;
import com.prehax.award.models.Customer;
import com.prehax.award.models.Transaction;
import com.prehax.award.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class TransactionService {
    
    List<List<Transaction>> transactions = TransactionRepository.transactions;
    Set<Integer> transIds;
    Map<Integer, Customer> customers = CustomerRepository.customers;

    TransactionService() {
        transIds = new HashSet<>();
        for (List<Transaction> transaction : transactions) {
            transaction.forEach((t) -> transIds.add(t.getId()));
        }
    }

    public List<List<Transaction>> getAllTransactions() {
        return transactions;
    }

    public List<Transaction> getTransactionsByMonth(int month) {
        return transactions.get(month);
    }
    
    public Transaction deleteTransactionById(int id) {
        boolean finish = false;
        Transaction t = null;
        // if this transaction doesn't exist
        if (!transIds.contains(id)) { return null; }

        // find the transaction and delete
        for(int i=0; i<12; i++) {
            for (int j = 0; j < transactions.get(i).size(); j++) {
                if (transactions.get(i).get(j).getId() == id) {
                    // minus the award from customer
                    int cusId = transactions.get(i).get(j).getCustomerId();
                    customers.get(cusId).setAwardPoints(
                            customers.get(cusId).getAwardPoints() -
                                    transactions.get(i).get(j).getAward()
                    );

                    // remove this transaction
                    t = transactions.get(i).remove(j);

                    // also remove the id in set
                    transIds.remove(id);
                    finish = true;
                    break;
                }
            }
            if (finish) { break; }
        }

        return t;
    }

    public Transaction addTransaction(Transaction transaction, int id) {
        int month = transaction.getMonth();

        // if exist, do not add
        if (transIds.contains(id)) { return null; }

        // add id into the set and add it into the month where it should be
        transIds.add(id);
        transactions.get(month).add(transaction);

        int cusId = transaction.getCustomerId();
        // add one new customer or add the awardPoints
        if (!customers.containsKey(cusId)) {
            customers.put(cusId, new Customer(cusId, "DummyName"+cusId, transaction.getAward()));
        } else {
            int originAwardPoints = customers.get(cusId).getAwardPoints();
            customers.get(cusId).setAwardPoints(originAwardPoints + transaction.getAward());
        }
        return transaction;
    }

    public void updateTransaction(Transaction transaction) {
        int month = transaction.getMonth();
        int id = transaction.getId();
        if (transIds.contains(id)) {
            List<Transaction> monthTrans = transactions.get(month);
            for (int i = 0; i < monthTrans.size(); i++) {
                if (monthTrans.get(i).getId() == id) {
                    // deal with customer's record
                    int originalPoints = monthTrans.get(i).getAward();
                    int difference = transaction.getAward() - originalPoints;
                    int cusId = monthTrans.get(i).getCustomerId();
                    customers.get(cusId).setAwardPoints(
                            customers.get(cusId).getAwardPoints() + difference
                    );

                    // settle down the new transaction
                    monthTrans.set(i, transaction);
                }
            }
        } else {
            addTransaction(transaction, id);
        }
    }
}
