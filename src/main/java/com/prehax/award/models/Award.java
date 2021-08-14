package com.prehax.award.models;

public class Award {
    private int amount;
    private int award;

    public Award(int amount, int award) {
        this.amount = amount;
        this.award = award;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }
}
