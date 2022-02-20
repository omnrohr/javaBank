package theOldCourse.linkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by dev on 16/09/15.
 */
public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        Customer customer = new Customer("Tim", 54.96);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(12.18);
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(1);
        intList.add(3);
        intList.add(4);

        for(int i=0; i<intList.size(); i++) {
            System.out.println(i +": " + intList.get(i));
        }

        intList.add(1, 2);

        for(int i=0; i<intList.size(); i++) {
            System.out.println(i +": " + intList.get(i));
        }
//        placesToVisit.add("Sydney");
//        placesToVisit.add("Melbourne");
//        placesToVisit.add("Brisbane");
//        placesToVisit.add("Perth");
//        placesToVisit.add("Canberra");
//        placesToVisit.add("Adelaide");
//        placesToVisit.add("Darwin");
//
//        printList(placesToVisit);
//
//        placesToVisit.add(1, "Alice Springs");
//        printList(placesToVisit);
//
//        placesToVisit.remove(4);
//        printList(placesToVisit);



    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i= linkedList.iterator();
        while(i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("=========================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while(stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if(comparison == 0) {
                // equal, do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if(comparison > 0) {
                // new City should appear before this one
                // Brisbane  -> Adelaide
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if(comparison < 0) {
                // move on next city
            }
        }

        stringListIterator.add(newCity);
        return true;
    }


























}
