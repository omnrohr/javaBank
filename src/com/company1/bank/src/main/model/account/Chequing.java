package com.company1.bank.src.main.model.account;

import com.company1.bank.src.main.model.account.impl.Taxable;

/**
 *                               CHEQUING ACCOUNT
 *
 * A chequing account contains an id, name, and balance.
 * A chequing account allows users to deposit or withdraw an amount of money.
 * The chequing account charges an overdraft fee of $5.50 if the amount being withdrawn exceeds the account balance.
 * The overdraft limit is $200.00 dollars.
 * A chequing account is taxable. Income that exceeds $3,000 is taxed 15%.
 *
 */

public class Chequing extends Account implements Taxable {

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
    public Account clone() {
        return new Chequing(this);
    }

    @Override
    public boolean withdraw(double amount) {
        boolean success = true;
        if (amount > (getBalance()+200)){
            System.out.println("your max overdraft is: "+ OVERDRAFT_LIMIT);
            success = false;
        }else if (amount > getBalance()){
            setBalance(getBalance() - amount - OVERDRAFT_FEE);
        }else {
            setBalance(getBalance() - amount);
        }return success;
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }


    @Override
    public void tax(double income) {
        setBalance(getBalance() -
                ((income >= TAXABLE_INCOME) ?
                        ((income-TAXABLE_INCOME) * TAX_RATE) : 0));
    }
}
