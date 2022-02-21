package com.company1.bank.src.main.model.account;

/**
 *
 * LOAN ACCOUNT
 *
 * A loan account contains an id, name, and balance.
 * A loan account allows users to deposit or withdraw an amount of money.
 * A withdrawal can't made if the debt exceeds $10,000.
 * Every withdrawal is charged a fixed interest rate of 2%.
 */

public class Loan extends Account{


    private static final double INTEREST_RATE = 0.02;
    private static final double MAX_DEBT = 10000;


    public Loan(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Loan(Account source) {
        super(source);
    }

    @Override
    public Account clone() {
        return new Loan(this);
    }

    @Override
    public boolean withdraw(double amount) {
        if (getBalance() + amount*1.02 > MAX_DEBT){
            System.out.println("your max debt is: " + MAX_DEBT);
            return false;
        }
        setBalance(getBalance() + amount*1.02);
        return true;
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() - amount);
    }
}
