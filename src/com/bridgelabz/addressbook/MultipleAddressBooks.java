package com.bridgelabz.addressbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class MultipleAddressBooks {
	Map<String, AddressBook> addressBookMap = new HashMap<>();
	public static String FILE_NAME = "Data/contactdetails.txt";

	public void addAddressBook() {
		System.out.println("Enter Name of new Address Book: ");
		Scanner sc = new Scanner(System.in);
		String bookName = sc.next();
		if (addressBookMap.containsKey(bookName)) {
			System.out.println("Address book with this name exists, Enter new name.");
			addAddressBook();
		} else {
			AddressBook addressBook = new AddressBook();
			addressBookMap.put(bookName, addressBook);
			System.out.println("press 1 if you want to add another book or press any key to exit.");
			int newBook = sc.nextInt();
			if (newBook == 1) {
				addAddressBook();
			}
		}
	}

	public void addressBookFunctions() {
		System.out.println("Enter the name of Address book to add, edit or delete the contact.");
		Scanner sc = new Scanner(System.in);
		String bookName = sc.nextLine();
		if (addressBookMap.containsKey(bookName)) {
			addressBookMap.get(bookName);
			System.out.println("Enter book is present choose the options below to do certain function");
			while (true) {
				System.out.println("Enter\n 1. add Contact\n 2. edit contact\n 3. delete contact\n 4. previous menu");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					addressBookMap.get(bookName).addContact();
					break;
				case 2:
					addressBookMap.get(bookName).editContact();
					break;
				case 3:
					addressBookMap.get(bookName).deleteContact();
					break;
				case 4:
					return;
				default:
					System.out.println("Entered choice is incorrect!.. please enter correct choice");
				}
			}
		}
	}

	public void deleteBook() {
		System.out.println("Enter Address Book Name to Delete:");
		Scanner sc = new Scanner(System.in);
		String bookName = sc.next();
		if (addressBookMap.containsKey(bookName)) {
			addressBookMap.remove(bookName);
		}else
			System.out.println("Book Name is Nor Correct");
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

	public void toWriteIntoFile() {
		List<AddressBook>list =  addressBookMap.entrySet().stream()
								 .map(Map.Entry::getValue)
								 .collect(Collectors.toList());
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(FILE_NAME);
			for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
				pw.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
				for(AddressBook name:list) {
					pw.println("FirstName:"+name.firstName+"\n"
							+"LastName:"+name.lastName+"\n"
							+"Address:"+name.address+"\n"
							+"City:"+name.city+"\n"
							+"State:"+name.state+"\n"
							+"MobileNumber:"+name.mobileNumber+"\n"
							+"ZipCode:"+name.zipCode+"\n"
							+"emailId:"+name.emailId+"\n");
				}
				pw.flush();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			pw.close();
		}
		
	}

}
