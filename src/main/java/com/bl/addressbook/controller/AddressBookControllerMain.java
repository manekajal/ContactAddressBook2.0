package com.bl.addressbook.controller;

import com.bl.addressbook.models.Contact;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class AddressBookControllerMain {
    public static void main(String[] args){

        System.out.println("Welcome to address Book");
        System.out.println("Enter the number of address Book");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        AddressBookController addressBookController= new AddressBookController();

        Dictionary<String, ArrayList<Contact>> dictionary = new Hashtable<String, ArrayList<Contact>>();
        for (int i = 1; i <= num; i++) {
            System.out.println("Enter the name of address book");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Enter the data of  " + i + " book");
            dictionary.put(name, addressBookController.addbook());
            sc.nextLine();
            System.out.println("The Dictionary is: " + dictionary);
            System.out.println();


        }

    }
}