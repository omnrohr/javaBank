package com.company1.bank.src2.main.model.account;

import java.text.DecimalFormat;

public abstract class Account {
    private String id;
    private String name;
    private double balance;

    public Account(String id, String name, double balance){
        if (id == null || id.isBlank()){
            throw new IllegalArgumentException("Invalid Id");
        }else if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid Name");
        }else if (balance < 0){
            throw new IllegalArgumentException("Invalid Balance");
        }
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(Account source){
        if (source.id == null || source.id.isBlank() ||
                source.name == null || source.name.isBlank()){
            throw new IllegalArgumentException("Invalid values!");
        }
        this.id = source.id;
        this.name = source.name;
        this.balance = source.balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()){
            throw new IllegalArgumentException("Invalid id!");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid name!");
        }
        this.name = name;
    }

    public double getBalance() {
        return round(balance);
    }

    public void setBalance(double balance) {
        this.balance = round(balance);
    }

    public abstract boolean withdraw(double amount);

    public abstract void deposit(double amount);

    protected double round(double amount){
        DecimalFormat formatter = new DecimalFormat("#.###");
        return Double.parseDouble(formatter.format(amount));
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName()) + "    " +
                "\t" + this.getId()+ "" +
                "\t" + this.getName()+ "" +
                "\t$" + this.getBalance() + "";
    }
}
