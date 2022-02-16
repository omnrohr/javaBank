package com.company1.contactsPro.src.main.model;

import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager(ArrayList<Contact> contacts){
        this.contacts = new ArrayList<Contact>();
        for (Contact contact : contacts){
            contacts.add(new Contact(contact));
        }
    }
    public ContactManager(){
        this.contacts = new ArrayList<Contact>();
    }

    public Contact getContact(int index){
        return new Contact(contacts.get(index));
    }

    public void setContact(int index, Contact contact){
        contacts.set(index, contact);
    }

    public void addContact(Contact contact){
        contacts.add(new Contact(contact));
    }

    public void removeContact(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name can not be null/blank!");
        }
        Contact match = contacts.stream()
                .filter((contact) -> contact.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (match != null) contacts.remove(match);
        else System.out.println("name not found");
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < contacts.size(); i++) {
            temp += contacts.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }

}
