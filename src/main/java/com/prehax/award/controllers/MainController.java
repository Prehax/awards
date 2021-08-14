package com.prehax.award.controllers;

import com.alibaba.fastjson.JSON;
import com.prehax.award.models.Award;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/")
public class MainController {
    // This is the dummy data for 3 months transaction amount
    private static final int[][] transactions = new int[][]{
        {20, 26, 145, 69, 125, 116, 148, 116, 58, 77, 177, 60, 103, 154, 60,
                197, 131, 74, 198, 141, 179, 209, 139, 182, 192, 110, 84, 64, 143, 60},
        {199, 209, 126, 198, 24, 65, 182, 42, 140, 199, 11, 70, 81, 29, 151,
                97, 198, 195, 13, 142, 108, 30, 61, 57, 11, 124, 64, 47, 54, 148},
        {179, 86, 48, 81, 127, 178, 139, 203, 123, 42, 185, 103, 198, 124, 36, 163,
                24, 69, 78, 17, 109, 53, 76, 41, 116, 159, 146, 72, 10, 150}
    };

    @GetMapping(produces = {"application/json"})
    @CrossOrigin(origins = {"http://localhost:3000"}, maxAge = 3600)
    public String getAwards() {
        List<List<Award>> awards = new ArrayList<>();
        for (int i = 0; i < transactions.length; i++) {
            awards.add(new ArrayList<>());
            for (int amount: transactions[i]) {
                int award = amount>100 ? 2*amount-150 : amount>50 ? amount-50 : 0;
                awards.get(i).add(new Award(amount, award));
            }
        }
        return JSON.toJSONString(awards);
    }
}
