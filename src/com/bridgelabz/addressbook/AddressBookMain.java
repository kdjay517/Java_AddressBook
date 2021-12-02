package com.bridgelabz.addressbook;

import java.util.*;

public class AddressBookMain {

    public void choose() {
        MultipleAddressBooks obj = new MultipleAddressBooks();
        while (true) {
            System.out.println("Enter \n 1. To add The new AddressBook\n 2. To add contact in AddressBook\n " +
                    "3. To edit the contact in AddressBook\n 4. To delete the contact in AddressBook\n 5. To delete the AddressBook\n " +
                    "6. To Print the AddressBook\n 7. To Print the contacts in AddressBook\n 0. to exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    obj.addAddressBook();
                    break;
                case 2:
                    obj.addContact();
                    break;
                case 3:
                    obj.editContactInBook();
                    break;
                case 4:
                    obj.deleteContactInBook();
                    break;
                case 5:
                    obj.deleteAddressBook();
                    break;
                case 6:
                    obj.printBook();
                    break;
                case 7:
                    obj.printContactsInBook();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter the wrong input");
            }
        }
    }
    public static void main(String[] args) {
        AddressBookMain addressBookMain = new AddressBookMain();
        addressBookMain.choose();
    }
}