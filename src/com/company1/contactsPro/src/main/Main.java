package com.company1.contactsPro.src.main;

import com.company1.contactsPro.src.main.model.Contact;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        try {
            Contact contact = new Contact("omn", "10/5/1980", "0586526");
            contact.calculateAge("10/5/1980");
        }catch (ParseException e){
            System.out.println(e.getMessage());
        }

    }
}
