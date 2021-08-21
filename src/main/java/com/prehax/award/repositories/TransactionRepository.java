package com.prehax.award.repositories;

import com.prehax.award.models.Transaction;
import org.springframework.stereotype.Repository;

import java.util.*;

// This is a dummy data source to simulate the database
@Repository
public class TransactionRepository {

    // length 90, initial dummy transaction amounts, random number [10, 200)
    private static final int[] amounts = {
            20, 26, 145, 69, 125, 116, 148, 116, 58, 77, 177, 60, 103, 154, 60,
            197, 131, 74, 198, 141, 179, 209, 139, 182, 192, 110, 84, 64, 143, 60,
            199, 209, 126, 198, 24, 65, 182, 42, 140, 199, 11, 70, 81, 29, 151,
            97, 198, 195, 13, 142, 108, 30, 61, 57, 11, 124, 64, 47, 54, 148,
            179, 86, 48, 81, 127, 178, 139, 203, 123, 42, 185, 103, 198, 124, 36, 163,
            24, 69, 78, 17, 109, 53, 76, 41, 116, 159, 146, 72, 10, 150
    };
    // length 90, initial dummy customers, random number [0, 40)
    private static final int[] customerIDs = {
            23, 0, 16, 32, 2, 4, 30, 23, 18, 32, 19, 25, 22, 0, 30, 14, 30, 32,
            13, 5, 35, 6, 21, 4, 5, 18, 21, 33, 8, 15, 16, 38, 4, 11, 21, 3, 24,
            18, 29, 30, 19, 17, 16, 21, 30, 22, 12, 4, 33, 5, 27, 10, 16, 38, 7,
            22, 34, 34, 5, 7, 23, 3, 28, 33, 3, 35, 32, 11, 2, 29, 7, 5, 18, 24,
            16, 14, 24, 26, 27, 36, 0, 1, 24, 13, 4, 37, 8, 26, 32, 1
    };

    public static final List<List<Transaction>> transactions = new ArrayList<>(12);
    static {
        // convert dummy data into the data format that we can use
        // amount, customerId is using the arrays like above,
        // month grows as 0, 1, 2, 3 ... 10, 11, 0, 1, 2 ... 10, 11, 0, 1;
        int award = 0;
        for (int i = 0; i < 12; i++) { transactions.add(new ArrayList<>()); }

        for (int i = 0; i < amounts.length; i++) {
            award = amounts[i]>100 ? 2*amounts[i]-150 : amounts[i]>50 ? amounts[i]-50 : 0;
            transactions.get(i%12).add(new Transaction(i, customerIDs[i], amounts[i], award, i%12));
        }
    }


}
