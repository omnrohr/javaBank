package com.company1.bank.src.main.model.account;

/**
 *                               CHEQUING ACCOUNT
 *
 * A chequing account contains an id, name, and balance.
 * A chequing account allows users to deposit or withdraw an amount of money.
 * The chequing account charges an overdraft fee of $5.50 if the amount being withdrawn
 *      exceeds the account balance.
 * The overdraft limit is $200.00 dollars.
 * A chequing account is taxable. Income that exceeds $3,000 is taxed 15%.
 */

public class Chequing extends Account {
    private static final double OVERDRAFT_FEE = 5.50;
    private static final double OVERDRAFT_LIMIT = -200.00;

    private static final double TAXABLE_INCOME = 3000;
    private static final double TAX_RATE = 0.15;

    public Chequing(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Chequing(Account source) {
        super(source);
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }

    @Override
    public boolean deposit(double amount) {
        return false;
    }
}
