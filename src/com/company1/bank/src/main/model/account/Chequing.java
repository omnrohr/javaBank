package com.company1.bank.src.main.model.account;

public class Chequing extends Account{

    private final static double OVERDRAFT_LIMIT = 200.00;
    private static final double OVERDRAFT_FEE = 5.50;

    public Chequing(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Chequing(Account source) {
        super(source);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > (getBalance()+200)){
            System.out.println("your max overdraft is: "+ OVERDRAFT_LIMIT);
            return;
        }else if (amount > getBalance()){
            setBalance(getBalance() - amount - OVERDRAFT_FEE);
        }else {
            setBalance(getBalance() - amount);
        }
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }


}
