package com.company1.vendingMachine.src.main.model;

import java.util.Arrays;

public class Machine {
    private Item[][] items;

    public Machine(Item[][] items){
        this.items = new Item[items.length][items[0].length];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                this.items[i][j] = new Item(items[i][j]);
            }
        }
    }

    public void setItem(Item item, int row, int spot){
        items[row][spot] = new Item(item);
    }

    public Item getItem(int row, int spot){
        return new Item(items[row][spot]);
    }


    /**
     * Function name -- dispense
     * @param row (int)
     * @param spot (int)
     * @return (boolean)
     *
     * Inside the function:
     *  1. Checks if the requested item has a quantity bigger than 0.
     * - if so: decreases its quantity by one and returns true.
     * - otherwise: returns false.
     */
    public boolean dispense(int row, int spot){
        if (items[row][spot].getQuantity() == 0){
            return false;
        }
        items[row][spot].setQuantity(items[row][spot].getQuantity()-1);
        return true;
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < items.length; i++) {
            temp += "\t";
            for (int j = 0; j < items[i].length; j++) {
                temp += items[i][j].toString() + " ";
            }
            temp += "\n\n";
        }
        temp += "\t************************************************";
        return temp;
    }
}
