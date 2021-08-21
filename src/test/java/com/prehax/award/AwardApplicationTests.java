package com.prehax.award;

import com.prehax.award.models.Transaction;
import com.prehax.award.repositories.TransactionRepository;
import com.prehax.award.services.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AwardApplicationTests {

    @Autowired
    TransactionService service;
    RestTemplate restTemplate = new RestTemplate();
    @Test
    public void testGetAllTransactions() {
        List<List<Transaction>> ac = restTemplate.getForObject("http://localhost:8080/transaction/all", ArrayList.class);
        List<List<Transaction>> bc = TransactionRepository.transactions;
        assert ac != null;
        Assertions.assertEquals(ac.toString(), bc.toString());
    }

    @Test
    public void testGetTransactionsByMonth() {
        int[] testMonths = {0,1,4,6,10,11};

        for(int month: testMonths) {
            Assertions.assertEquals(TransactionRepository.transactions.get(month).toString(),
                    Objects.requireNonNull(
                            restTemplate.getForObject("http://localhost:8080/transaction/getByMonth/" + month, ArrayList.class)
                    ).toString());
        }

    }

}
