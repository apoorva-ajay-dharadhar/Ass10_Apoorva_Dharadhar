package com.psl.contact;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class MainClass {

	public static Contact getContactDetails(Contact contact)
	{
		
		
		return contact;
		
	}
	
	public static void showContactDetails(Contact c)
	{
		System.out.println(c.getContactID());
		System.out.println(c.getContactName());
		System.out.println(c.getEmailAddress());
		System.out.println(c.getContactNumber());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("1. Add contacts(Into the List and update the database");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your option");
		int opt=sc.nextInt();
		ContactService cs=new ContactService();
		List<Contact> contactList=new ArrayList<Contact>();
		switch(opt)
		{
		case 1:
		{
			Contact c=new Contact();
			contactList=cs.addContact(c, contactList);
			System.out.println(contactList);
			break;
		}
		}
		
		
		
		
		
		
		
		//cs.addContact(c, ctc);
		//showContactDetails(c1);
		
	
		
		
	}

}
