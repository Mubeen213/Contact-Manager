package com.mubeen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

/*
    * Welcome to the contact application
    * You can add/remove contacts from the contact Manager
    * Each contact is described by their name,age,birthdate and phone number.
 */
public class Main {


    public static void main(String[] args)  {
	// write your code here
        try{
            Contact contact = new Contact("Mubeen","832108911","21/09/2000");
            ContactManager manager = new ContactManager();
            System.out.println(manager);
        }catch (ParseException e){
            System.out.println(e.getMessage());
        }

    }


}
