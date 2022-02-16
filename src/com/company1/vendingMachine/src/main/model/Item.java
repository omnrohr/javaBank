package com.company1.vendingMachine.src.main.model;

import java.util.Objects;

public class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        if (name.isBlank() || name == null || price < 0 || quantity < 0){
            throw new IllegalArgumentException("Invalid value!");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(Item source) {
        this.name = source.name;
        this.price = source.price;
        this.quantity = source.quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return (this.name.equals(item.name) && this.price == item.price && this.quantity == item.quantity);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,price,quantity);
    }

    @Override
    public String toString() {
        return this.name + ": " + this.price + " ("+this.quantity+")";
    }
}
