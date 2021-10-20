package com.bl.addressbook.service;

import com.bl.addressbook.models.Contact;

import java.util.*;

public class AddressBookService {

        ArrayList<Contact> arrayList = new ArrayList<Contact>();
    private static List<Contact> addressBookServiceList;

        Scanner scanner;

   

    public enum IOService{console_IO,FILE_IO,DB_IO,REST_IO};



        public AddressBookService() {
            scanner = new Scanner(System.in);
        }
        public AddressBookService(List<Contact> addressBookServiceList){
            this.addressBookServiceList =addressBookServiceList;

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
                }else
                {
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
            ListIterator<Contact>li= arrayList.listIterator();

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
                }else
                {
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
            }while(true);


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


        public void viewCity(){
            System.out.println("Enter the City or State");
            String  cityOrState = scanner.nextLine();
            ArrayList<Object> contactList1 = new ArrayList<Object>();
            arrayList.stream()
                    .map(Contact::getCity)
                    .distinct()
                    .forEach(System.out::println);
        }

        public void readEmployeePayrollData(  Scanner consoleInputReader ) {


            System.out.println(" Enter Employee First Name :");
        String firstName= consoleInputReader.next();
        System.out.println(" Enter Employee Last Name :");
        String lastName= consoleInputReader.next();
        System.out.println(" Enter Employee Address :");
        String address= consoleInputReader.next();
        System.out.println(" Enter Employee City :");
        String city= consoleInputReader.next();
        System.out.println(" Enter Employee State :");
        String state= consoleInputReader.next();
        System.out.println(" Enter Employee Zip Code :");
        String zipCode= consoleInputReader.next();
        System.out.println(" Enter Employee Mobile Number :");
        String mobileNo= consoleInputReader.next();
        System.out.println(" Enter Employee Email ID :");
        String emailId= consoleInputReader.next();

        addressBookServiceList.add(new Contact(firstName,lastName,address,city,state,zipCode,mobileNo,emailId));

    }
    public void writeEmployeePayrollData() {

        System.out.println(" Writing Employee Payroll Roaster to console \n" +addressBookServiceList);

    }
}
