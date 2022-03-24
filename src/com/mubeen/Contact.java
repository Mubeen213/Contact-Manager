package com.mubeen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
    private String name;
    private int age;
    private String birthDate;
    private String phoneNumber;

    Contact(String name, String birthDate, String phoneNumber) throws ParseException {
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
        this.name = name;
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
