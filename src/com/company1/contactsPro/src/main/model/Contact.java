package com.company1.contactsPro.src.main.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Contact {
    private String name;
    private int age;
    private String birthDate;
    private String phoneNumber;

    public Contact(String name, String birthDate, String phoneNumber) throws ParseException{
        this.name = name;
        this.age= calculateAge(birthDate);
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public Contact(Contact source){
        this.name = source.name;
        this.age = source.age;
        this.birthDate = source.birthDate;
        this.phoneNumber = source.phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(String birthDate) throws ParseException{
        this.age = calculateAge(birthDate);
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = birthDate;
        this.age = calculateAge(birthDate);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int calculateAge(String birthDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);

        long different = new Date().getTime() - sdf.parse(birthDate).getTime();
        //calculate the difference between today and birthdate.

        int age = (int)(TimeUnit.MILLISECONDS.toDays(different) / 365.25);

        return age;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,age,birthDate,phoneNumber);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        else if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return (this.name.equals(contact.name)
                && this.age == contact.age
                && this.birthDate.equals(contact.birthDate)
                && this.phoneNumber.equals(contact.phoneNumber));
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n" +
                "Phone number: " + this.phoneNumber + "\n" +
                "Birth Date: " + this.birthDate + "\n" +
                "Age: " + this.age + " year old\n";
    }
}
