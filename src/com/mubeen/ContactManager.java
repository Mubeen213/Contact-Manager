package com.mubeen;

import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contacts;

    ContactManager(){
        this.contacts = new ArrayList<Contact>();
    }

    public void setContact(Contact contact, int index){
        this.contacts.add(index, new Contact(contact));
    }

    public Contact getContact(int index){
        return new Contact(contacts.get(index));
    }

    public void addContact(Contact contact){
        contacts.add(new Contact(contact));
    }

    public boolean deleteContact(String name){
        if (contacts.isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty list.");
        }
        for (int i = 0; i < contacts.size(); i++) {
            if(this.contacts.get(i).getName().equalsIgnoreCase(name)){
                this.contacts.remove(i);
                return true;
            }
        }
        return false;
    }
    public String toString(){

        String temp = "";
        for (int i = 0; i < contacts.size(); i++) {
            temp += contacts.get(i).toString();
            temp+="\n";
        }
        return temp;
    }
}
