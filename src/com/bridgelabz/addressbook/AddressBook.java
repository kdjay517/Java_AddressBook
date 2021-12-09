package com.bridgelabz.addressbook;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of contacts you want to enter");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter the first Name the Person");
            String fName = scanner.next();
            if (fName.equals(person.getFirstName())) {
            	System.out.println("Person with First Name already exists.");
            	
            }else {
            	System.out.println("Enter the contact detais of the Person");
            	writeContact();
            	System.out.println("Contact details enterd"); 
            }   
        }
    }
    
    public void writeContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name : ");
        while(true) {
        	firstName = scanner.nextLine();
        	Pattern p = Pattern.compile(fNameregex);
        	Matcher m = p.matcher(firstName);
        	if (m.find() && m.group().equals(firstName)) {
        		System.out.println("valid");
        		break;
        	}else
        		System.out.println("invalid");
        }
        
        System.out.println("Enter Last Name : ");
        while (true) {
        	lastName = scanner.nextLine();
        	Pattern p = Pattern.compile(lNameRegex);
        	Matcher m = p.matcher(lastName);
        	if (m.find() && m.group().equals(lastName)) {
        		System.out.println("valid");
        		break;
        	}else
        		System.out.println("invalid");
        }
        
        System.out.println("Enter Address : ");
        while(true) {
        	address = scanner.nextLine();
        	Pattern p = Pattern.compile(addressRegex);
        	Matcher m = p.matcher(address);
        	if (m.find() && m.group().equals(address)) {
        		System.out.println("valid");
        		break;
        	}else
        		System.out.println("invalid");
        }
        
        System.out.println("Enter City : ");
        while (true) {
        	city = scanner.nextLine();
        	Pattern p = Pattern.compile(cityRegex);
        	Matcher m = p.matcher(city);
        	if (m.find() && m.group().equals(city)) {
        		System.out.println("valid");
        		break;
        	}else
        		System.out.println("invalid");
        }
        
        System.out.println("Enter State : ");
        while (true) {
            state = scanner.nextLine();
        	Pattern p = Pattern.compile(stateRegex);
        	Matcher m = p.matcher(state);
        	if (m.find() && m.group().equals(state)) {
        		System.out.println("valid");
        		break;
        	}else
        		System.out.println("invalid");
        }
    
        System.out.println("Enter ZipCode : ");
        while (true) {
        	zipCode = scanner.nextLine();
        	Pattern p = Pattern.compile(zipCodeRegex);
        	Matcher m = p.matcher(zipCode);
        	if (m.find() && m.group().equals(zipCode)) {
        		System.out.println("valid");
        		break;
        	}else
        		System.out.println("invalid");
        }
        
        System.out.println("Enter Mobile Number : ");
        while (true) {
        	mobileNumber = scanner.nextLine();
        	Pattern p = Pattern.compile(mNumRegex);
        	Matcher m = p.matcher(mobileNumber);
        	if (m.find() && m.group().equals(mobileNumber)) {
        		System.out.println("valid");
        		break;
        	}else
        		System.out.println("invalid");
        }
        
        System.out.println("Enter EmailId : ");
        while (true) {
        	emailId = scanner.nextLine();
        	Pattern p = Pattern.compile(emailRegex);
        	Matcher m = p.matcher(emailId);
        	if (m.find() && m.group().equals(emailId)) {
        		System.out.println("valid");
        		break;
        	}else
        		System.out.println("invalid");
        }
        
        person = new ContactDetails(firstName, lastName, address, city, state, zipCode, mobileNumber, emailId);
        contactDetailsList.add(person);
    }

    public void editContact() {
        System.out.println("Enter the first name of person to edit contact");
        Scanner scanner = new Scanner(System.in);
        String editName = scanner.next();
        boolean edited = false;
        for (int i = 0; i < contactDetailsList.size(); i++) {
            String name = contactDetailsList.get(i).getFirstName();
            if (name.equalsIgnoreCase(editName)) {
                contactDetailsList.remove(person);
                writeContact();
                edited = true;
                break;
            }
        }
        if (!edited) {
            System.out.println("enter name is incorrect");
        }
    }
    
    public void deleteContact() {
        System.out.println("Enter the first name of person to delete contact");
        Scanner scanner = new Scanner(System.in);
        String deleteName = scanner.next();
        int i = 0;
        for ( ;i < contactDetailsList.size(); i++) {
            String name = contactDetailsList.get(i).getFirstName();
            if (name.equalsIgnoreCase(deleteName)) {
                break;
            }
        }
        if (i < contactDetailsList.size()) {
            contactDetailsList.remove(i);
            System.out.println("Contact Deleted");
        }else {
            System.out.println("Contact not find");
        }
    }

	public boolean person(String place) {
		for (int i = 0; i < contactDetailsList.size();i++) {
			String city = contactDetailsList.get(i).getCity();
			String state = contactDetailsList.get(i).getState();
			if (city.equalsIgnoreCase(place) || state.equalsIgnoreCase(place)) {
				count++;
				return true;
			}
		}
		return false;
	}
}