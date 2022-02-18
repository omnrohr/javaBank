package theOldCourse.smallBank.src.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    int id;
    String name;
    ArrayList<Double> transactions;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public Customer(Customer source) {
        this.id = source.id;
        this.name = source.name;
        this.transactions = new ArrayList<>(source.transactions);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public void addTransactions(double transaction) {
        this.transactions.add(transaction);
    }

    @Override
    public String toString() {
        return  "id= " + id +
                "  name= " + name +
                "  transactions= " + transactions;
    }
}
