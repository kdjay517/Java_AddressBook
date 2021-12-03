package com.bridgelabz.addressbook;

import java.util.*;

public class MultipleAddressBooks {
	Map<String, AddressBook> addressBookMap = new HashMap<>();

	public void addAddressBook() {
		System.out.println("Enter Name of new Address Book: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookMap.containsKey(bookName)) {
			System.out.println("Address book with this name exists, Enter new name.");
			addAddressBook();
		} else {
			AddressBook addressBook = new AddressBook();
			addressBookMap.put(bookName, addressBook);
			System.out.println("press 1 if you want to add another book or press any key to exit.");
			int newBook = scanner.nextInt();
			if (newBook == 1) {
				addAddressBook();
			}
		}
	}

	public void addContact() {
		System.out.println("Enter the name of Address book to add the contact.");
		Scanner scanner = new Scanner(System.in);
		String newContact = scanner.nextLine();
		AddressBook addressBook = addressBookMap.get(newContact);
		if (addressBook == null) {
			System.out.println("No book found");

		} else {
			addressBookMap.get(newContact).addContact();
		}
	}

	public void editContactInBook() {
		System.out.println("Enter Name of Address Book you want to edit: ");
		Scanner scanner = new Scanner(System.in);
		String editBookName = scanner.next();
		if (addressBookMap.containsKey(editBookName)) {
			addressBookMap.get(editBookName).editContact();
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			editContactInBook();
		}
	}

	public void deleteAddressBook() {
		System.out.println("Enter Name of Address Book you want to delete: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookMap.containsKey(bookName)) {
			addressBookMap.remove(bookName);
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			deleteAddressBook();
		}
	}

	public void deleteContactInBook() {
		System.out.println("Enter Name of Address Book you want to delete the contacts in it: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookMap.containsKey(bookName)) {
			addressBookMap.get(bookName).deleteContact();
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			deleteContactInBook();
		}
	}

	public void searchPerson() {
		System.out.println("Enter city or state to search a person:");
		Scanner sc = new Scanner(System.in);
		String place = sc.next();
		for (String entry : addressBookMap.keySet()) {
			if(addressBookMap.get(entry).person(place)) {
				for (Map.Entry<String, AddressBook> contact : addressBookMap.entrySet()) {
					System.out.println("The contacts in the Book of < " + contact.getKey() + " > are!...");
					System.out.println(contact.getValue().contactDetailsList);
				}
			}else {
				System.out.println("Details Not found");
				searchPerson();
			}
		}
	}

	public void printBook() {
		System.out.println("These are AddressBooks in program.");
		for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
			System.out.println(entry.getKey() + "[]");
		}
	}

	public void printContactsInBook() {
		for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
			System.out.println(entry.getValue().contactDetailsList);
		}
		System.out.println(" ");
	}
}
