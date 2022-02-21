package com.company1.bank.src.main.model;

import com.company1.bank.src.main.model.account.Account;
import com.company1.bank.src.main.model.account.Chequing;
import com.company1.bank.src.main.model.account.impl.Taxable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 *  BANK
 *
 * The bank keeps a record of every account created and transaction made.
 * The id of a transaction matches the id of an account.
 * Depending on the account, some transactions may be denied.
 * The bank can deduct taxes from taxable accounts.
 */

public class Bank {
    ArrayList<Account> accounts;
    ArrayList<Transaction> transactions;

    public Bank(){
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    /**
     * Name: addAccount
     * @param account (Account)
     *
     * Inside the function:
     *   1. adds an account to the accounts ArrayList
     */
    public void addAccount(Account account){
        accounts.add(account.clone());
    }

    /**
     * Name: addTransaction
     * @param transaction
     *
     * Inside the function:
     *   1. adds a new transaction object to the array list.
     */
    private void addTransaction(Transaction transaction){
        transactions.add(new Transaction(transaction));
    }

    /**
     * Name: getTransactions
     * @param accountId (String)
     * @return (Transaction[])
     *
     * 1. returns an array of transactions whose id matches the accountId
     */
    public Transaction[] getTransactions(String accountId){
        List<Transaction> list = transactions.stream()
                .filter((transaction) -> transaction.getId().equals(accountId))
                .collect(Collectors.toList());

        return list.toArray(new Transaction[list.size()]);
    }

    /**
     * Name: getAccount()
     * @param transactionId (String)
     * @return (Account)
     *
     * 1. returns an account whose id matches a transaction.
     */
    public Account getAccount(String transactionId){
        return accounts.stream().filter((account) -> account.getId().equals(transactionId))
                .findFirst()
                .orElse(null);
    }

    /**
     * Name: executeTransaction
     * @param transaction
     *
     * Inside the function:
     *  1. calls withdrawTransaction if transaction type is WITHDRAW
     *  2. calls depositTransaction if transaction type is DEPOSIT
     *
     */
    public void executeTransaction(Transaction transaction){
        switch (transaction.getType()){
            case WITHDRAW -> withdrawTransaction(transaction);
            case DEPOSIT -> depositTransaction(transaction);
        }
    }

    private void withdrawTransaction(Transaction transaction){
        if (getAccount(transaction.getId()).withdraw(transaction.getAmount()))
            transactions.add(transaction);
    }
    private void depositTransaction(Transaction transaction){
        getAccount(transaction.getId()).deposit(transaction.getAmount());
        transactions.add(transaction);
    }

    /**
     * Name: getIncome
     * @param account (Taxable)
     * @return double
     *
     * Inside the function:
     *   1. Gets every transaction that matches the account's id.
     *   2. Maps every transaction to a double.
     *       - Transactions of type WITHDRAW are mapped to negative numbers.
     *       - Transactions of type DEPOSIT are mapped to positive numbers.
     *   3. Takes the sum of every number and returns the income.
     *
     */
    public double getIncome(Taxable account){
        Transaction[] transactions = getTransactions(((Chequing) account).getId());
        return Arrays.stream(transactions).mapToDouble((transaction) -> {
            switch (transaction.getType()){
                case WITHDRAW: return transaction.getAmount()*-1;
                case DEPOSIT: return transaction.getAmount();
                default: return 0;
            }
        }).sum();
    }

    public void deductTaxes() {
        for (Account account : accounts) {
            if (Taxable.class.isAssignableFrom(account.getClass())) {
                Taxable taxable = (Taxable)account;
                taxable.tax(getIncome(taxable));
            }
        }
    }

}
