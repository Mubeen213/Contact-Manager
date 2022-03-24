
package com.mubeen;

import java.text.ParseException;
import java.util.ArrayList;

public class ContactManager {
     ArrayList<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<Contact>();
    }

    public Contact getContact(int index) throws ParseException {
        return new Contact(contacts.get(index));
    }

    public void setContact(Contact contact, int index) throws ParseException {
        contacts.set(index, new Contact(contact));
    }
}