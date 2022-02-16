package com.company1.vendingMachine.src.test;

import com.company1.vendingMachine.src.main.model.Item;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemTests {
    Item item;

    @Before
    public void setup(){
        Item item1 = new Item("Pepsi", 1.99,3);
        Item item2 = new Item("Chips", 3.45,2);
        Item item3 = new Item("gum", 0.99,1);
    }

    @Test
    public void addNewItem(){
        item = new Item("Pepsi", 2.66,3);
        assertEquals(3, item.getQuantity());
        assertEquals(2.66, item.getPrice());
        assertEquals("Pepsi", item.getName());
    }

    @Test
    public void copyConstructor(){
        item = new Item("Pepsi", 2.66,3);
        Item itemCopy = new Item(item);
        item.setQuantity(2);
        assertEquals(3,itemCopy.getQuantity());
    }
}
