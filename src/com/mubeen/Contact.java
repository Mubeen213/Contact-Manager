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

    public int toAge(String birthDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        long diff = new Date().getTime() - formatter.parse(birthDate).getTime();
        return (int)(TimeUnit.MILLISECONDS.toDays(diff)/365);
    }

    public int getAge(){
        return this.age;
    }
}
