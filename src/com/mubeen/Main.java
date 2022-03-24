package com.mubeen;

import java.text.ParseException;

/*
    * Welcome to the contact application
    * You can add/remove contacts from the contact Manager
    * Each contact is described by their name,age,birthdate and phone number.
 */
public class Main {

    public static void main(String[] args)  {
	// write your code here
        try{
            Contact contact = new Contact("Mubeen","09/21/2000","7097088");
            Contact contact1 = new Contact(contact);
            contact.setBirthDate("01/01/2000");
            contact1.setAge(13);
            System.out.println(contact);
            System.out.println(contact1);
        }catch (ParseException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("process complete");
        }

    }
}
