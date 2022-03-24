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

    static ContactManager manager = new ContactManager();
    public static void main(String[] args)  {
	// write your code here
        try{
            loadContacts("Resources/contacts.txt");
            manageContacts();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

    }

    public static void loadContacts(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner sc = new Scanner(fis);
        while(sc.hasNextLine()){
           try{
               Contact contact = new Contact(sc.next(), sc.next(), sc.next());
               manager.addContact(contact);
           }catch (ParseException e){
               System.out.println(e.getMessage());
           }
        }
    }

    public static void manageContacts(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Would you like to \n\ta) add another contact\n\tb) remove a contact \n\tc) exit");
            String response = sc.nextLine();
            if(response.equals("a")){
                System.out.println("Enter Name: ");
                String name = sc.nextLine();
                System.out.println("Enter Phone Number: ");
                String phoneNumber = sc.nextLine();
                System.out.println("Enter Date of birth: ");
                String birthDate = sc.nextLine();
                try{
                    manager.addContact(new Contact(name,phoneNumber,birthDate));
                    System.out.println("\nUPDATED CONTACTS\n");
                }catch (ParseException e){
                    System.out.println(e.getMessage());
                }finally {

                    System.out.println(manager);
                }
            }
            else if(response.equals("b")){
                System.out.println("Who would you like to delete\n");
                String name = sc.nextLine();
                if(name.isBlank()){
                    System.out.println("Please provide a name\n");
                }
                else{
                    if(manager.deleteContact(name)){
                        System.out.println("Contact deleted\n");
                        System.out.println(manager);
                    }else{
                        System.out.println("Name does not match in our record\n");
                    }
                }
            }else{
                break;
            }
        }
        sc.close();
    }
}
