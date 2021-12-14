package com.bridgelabz.addressbook;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AddressBook {

	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	String zipCode;
	String mobileNumber;
	String emailId;
	int count = 0;

	final String fNameregex = "^[A-Za-z]*$";
	final String lNameRegex = "^[A-Za-z]*$";
	final String addressRegex = "^[A-Z0-9a-z]*$";
	final String cityRegex = "^[A-Za-z]*$";
	final String stateRegex = "^[A-Za-z]*$";
	final String zipCodeRegex = "^[1-9]{6}$";
	final String mNumRegex = "^([+])?([91]{2})?[\\s]?[6-9][0-9]{9}$";
	final String emailRegex = "^[A-Za-z0-9]+([.+-_][0-9a-zA-Z])*[@]([0-9a-zA-Z])+[.][a-zA-z]{2,3}([.][a-zA-z]{2,3})?$";

	ContactDetails person = new ContactDetails();
	List<ContactDetails> contactDetailsList = new ArrayList<>();

	public void addContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of contacts you want to enter");
		int number = sc.nextInt();
		for (int i = 0; i < number; i++) {
			System.out.println("Enter the first Name the Person");
			String fName = sc.next();
			if (fName.equals(person.getFirstName())) {
				System.out.println("Person with First Name already exists.");

			} else {
				System.out.println("Enter the contact detais of the Person");
				writeContact();
				System.out.println("Contact details enterd");
			}
		}
	}

	public void writeContact() {
		IAddressBook ab = (data, regex) -> {
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(data);
			return m.find() && m.group().equals(data);
		};
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name : ");

		while (true) {
			firstName = sc.nextLine();
			if (ab.userValidation(firstName, fNameregex)) {
				System.out.println("valid");
				break;
			} else
				System.out.println("invalid");
		}

		System.out.println("Enter Last Name : ");
		while (true) {
			lastName = sc.nextLine();
			if (ab.userValidation(lastName, lNameRegex)) {
				System.out.println("valid");
				break;
			} else
				System.out.println("invalid");
		}

		System.out.println("Enter Address : ");
		while (true) {
			address = sc.nextLine();
			if (ab.userValidation(address, addressRegex)) {
				System.out.println("valid");
				break;
			} else
				System.out.println("invalid");
		}

		System.out.println("Enter City : ");
		while (true) {
			city = sc.nextLine();
			if (ab.userValidation(city, cityRegex)) {
				System.out.println("valid");
				break;
			} else
				System.out.println("invalid");
		}

		System.out.println("Enter State : ");
		while (true) {
			state = sc.nextLine();
			if (ab.userValidation(state, stateRegex)) {
				System.out.println("valid");
				break;
			} else
				System.out.println("invalid");
		}

		System.out.println("Enter ZipCode : ");
		while (true) {
			zipCode = sc.nextLine();
			if (ab.userValidation(zipCode, zipCodeRegex)) {
				System.out.println("valid");
				break;
			} else
				System.out.println("invalid");
		}

		System.out.println("Enter Mobile Number : ");
		while (true) {
			mobileNumber = sc.nextLine();
			if (ab.userValidation(mobileNumber, mNumRegex)) {
				System.out.println("valid");
				break;
			} else
				System.out.println("invalid");
		}

		System.out.println("Enter EmailId : ");
		while (true) {
			emailId = sc.nextLine();
			if (ab.userValidation(emailId, emailRegex)) {
				System.out.println("valid");
				break;
			} else
				System.out.println("invalid");
		}

		person = new ContactDetails(firstName, lastName, address, city, state, zipCode, mobileNumber, emailId);
		contactDetailsList.add(person);
	}

	public void serachbyName(String Name) {
		List<ContactDetails> collect = contactDetailsList.stream().filter(p -> p.getFirstName().equalsIgnoreCase(Name))
				.collect(Collectors.toList());
		for (ContactDetails contact : collect) {
			System.out.println("Search Result:" + contact);
		}
	}

	public void searchbyCity(String city) {
		List<ContactDetails> collect = contactDetailsList.stream().filter(p -> p.getCity().equalsIgnoreCase(city))
				.collect(Collectors.toList());
		for (ContactDetails contact : collect) {
			System.out.println("Search Result:" + contact);
		}
	}

	public void searchbyState(String state) {
		List<ContactDetails> collect = contactDetailsList.stream().filter(p -> p.getState().equalsIgnoreCase(state))
				.collect(Collectors.toList());
		for (ContactDetails contact : collect) {
			System.out.println("Search Result:" + contact);
		}
	}

	public void countbyCityName(String city) {
		long count = contactDetailsList.stream().filter(p -> p.getCity().equalsIgnoreCase(city)).count();
		System.out.println("Persons in Same in City" + count);
	}

	public void sortbyName() {
		List<ContactDetails> list = contactDetailsList.stream().collect(Collectors.toList());
		list.stream().sorted((g1, g2) -> ((String) g1.getFirstName()).compareTo(g2.getFirstName()))
				.forEach(contact -> System.out.println(contact.getFirstName() + " " + contact.getLastName()));
	}

	public void sortbyCity() {
		List<ContactDetails> list = contactDetailsList.stream().collect(Collectors.toList());
		list.stream().sorted((g1, g2) -> ((String) g1.getCity()).compareTo(g2.getCity()))
				.forEach(contact -> System.out.println(contact.getFirstName() + " " + contact.getLastName()));
	}
	
	public void sortbyZip() {
		List<ContactDetails> list = contactDetailsList.stream().collect(Collectors.toList());
		list.stream().sorted((g1, g2) -> ((String) g1.getZipCode()).compareTo(g2.getZipCode()))
				.forEach(contact -> System.out.println(contact.getFirstName() + " " + contact.getLastName()));
	}
	
	public void editContact() {
		System.out.println("Enter the first name of person to edit contact");
		Scanner sc = new Scanner(System.in);
		String editName = sc.next();
		for (int i = 0; i < contactDetailsList.size(); i++) {
			String name = contactDetailsList.get(i).getFirstName();
			if (name.equalsIgnoreCase(editName)) {
				System.out.println("Enter name is exit. you can edit the details");
				while (true) {
					System.out.println(
							"Enter\n 1. To edit all details\n 2. To edit certain detail\n 3. for previous menu");
					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						contactDetailsList.remove(i);
						writeContact();
						break;
					case 2:
						while (true) {
							System.out.println(
									"Enter\n 1. for First Name\n 2. for Last Name\n 3. for City\n 4. for State\n"
											+ " 5. for Zip Code\n 6. for Phone\n 7. forEmail\n 8. for previous menu");
							int option = sc.nextInt();
							switch (option) {
							case 1:
								System.out.println("Enter new First Name");
								String newFirstName = sc.next();
								contactDetailsList.get(i).setFirstName(newFirstName);
								break;
							case 2:
								System.out.println("Enter new Last Name");
								String newLastName = sc.next();
								contactDetailsList.get(i).setLastName(newLastName);
								break;
							case 3:
								System.out.println("Enter new City Name");
								String newCity = sc.next();
								contactDetailsList.get(i).setLastName(newCity);
								break;
							case 4:
								System.out.println("Enter new State Name");
								String newState = sc.next();
								contactDetailsList.get(i).setLastName(newState);
								break;
							case 5:
								System.out.println("Enter new ZipCode Name");
								String newZipCode = sc.next();
								contactDetailsList.get(i).setLastName(newZipCode);
								break;
							case 6:
								System.out.println("Enter new MobileNumber Name");
								String newMobileNumber = sc.next();
								contactDetailsList.get(i).setLastName(newMobileNumber);
								break;
							case 7:
								System.out.println("Enter new MailId Name");
								String newMailId = sc.next();
								contactDetailsList.get(i).setLastName(newMailId);
								break;
							case 8:
								return;
							default:
								System.out.println("Entered choice is incorrect!.. please enter correct choice");
							}
						}
					case 3:
						return;
					default:
						System.out.println("Entered choice is incorrect!.. please enter correct choice");
					}
				}
			} else {
				System.out.println("enter name not exist");
			}
		}
	}

	public void deleteContact() {
		System.out.println("Enter the first name of person to delete contact");
		Scanner sc = new Scanner(System.in);
		String deleteName = sc.next();
		boolean t = contactDetailsList.removeIf(a -> a.getFirstName().equalsIgnoreCase(deleteName));
		if (t) {
			System.out.println("Deleted Successfully");
		}else
			System.out.println("Enter correct Details");
	}

	public void viewByOptions() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter\n 1. By name\n 2. By city\n 3. By state\n 4. Count Contacts\n"
					+ "5. Sort the entries Alphabetically\n 0. for previous menu");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter name: ");
				String name = scanner.nextLine();
				serachbyName(name);
				break;
			case 2:
				System.out.println("Enter city: ");
				String city = scanner.nextLine();
				searchbyCity(city);
				break;
			case 3:
				System.out.println("Enter state: ");
				String state = scanner.nextLine();
				searchbyState(state);
				break;
			case 4:
				System.out.println("Enter The Name Of City");
				String cityName = scanner.next();
				countbyCityName(cityName);
			case 5:
				sortbyName();
				break;
			case 6:
				sortbyCity();
			case 0:
				return;
			default:
				System.out.println("Entered choice is incorrect!.. please enter correct choice");
			}
		}
	}
}
