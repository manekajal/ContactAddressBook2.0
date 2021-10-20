package com.bl.addressbook.controller;

import com.bl.addressbook.models.Contact;
import com.bl.addressbook.service.AddressBookService;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBookController {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Contact> arrayList = new ArrayList<Contact>();


        boolean flag = true;

        AddressBookService addbook = new AddressBookService();


        while (flag) {

            System.out.println("Welcome to Address Book");
            System.out.println("Enter 1 for add, 2 for edit, 3 for delete,4 for print, 5 for search, 6 for exit");
            System.out.println("Enter your Choice :");
            switch (scanner.nextInt()) {
                case 1:
                    addbook.addData();
                    System.out.println();
                    break;
                case 2:

                    addbook.edit();
                    break;
                case 3:
                    addbook.delete();
                    System.out.println("________________");
                    break;
                case 4:
                    addbook.showData();

                    break;
                case 5:
                    addbook.search();
                    System.out.println("________________");
                    break;
                case 6:
                    flag = false;
                    break;
            }
        }

    }
}