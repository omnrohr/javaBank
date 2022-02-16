package com.company1.dealership.src.main.model;

import java.util.ArrayList;



public class Dealership {
    private ArrayList<Car> cars;

    public Dealership(ArrayList<Car> cars) {
        this.cars = new ArrayList<Car>();
        for (Car car : cars){
            this.cars.add(new Car(car));
        }
    }

    public Dealership(Car[] cars){
        this.cars = new ArrayList<Car>();
        for (int i = 0; i < cars.length; i++) {
            this.cars.add(cars[i]);
        }
    }

    public void setCar(int index, Car car){
        this.cars.set(index, new Car(car));
    }


    public Car gerCar(int spot){
        return new Car(cars.get(spot));
    }

    public String search(String make, int budget) {
        for (int i = 0; i < this.cars.size(); i++) {
            if (this.cars.get(i) == null) {
                continue;
            } else if (this.cars.get(i).getMake().equals(make) && this.cars.get(i).getPrice() <= budget) {
                return "\nWe found one in spot " + i + "\n" + this.cars.get(i).toString() + "\nAre you interested ?";
            }
        }
        return "Sorry, we couldn't find any cars.";
    }

    public Car getCar(String make){
        for (int i = 0; i <cars.size(); i++){
            if (cars.get(i).getMake().equalsIgnoreCase(make))
                return new Car(cars.get(i));
        }
        return null;
    }

    public void selCar(Car car){
        cars.remove(car);
        car.drive();
    }


    public String toString() {
        String temp = "";
        for (int i = 0; i < this.cars.size(); i++) {
            temp += "Parking Spot: " + i + "\n";
            if (this.cars.get(i) == null) {
                temp += "Empty\n";
            } else {
                temp += this.cars.get(i).toString() + "\n";
            }
        }
        return temp;
    }
}
