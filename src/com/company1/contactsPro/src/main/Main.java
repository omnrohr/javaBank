package com.company1.contactsPro.src.main;

import com.company1.contactsPro.src.main.model.Contact;
import com.company1.contactsPro.src.main.model.ContactManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    static final String FILE_DIR= "D:\\bankProject\\src\\com\\company1\\contactsPro\\src\\main\\data\\contacts.txt";
    static ContactManager manager = new ContactManager();
    public static void main(String[] args) {
        try {
            loadContacts("contacts.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("CONTACTS LOADED\n\n");
            System.out.println(manager);
            manageContacts();
        }

    }

    /**
     * Name: manageContacts
     *
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) add or b) remove a contact c) exit.
     *   •        case a: ask for the name, phone number and birthDate.
     *   •        case b: ask who they'd like to remove.
     *   •        case c: break the loop.
     *   • 3. close Scanner.
     */

    public static void manageContacts() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Would you like to \n\ta) add another contact\n\tb) remove a contact \n\tc) exit");
            String response = scan.nextLine();
            if (response.equals("a")) {
                System.out.print("\tName: ");
                String name = scan.nextLine();
                System.out.print("\tPhone Number: ");
                String phoneNumber = scan.nextLine();
                System.out.print("\tBirth Date: ");
                String birthDate = scan.nextLine();
                if (name.isBlank() || phoneNumber.isBlank() || phoneNumber.length() < 5) {
                    System.out.println("\nThe input you provided is not valid. Registration failed.");
                } else {
                    try {
                        manager.addContact(new Contact(name, phoneNumber, birthDate));
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println("\n\nUPDATED CONTACTS\n\n" + manager);
                    }
                }
            } else if (response.equals("b")) {
                System.out.println("\nWho would you like to remove?");
                manager.removeContact(scan.nextLine());
                System.out.println("\n\nUPDATED CONTACTS\n\n" + manager);

            } else {
                break;
            }
        }
        scan.close();

    }

    /**
     * Name: loadContacts
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads contacts from <fileName>;
     *   • 2. From the manager object, it adds all contacts to the contacts list.
     *        Hint: use scan.next to grab the next String separated by white space.
     */
    public static void loadContacts(String fileName) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(FILE_DIR);
        Scanner scan = new Scanner(fis);
        while (scan.hasNextLine()){
            try {
                manager.addContact(new Contact(scan.next(),scan.next(),scan.next()));
            }catch (ParseException e){
                System.out.println(e.getMessage());
            }
            scan.close();
        }
    }
}
