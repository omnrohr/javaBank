package com.company1.vendingMachine.src.main;

import com.company1.vendingMachine.src.main.model.Item;
import com.company1.vendingMachine.src.main.model.Machine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\t************************************************");
        System.out.println("\t             WELCOME TO JAVA DRINKS!            ");
        System.out.println("\t************************************************");

        Item[][] items = new Item[][] {
             { new Item("Pepsi", 1.99, 3) , new Item("Fresca", 1.49, 3), new Item("Brisk", 2.49, 2) },
             { new Item("Fanta", 1.99, 2) , new Item("Barq's", 1.49, 2), new Item("A & W", 2.49, 3) },
             { new Item("Crush", 1.99, 2) , new Item("C-Cola", 1.49, 2), new Item("Berry", 2.49, 1) }
         };

        Machine machine= new Machine(items);

        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("\n\n"+machine);
            System.out.print("Pick a row: ");
            int row = scan.nextInt();
            System.out.print("Pick a spot in the row: ");
            int spot = scan.nextInt();
            scan.nextLine();
            if (machine.dispense(row,spot)){
                System.out.print("\nEnjoy your drink! Press 1 to purchase another: \r");

                if (scan.nextInt() == 1) continue;
                else break;
            }

            else {
                System.out.println("\nSorry, we're out of this item. Press 1 to purchase another: ");
                if (scan.nextInt() == 1) continue;
                else
                    scan.close();
                    System.exit(0);
            }
        }
    }
}
