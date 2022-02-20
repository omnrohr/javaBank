package com.company1.products.models;

import java.util.Objects;

public class Pants  extends Product implements IDiscountable{
//    waist, price, color and brand.
    private int waist;

    public Pants(int waist, double price, String color, String brand) {
        super(price, color, brand);
        this.waist = waist;
    }

    public Pants(Pants source) {
        super(source);
        this.waist = source.waist;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    @Override
    protected void fold(){
        System.out.println("folding pant...");
    }

    @Override
    public int hashCode() {
        return Objects.hash(waist, getPrice(),getColor(),getBrand());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (!(obj instanceof Pants)) return false;
        Pants pants = (Pants) obj;
        return (this.waist == pants.waist &&
                this.getPrice() == pants.getPrice() &&
                this.getColor().equals(pants.getColor()) &&
                this.getBrand().equals(pants.getBrand()));
    }

    @Override
    public void discount() {
        setPrice(getPrice()/2);
    }



    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ":  waist=" + waist +
                "  price= " + super.getPrice() +
                "  color= " + super.getColor() +
                "  brand= " + super.getBrand() ;
    }



}
