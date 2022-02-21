package com.company1.bank.src.main.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Transaction implements Comparable<Transaction>{


    public enum Type {WITHDRAW, DEPOSIT};
    private Type type;
    private long timestamp;
    private String id;
    private double amount;

    public Transaction(Type type, long timestamp, String id, double amount) {
        if (id.isBlank() || id == null){
            throw new IllegalArgumentException("Invalid Id!");
        } else if (amount < 0){
            throw new IllegalArgumentException("Invalid amount!");
        }
        this.type = type;
        this.timestamp = timestamp;
        this.id = id;
        this.amount = amount;
    }

    public Transaction(Transaction source){
        this.type = source.type;
        this.timestamp = source.timestamp;
        this.id = source.id;
        this.amount = source.amount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.isBlank() || id == null){
            throw new IllegalArgumentException("Invalid Id!");
        }
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount < 0){
            throw new IllegalArgumentException("Invalid Amount!");
        }
        this.amount = amount;
    }

    public String returnDate(){
        Date date = new Date(timestamp * 1000);
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type,timestamp,id,amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (!(obj instanceof Transaction)) return false;

        Transaction transaction = (Transaction) obj;

        return (type.equals(transaction.type) &&
                timestamp == transaction.timestamp &&
                id.equals(transaction.id) &&
                amount == transaction.amount);
    }

    @Override
    public int compareTo(Transaction o) {
        return Long.compare(timestamp, o.timestamp);
    }

    @Override
    public String toString() {
        return type + "    " +
                "\t" + returnDate() + "" +
                "\t" + id + "" +
                "\t$" + amount + "";
    }
}
