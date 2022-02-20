package com.company1.bank.src.main.model.account;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/** CHEQUING ACCOUNT

 A chequing account contains an id, name, and balance.
 A chequing account allows users to deposit or withdraw an amount of money.
 The chequing account charges an overdraft fee of $5.50 if the amount being withdrawn exceeds the account balance.
 The overdraft limit is $200.00 dollars.
 A chequing account is taxable. Income that exceeds $3,000 is taxed 15%.


 SAVINGS ACCOUNT

 A savings account contains an id, name, and balance.
 A savings account allows users to deposit or withdraw an amount of money.
 Deposits are free, but the savings account charges a $5.00 fee for every withdrawal.

 LOAN ACCOUNT

 A loan account contains an id, name, and balance.
 A loan account allows users to deposit or withdraw an amount of money.
 A withdrawal can't made if the debt exceeds $10,000.
 Every withdrawal is charged a fixed interest rate of 2%.

 TRANSACTION

 An account transaction can be: WITHDRAW or DEPOSIT.
 Every transaction has an id, amount, and timestamp.
 Transactions must be sorted based on timestamp.
 A transaction's timestamp must display to the user as a readable date.
 **/

public abstract class Account {
    private String id;
    private String name;
    private double balance;

    public Account(String id, String name, double balance) {
        if (id.isBlank() || id == null){
            throw new IllegalArgumentException("Invalid ID!");
        }else if (name.isBlank() || name == null){
            throw new IllegalArgumentException("Invalid Name!");
        }else if (balance < 0){
            throw new IllegalArgumentException("Invalid Balance!");
        }
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(Account source){
        this.id = source.id;
        this.name = source.name;
        this.balance = source.balance;
    }

    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.isBlank() || id == null){
            throw new IllegalArgumentException("Invalid Id!");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank() || name == null){
            throw new IllegalArgumentException("Invalid Name!");
        }
        this.name = name;
    }

    public double getBalance() {
        return round(balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    protected double round(double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
        return Double.parseDouble(formatter.format(amount));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "   " +
                "\t" + id + "" +
                "\t" + name + "" +
                "\t$" + balance + "";
    }
}
