package com.mubeen;

import java.text.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
    private String name;
    private int age;
    private String birthDate;
    private String phoneNumber;

    Contact(String name, String birthDate, String phoneNumber) throws ParseException {
        if(name ==null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if(phoneNumber == null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Phone Number cannot be empty");
        }
        if(phoneNumber.length()<5){
            throw new IllegalArgumentException("Phone Number cannot be less than 5");
        }

        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.age = toAge(birthDate);
    }

    public Contact(Contact contact){
        this.name = contact.name;
        this.phoneNumber = contact.phoneNumber;
        this.birthDate = contact.birthDate;
        this.age = contact.age;
    }

    public int getAge(){
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setName(String name) {
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber==null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Phone Number cannot be blank");
        }
        if(phoneNumber.length()<5){
            throw new IllegalArgumentException("Phone Number cannot be less than 5");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = birthDate;
        setAge(toAge(birthDate));
    }

    public int toAge(String birthDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        long diff = new Date().getTime() - formatter.parse(birthDate).getTime();
        return (int)(TimeUnit.MILLISECONDS.toDays(diff)/365);
    }

    public String toString(){

        return "Name: " + this.name +".\n"
                +"Phone Number: " + this.phoneNumber + ".\n"
                +"DateOfBirth: " + this.birthDate + ".\n"
                +"Age: " + this.age + ".\n";
    }

}
