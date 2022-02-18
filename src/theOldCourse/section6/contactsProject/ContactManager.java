package theOldCourse.section6.contactsProject;

import java.util.ArrayList;


public class ContactManager {
    ArrayList<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<Contact>();
    }

    public boolean addContact(Contact contact){
        return contacts.add(contact);
    }

    public boolean removeContact(Contact contact){
        return contacts.remove(contact);
    }

    private int findContact(Contact contact){
        return contacts.indexOf(contact);
    }

    public Contact updateContact (Contact oldContact, Contact newContact){
        return contacts.set(contacts.indexOf(oldContact),newContact);
    }

    public Contact searchContact(String name){
        return contacts.stream().filter((contact) ->contact.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString(){
        String temp ="";
        for (Contact contact : contacts){
            temp += contact.toString();
            temp += "\n";
        }
        return temp;
    }

}
