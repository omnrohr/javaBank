package com.company1.products.models;

import java.util.Objects;

public class Shirt extends Product{
    public enum Size {SMALL, MEDIUM, LARGE};
    private Size size;


    public Shirt(Size size, double price, String color, String brand) {
        super(price, color ,brand);
        this.size = size;
    }

    public Shirt(Shirt source){
        super(source);
        this.size = source.size;
    }


    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    protected void fold(){
        System.out.println("folding shirt...");
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, getPrice(),getColor(),getBrand());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (!(obj instanceof Shirt)) return false;
        Shirt shirt = (Shirt) obj;
        return (size.equals(shirt.size) &&
                getPrice() == shirt.getPrice() &&
                getColor().equals(shirt.getColor()) &&
                getBrand().equals(shirt.getBrand()));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ":  size=" + size +
                "  price= " + super.getPrice() +
                "  color= " + super.getColor() +
                "  brand= " + super.getBrand() ;
    }
}
