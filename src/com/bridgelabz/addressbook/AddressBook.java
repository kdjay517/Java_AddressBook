package com.bridgelabz.addressbook;

public class AddressBook {
	private class Contact {
		String firstName, lastName, address, city, state, emailId;
		int zipCode;
		long mobileNumber;
	}

	public void printContact() {
		Contact person = new Contact();
		person.firstName = "Dhanunjaya";
		person.lastName = "Kummari";
		person.address = "Puttaparthi-M";
		person.city = "Ananthapur";
		person.state = "Andhra Pradesh";
		person.zipCode = 515134;
		person.mobileNumber = 1234567891L;
		person.emailId = "kdjay517@gmail.com";
		System.out.println("Contact Details");
		System.out.println("Name         : " + person.firstName + " " + person.lastName + "\n" + "Address      : "
				+ person.address + "\n" + "City         : " + person.city + "\n" + "State        : " + person.state
				+ "\n" + "ZipCode      : " + person.zipCode + "\n" + "MobileNumber : " + person.mobileNumber + "\n"
				+ "EmailId      : " + person.emailId + "\n");
	}

	public static void main(String[] args) {
		AddressBook addressBook = new AddressBook();
		addressBook.printContact();
	}
}
