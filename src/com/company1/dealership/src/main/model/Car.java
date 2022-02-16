package com.company1.dealership.src.main.model;

import java.util.Arrays;
import java.util.Objects;

public class Car {

    private String make;
    private int price;
    private int year;
    public enum Color{RED, WHITE, BLUE, BLACK};
    private Color color;
    private String[] parts;

    public Car(String make, int price, int year, Color color, String[] parts){
        if (make == null || make.isBlank()){
            throw new IllegalArgumentException("Invalid make!");
        }
        this.make = make;
        this.price = (price > 5000) ? price : 500;
        this.year = (year > 2000) ? year : 2000;
        this.color = color;
        this.parts = Arrays.copyOf(parts, parts.length);
    }

    public Car(Car source){
        if (source.make == null || source.make.isBlank()){
            throw new IllegalArgumentException("Invalid make!");
        }
        this.make = source.make;
        this.price = source.price;
        this.year = source.year;
        this.color = source.color;
        this.parts = Arrays.copyOf(source.parts, source.parts.length);
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        if (make.isBlank() || make == null){
            throw new IllegalArgumentException("Invalid Make!");
        }
        this.make = make;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 500){
            throw new IllegalArgumentException("Price should be more than $500");
        }
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 2000){
            throw new IllegalArgumentException("We are not supporting cars made before 2000!");
        }
        this.year = year;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String[] getParts() {
        return Arrays.copyOf(parts, parts.length);
    }

    public void setParts(String[] parts) {
        this.parts = Arrays.copyOf(parts, parts.length);
    }

    public void drive() {
        System.out.println("You bought the beautiful " + this.year + " " + this.color
                + " " + this.make + " for " + this.price + ".");
        System.out.println("Please drive your car to the nearest exit.\n");
    }

    @Override
    public int hashCode() {
        return Objects.hash(make,price,year,color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return (this.make.equals(car.make) && this.price==car.price && this.year == car.year && this.color.equals(car.color));
    }

    @Override
    public String toString() {
        return  "Make=" + make +
                "   price=" + price +
                "   year=" + year +
                "   color=" + color;
    }
}
