package com.bridgelabz.addressbook;

import java.io.IOException;
import java.util.*;

import org.json.simple.parser.ParseException;

public class AddressBookMain {

	public void choose() throws IOException, ParseException {
        MultipleAddressBooks obj1 = new MultipleAddressBooks();
        AddressBook obj2 = new AddressBook();
        while (true) {
            System.out.println("Enter \n 1. To add The new AddressBook\n 2. To do AddressBook functions\n 3. To delete the AddressBook\n " +
                               "4. To Print the AddressBook\n 5. To Print the contacts in AddressBook\n 6. To book options\n "
                               + "7. To Write into File \n 8. To Write into JSONFile \n 0. to exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    obj1.addAddressBook();
                    break;
                case 2:
                    obj1.addressBookFunctions();
                    break;
                case 3:
                    obj1.deleteBook();
                    break;
                case 4:
                    obj1.printBook();
                    break;
                case 5:
                    obj1.printContactsInBook();
                    break;
                case 6:
                    obj2.viewByOptions();
                    break;
                case 7:
                	obj1.toWriteIntoTextFile();
                	break;
                case 8:
                	obj1.toWriteIntoJASONFile();
                	break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter the wrong input");
            }
        }
    }
    public static void main(String[] args) throws IOException, ParseException {
        AddressBookMain addressBookMain = new AddressBookMain();
        addressBookMain.choose();
    }
}