package com.company1.dealership.src.main;

import com.company1.dealership.src.main.model.Car;
import com.company1.dealership.src.main.model.Dealership;

import java.util.ArrayList;

public class Main {
    static String[] parts = new String[] {"key", "wheels", "tires"};

    static Car[] cars = new Car[]{new Car("Nissan", 5000, 2015, Car.Color.BLACK, parts),
    new Car("Nissan", 5000, 2015, Car.Color.BLACK,parts), new Car("Nissan", 5000, 2015, Car.Color.BLACK, new String[]{"key", "wheels"})};
    public static void main(String[] args) {
        Car car1 = new Car("Nissan", 5000, 2015, Car.Color.BLACK,parts);
        Car car2 = new Car("Toyota", 6000, 2016, Car.Color.WHITE,parts);
        Car car3 = new Car("BMW", 7000, 2017, Car.Color.BLUE, parts);
        Car car4 = new Car("Mitsubishi", 9000, 2018, Car.Color.RED,parts);

        ArrayList<Car> dealershipCars= new ArrayList<Car>();
        dealershipCars.add(car1);
        dealershipCars.add(car2);
        dealershipCars.add(car3);
        dealershipCars.add(car4);

        Dealership dealership = new Dealership(cars);
        Dealership dealership1 = new Dealership(dealershipCars);
        System.out.println(dealership1.getCar("nissan"));
        System.out.println(dealership);
        System.out.println(dealership1);

        dealership1.selCar(dealership1.getCar("nissan"));
        System.out.println(dealership1);
    }
}
