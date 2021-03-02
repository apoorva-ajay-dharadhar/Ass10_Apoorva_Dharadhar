package com.psl.contact;

import com.psl.DBconnection.RemoveContactByID;
import com.psl.DBconnection.SearchByName;
import com.psl.DBconnection.SearchPhoneNumbers;
import com.psl.DBconnection.UpdateContact;
import com.psl.Exceptions.ContactNotFoundException;

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
		
		
		ContactService cs=new ContactService();
		List<Contact> contactList=new ArrayList<Contact>();
		int val;
		String ans="";
		boolean value=true;
		while(value==true)
		{
			System.out.println("1. Add contacts in the list");
			System.out.println("2. Remove contact from the list");
			System.out.println("3. Search the name in Contact List");
			System.out.println("4. Search phone numbers");
			System.out.println("5. Update contact numbers in contact ID");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter your option");
			int opt=sc.nextInt();
			sc.nextLine();
			switch(opt)
			{
				case 1:
				{
					Contact c=new Contact();
					contactList=cs.addContact(c, contactList);
					for(Contact c1: contactList)
					{
						System.out.println(c1);
					}
					break;
				}
				
				case 2:
				{
					Contact c=new Contact();
					RemoveContactByID rc=new RemoveContactByID();
					try {
						rc.processContactRemoval(contactList);
					} catch (ContactNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 3:
				{
					Scanner sc1=new Scanner(System.in);
					System.out.println("Enter the name to be searched");
					String name1=sc1.nextLine();
					SearchByName sm=new SearchByName();
					sm.process(name1, contactList);
					try {
						sm.searchContactByName(name1, contactList);
					} catch (ContactNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 4:
				{
					System.out.println("Enter the phone number you want to search");
					String n=sc.nextLine();
					SearchPhoneNumbers snum=new SearchPhoneNumbers();
					snum.process(n, contactList);
					break;
					
				}
				case 5:
				{
					System.out.println("You have opted for updation of contact number for a specific contact ID");
					System.out.println("Enter the contact ID for which you want to update the phone numbers");
					
					int id=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the new phone number");
					String newNum=sc.nextLine();
					UpdateContact uc=new UpdateContact();
					uc.addContactNumber(id, newNum, contactList);
					break;
				}
				
				case 6:
				{
					//6.	void sortContactsByName(List<Contact> contacts)
				}
			
			}
			
			System.out.println("Do you want to continue?(0/1)");
			int val1=sc.nextInt();
			if(val1==0)
			{
				value=false;
			}
		
		}
		
		
		
		
		
	}

}
