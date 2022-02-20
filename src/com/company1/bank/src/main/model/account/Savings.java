package com.company1.bank.src.main.model.account;

/**
 *                               SAVINGS ACCOUNT
 *
 * A savings account contains an id, name, and balance.
 * A savings account allows users to deposit or withdraw an amount of money.
 * Deposits are free, but the savings account charges a $5.00 fee for every withdrawal.
 */

public class Savings extends Account{

    private static final double WITHDRAW_FEE = 5.00;
    private static final double OVERDRAFT_LIMIT = -200.00;

    public Savings(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Savings(Account source) {
        super(source);
    }

    @Override
    public void withdraw(double amount) {
        setBalance(getBalance() - amount - WITHDRAW_FEE);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }
}
