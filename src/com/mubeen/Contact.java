
package com.mubeen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
    private String name;
    private String phoneNumber;
    private String birthDate;
    private int age;

    Contact(String name, String phoneNumber, String birthDate) throws ParseException {
        this.name = name;
        this.phoneNumber=phoneNumber;
        this.birthDate = birthDate;
        this.age = toAge(birthDate);
    }
    public Contact(Contact contact){
        this.name  = contact.name;
        this.phoneNumber = contact.phoneNumber;
        this.birthDate = contact.birthDate;
        this.age = contact.age;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthDate(String birthDate)throws ParseException {
        this.birthDate = birthDate;
        this.age = toAge(birthDate);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public int getAge() {
        return this.age;
    }

    public int toAge(String birthDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);
        long diff = new Date().getTime() - formatter.parse(birthDate).getTime(); //milliseconds
        return (int)(TimeUnit.MILLISECONDS.toDays(diff)/365);
    }

    public String toString(){
        return "Name: " + this.name+".\n"
                +"Phone Number: " + this.phoneNumber + ".\n"
                +"Date of Birth: " + this.birthDate + ".\n"
                +"Age: " + this.age+".\n";

    }
}