package com.bridgelabz.addressbook;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MultipleAddressBooks {
	Map<String, AddressBook> addressBookMap = new HashMap<>();
	public final static String FILE_NAME = "Data/contactdetails.txt";
	public final static String JSON_FILE = "JSONFiles/output.json";
	private static final String path = "CSVFiles/output.csv";

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

	public void addressBookFunctions() throws IOException, ParseException {
		System.out.println("Enter the name of Address book to add, edit or delete the contact.");
		Scanner sc = new Scanner(System.in);
		String bookName = sc.nextLine();
		if (addressBookMap.containsKey(bookName)) {
			addressBookMap.get(bookName);
			System.out.println("Enter book is present choose the options below to do certain function");
			while (true) {
				System.out.println(
						"Enter\n 1. add Contact\n 2. add Contact by JSON \n 3. edit contact \n 4. delete contact\n 5. previous menu");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					addressBookMap.get(bookName).addContact();
					break;
				case 2:
					addressBookMap.get(bookName).addContactbyJSONFile();
					break;
				case 3:
					addressBookMap.get(bookName).editContact();
					break;
				case 4:
					addressBookMap.get(bookName).deleteContact();
					break;
				case 5:
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
		} else
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

	public void toWriteIntoTextFile() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(FILE_NAME);
			for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
				pw.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
				pw.println("FirstName:" + entry.getValue().firstName + "\nLastName:" + entry.getValue().lastName
						+ "\nAddress:" + entry.getValue().address + "\nCity:" + entry.getValue().city + "\nState:"
						+ entry.getValue().state + "\nZipcode:" + entry.getValue().zipCode + "\nMobileNumber:"
						+ entry.getValue().mobileNumber + "\nEmailId:" + entry.getValue().emailId);
			}
			pw.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public void toWriteIntoJASONFile() {
		JSONParser jsonparser = new JSONParser();
		PrintWriter pw = null;
		JSONObject obj = new JSONObject();

		try {
			pw = new PrintWriter(JSON_FILE);
			for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
				obj.put("FirstName:", entry.getValue().firstName);
				obj.put("LastName:", entry.getValue().lastName);
				obj.put("Address:", entry.getValue().address);
				obj.put("City:", entry.getValue().city);
				obj.put("State:", entry.getValue().state);
				obj.put("zipcode:", entry.getValue().zipCode);
				obj.put("mobileNumber:", entry.getValue().mobileNumber);
				obj.put("EmailId:", entry.getValue().emailId);
			}
			pw.println(obj.toJSONString());
			pw.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}

	}

	public void toWriteIntoCSVFile() {
		FileWriter filewriter = null;
		try {
			filewriter = new FileWriter(path);
			filewriter.append("FirstName, LastName, Address, City, State, ZipCode, MobileNumber, EmailId");
			filewriter.append("\n");
			for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
				filewriter.append(entry.getValue().firstName);
				filewriter.append(",");
				filewriter.append(entry.getValue().lastName);
				filewriter.append(",");
				filewriter.append(entry.getValue().address);
				filewriter.append(",");
				filewriter.append(entry.getValue().city);
				filewriter.append(",");
				filewriter.append(entry.getValue().state);
				filewriter.append(",");
				filewriter.append(entry.getValue().zipCode);
				filewriter.append(",");
				filewriter.append(entry.getValue().mobileNumber);
				filewriter.append(",");
				filewriter.append(entry.getValue().emailId);
				filewriter.append(",");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			try {
				filewriter.flush();
				filewriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
