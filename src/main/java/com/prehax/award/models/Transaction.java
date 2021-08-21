package com.prehax.award.models;

public class Transaction {
    private int id;
    private int customerId;
    private int amount;
    private int award;
    private int month;

    public Transaction(int id, int customerId, int amount, int award, int month) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.award = award;
        this.month = month;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", amount=" + amount +
                ", award=" + award +
                ", month=" + month +
                '}';
    }
}
