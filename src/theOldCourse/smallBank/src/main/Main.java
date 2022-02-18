package theOldCourse.smallBank.src.main;

import theOldCourse.smallBank.src.model.Customer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> myArry = new ArrayList<>(Arrays.asList(1.2,2.2));
        Customer customer = new Customer(1,"test");
        customer.addTransactions(2.2);
        myArry.set(0,0.2);
        System.out.println(customer);
    }
}
