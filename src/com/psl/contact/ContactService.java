package com.psl.contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.psl.DBconnection.AddContactToDB;

public class ContactService {
//	static //1.	Add contacts :- void addContact(Contact contact,List<Contact> contacts)
//	List<Contact> contacts=new ArrayList<Contact>();
	
	public void addContact(Contact contact, List<Contact> contacts)
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the contactId");
		int id=sc.nextInt();contact.setContactID(id);
		sc.nextLine();
		System.out.println("Enter Contact Name");
		String contactName=sc.nextLine();
		contact.setContactName(contactName);
		System.out.println("Enter Contact Email address");
		String contactEmail=sc.nextLine();
		contact.setEmailAddress(contactEmail);
		System.out.println("How many contact numbers do you want to add?");
		int n=sc.nextInt();
		sc.nextLine();
		List<String> contactNumbers=new ArrayList<String>();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Contact phonenumber:"+i);
			String contactNum=sc.nextLine();
			contactNumbers.add(contactNum);
		}
		contact.setContactNumber(contactNumbers);
		contacts.add(contact);
		AddContactToDB cdb=new AddContactToDB();
		cdb.insertContact(contacts);
		
	}
	
	
//	public static void main(String[] args)
//	{
//		ContactService cs=new ContactService();
//		Contact c=new Contact();
//		Contact c1=new Contact();
//		cs.addContact(c,contacts);
//		cs.addContact(c1, contacts);
//		System.out.println(contacts);
//	}
	
	
}
