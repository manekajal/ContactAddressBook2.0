package com.bl.addressbook.service;

import com.bl.addressbook.models.Contact;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AddressBookService {

    ArrayList<Contact> arrayList = new ArrayList<Contact>();
    private static List<Contact> addressBookServiceList;

    Scanner scanner;


    public enum IOService {console_IO, FILE_IO, DB_IO, REST_IO}

    ;


    public AddressBookService() {
        scanner = new Scanner(System.in);
    }

    public AddressBookService(List<Contact> addressBookServiceList) {
        this.addressBookServiceList = addressBookServiceList;

    }

    public void addData() {
        System.out.println("Enter all the details");

        System.out.print(" Enter First Name : ");
        String firstName = scanner.nextLine();

        System.out.print(" Enter Last Name : ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Address : ");
        String address = scanner.nextLine();
        System.out.print("Enter City : ");
        String city = scanner.nextLine();

        System.out.print("Enter state : ");
        String state = scanner.nextLine();
        System.out.print("Enter zip : ");
        String zipCode = scanner.nextLine();
        System.out.print("Enter Mobile Number : ");
        String mobileNo = scanner.nextLine();
        System.out.print("Enter the Email ID : ");
        String emailId = scanner.nextLine();

        arrayList.add(new Contact(firstName, lastName, address, city, state, zipCode, mobileNo, emailId));
        System.out.println("Data added Successfully");
        System.out.println(arrayList.get(0));
        showData();
    }

    public void showData() {
        System.out.println(arrayList);

    }

    public void delete() {
        boolean found = false;
        System.out.println(" Enter the name to search :");
        String firstName = scanner.nextLine();
        System.out.println("_____________________________");
        Iterator<Contact> it = arrayList.iterator();
        while (it.hasNext()) {
            Contact contact = it.next();
            if (contact.getFirstName().equals(firstName)) {
                it.remove();
                found = true;
            }


            if (!found) {
                System.out.println(" name is not found");
            } else {
                System.out.println(" Record is deleted Successfully :");
            }
            break;
        }

    }

    public void edit() {
        boolean found = false;
        System.out.println(" Enter the name to edit :");
        String firstName = scanner.nextLine();
        System.out.println("_____________________________");
        ListIterator<Contact> li = arrayList.listIterator();

        while (li.hasNext()) {
            Contact contact = li.next();
            if (contact.getFirstName().equals(firstName)) {
                System.out.println("Enter all the details");


                System.out.print(" Enter Last Name : ");
                String lastName = scanner.nextLine();
                System.out.print("Enter Address : ");
                String address = scanner.nextLine();
                System.out.print("Enter City : ");
                String city = scanner.nextLine();

                System.out.print("Enter state : ");
                String state = scanner.nextLine();
                System.out.print("Enter zip : ");
                String zipCode = scanner.nextLine();
                System.out.print("Enter Mobile Number : ");
                String mobileNo = scanner.nextLine();
                System.out.print("Enter the Email ID : ");
                String emailId = scanner.nextLine();

                li.set(new Contact(firstName, lastName, address, city, state, zipCode, mobileNo, emailId));


                found = true;
            }


            if (!found) {
                System.out.println(" name is not found");
            } else {
                System.out.println(" Record is edited Successfully :");
            }
            break;
        }
    }

    public void search() {
        boolean found = false;
        do {
            System.out.println(" Enter the city to search :");
            String city = scanner.nextLine();
            System.out.println("_____________________________");
            Iterator<Contact> it = arrayList.iterator();
            while (it.hasNext()) {
                Contact contact = it.next();
                if (contact.getCity().equals(city)) {
                    System.out.println(contact);
                    found = true;
                }


                if (!found) {
                    System.out.println(" city is not found");
                }
                break;
            }
        } while (true);


    }
    //      public void viewCity();
    //      {
    //          System.out.println("Enter the City or State");
    //        String  cityOrState = scanner.nextLine();
    //          arrayList.stream()
    //                 .map(Contact::getCity)
    //                 .distinct()
    //               .forEach(System.out::println);
    //

    //      }


    public void viewCity() {
        System.out.println("Enter the City or State");
        String cityOrState = scanner.nextLine();
        ArrayList<Object> contactList1 = new ArrayList<Object>();
        arrayList.stream()
                .map(Contact::getCity)
                .distinct()
                .forEach(System.out::println);
    }

    public void readEmployeePayrollData(Scanner consoleInputReader) {


        System.out.println(" Enter Employee First Name :");
        String firstName = consoleInputReader.next();
        System.out.println(" Enter Employee Last Name :");
        String lastName = consoleInputReader.next();
        System.out.println(" Enter Employee Address :");
        String address = consoleInputReader.next();
        System.out.println(" Enter Employee City :");
        String city = consoleInputReader.next();
        System.out.println(" Enter Employee State :");
        String state = consoleInputReader.next();
        System.out.println(" Enter Employee Zip Code :");
        String zipCode = consoleInputReader.next();
        System.out.println(" Enter Employee Mobile Number :");
        String mobileNo = consoleInputReader.next();
        System.out.println(" Enter Employee Email ID :");
        String emailId = consoleInputReader.next();

        arrayList.add(new Contact(firstName, lastName, address, city, state, zipCode, mobileNo, emailId));

    }

    public void writeEmployeePayrollData() {

        System.out.println(" Writing Employee Payroll Roaster to console \n" + arrayList);

    }

    public void readDataUsingCSV() throws IOException {
        final String contactcsv = "/c/Users/KAJAL/IdeaProjects/ContactAddressBook2.0";

        try {

            Reader reader = Files.newBufferedReader(Paths.get("contactcsv.csv"));
            CsvReader csvReader = new CSVReader(reader);
                String nextline[];
            while((nextline =csvReader.readNext())!=null)

                {
                    System.out.println("First Name  " + nextline[0]);
                    System.out.println("Last Name  " + nextline[1]);
                    System.out.println("Address  " + nextline   [2]);
                    System.out.println("City  " + nextline[3]);
                    System.out.println("State  " + nextline[4]);
                    System.out.println("Phone  " + nextline[5]);
                    System.out.println("Zip  " + nextline[6]);
                }
            }catch (IOException e) {
            e.printStackTrace();
        }
        }
        public  void writeDataUsingCSV()
        {
        try {
            Writer writer = Files.newBufferedWriter(Paths.get("contactcsv.csv"));
            StatefulBeanToCsvBuilder<Contact> builder = new StatefulBeanToCsvBuilder<>(writer);
            StatefulBeanToCsv <Contact> beanWriter =builder.build();


            beanWriter.write(arrayList);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        }

    }
