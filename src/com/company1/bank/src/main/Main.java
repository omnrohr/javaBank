package com.company1.bank.src.main;

import com.company1.bank.src.main.model.Bank;
import com.company1.bank.src.main.model.Transaction;
import com.company1.bank.src.main.model.account.Account;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {



      static String ACCOUNTS_FILE = "D:\\bankProject\\src\\com\\company1\\bank\\src\\main\\data\\accounts.txt";
      static String TRANSACTIONS_FILE = "D:\\bankProject\\src\\com\\company1\\bank\\src\\main\\data\\transactions.txt";

    static Bank bank = new Bank();

    public static void main(String[] args) {

        try {
            ArrayList<Account> accounts = returnAccounts();
            loadAccounts(accounts);

            ArrayList<Transaction> transactions = returnTransactions();
            runTransactions(transactions);
            bank.deductTaxes();
            for (Account account : accounts) {
                System.out.println("\n\t\t\t\t\t ACCOUNT\n\n\t"+account+"\n\n");
                transactionHistory(account.getId());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Function name: wait
     * @param milliseconds
     * 
     * Inside the function:
     *  1. Makes the code sleep for X milliseconds.
     */

     public static void wait(int milliseconds) {
         try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
         } catch (InterruptedException e) {
             System.out.println(e.getMessage());
         }
     }

    /**
     * Name: createObject
     * @param values (String[] values)
     * @return Account
     *
     * Inside the function:
     *   1. Dynamically creates a Chequing, Loan, or Savings object based on the values array.
     */
    public static Account createObject(String[] values) {
        try {
            return (Account) Class.forName("com.company1.bank.src.main.model.account." + values[0])
                    .getConstructor(String.class, String.class, double.class)
                    .newInstance(values[1], values[2], Double.parseDouble(values[3]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Name: returnAccounts()
     * @return ArrayList<Account>
     * @throws FileNotFoundException
     *
     * Inside the function:
     *    1. Creates a Scanner object and reads the data from accounts.txt.
     *    2. Creates an Account object for every line in accounts.txt.
     *    3. Returns an ArrayList of Account objects.
     */
    public static ArrayList<Account> returnAccounts() throws FileNotFoundException{
        try {
            FileInputStream fis = new FileInputStream(ACCOUNTS_FILE);
            Scanner scan = new Scanner(fis);
            ArrayList<Account> accounts = new ArrayList<>();

            while (scan.hasNextLine()){
                accounts.add(createObject(scan.nextLine().split(",")));
            }
            scan.close();
            return accounts;
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    /**
     * Name: loadAccounts
     * @param accounts (ArrayList<Account>)
     *
     * Inside the function:
     *   1. Loads every account into the Bank object.
     *
     */
    public static void loadAccounts(ArrayList<Account> accounts){
        for (Account account : accounts){
             bank.addAccount(account);
        }
    }

    /**
     * Name: returnTransactions()
     * @return ArrayList<Transaction>
     * @throws FileNotFoundException
     *
     * Inside the function:
     *    1. Creates a Scanner object and reads the data from transactions.txt.
     *    2. Populates an ArrayList with transaction objects.
     *    3. Sorts the ArrayList.
     */
    public static ArrayList<Transaction> returnTransactions() throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(TRANSACTIONS_FILE);
        Scanner scan = new Scanner(fis);
        ArrayList<Transaction> transactions = new ArrayList<>();

        while (scan.hasNextLine()){
            String[] list = scan.nextLine().split(",");
            transactions.add(new Transaction(Transaction.Type.valueOf(list[1]),Long.parseLong(list[0]),list[2],Double.parseDouble(list[3])));
        }

        scan.close();
        return transactions;
    }

    /**
     * Name: runTransactions
     * @param transactions ArrayList<Transaction>
     *
     * Inside the function:
     *  1. Executes every transaction using bank.execute.
     */
    public static void runTransactions(ArrayList<Transaction> transactions){
        for (Transaction transaction : transactions){
            bank.executeTransaction(transaction);
        }
    }

    /**
     * Name: transactionHistory
     * @param id (String)
     *
     * Inside the function
     *   1. Print: \t\t\t\t   TRANSACTION HISTORY\n\t
     *   2. Print every transaction that corresponds to the id. (Waits 300 milliseconds before printing the next one)
     *             - Use this format "\t"+transaction+"\n"
     *   3. Print: \n\t\t\t\t\tAFTER TAX\n
     *   4. Print: "\t" + account that corresponds to id +"\n\n\n\n"
     */
    public static void transactionHistory(String id){
        Transaction[] transactions = bank.getTransactions(id);
        System.out.println("\t\t\t\t   TRANSACTION HISTORY\n\t");

        for (Transaction transaction : transactions){
            System.out.println("\t"+transaction+"\n");
            wait(300);
        }

        System.out.println("\n\t\t\t\t\tAFTER TAX\n");
        System.out.println("\t" + bank.getAccount(id) +"\n\n\n\n");

    }

}
