package theOldCourse.section6.contactsProject;

public class Main {
    static ContactManager contacts = new ContactManager();

    public static void main(String[] args) {
        Contact contact1 = new Contact("oooo", "13353146");
        Contact contact2 = new Contact("bj;dsf", "1111111");
        Contact contact3 = new Contact("asdf", "22222");
        Contact contact4 = new Contact("erewr", "33333");

        contacts.addContact(contact1);
        contacts.addContact(contact2);
        contacts.addContact(contact3);
        contacts.addContact(contact4);

        System.out.println(contacts);

        System.out.println(contacts.searchContact("oooo"));

    }
}
